package de.htwg.se.madn
package databaseComponent


import slick.jdbc.PostgresProfile.api.*
import slick.jdbc.JdbcBackend.Database
import slick.lifted.TableQuery
import slick.jdbc.PostgresProfile.api.*

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.{Duration, DurationInt}
import scala.concurrent.{Await, Future}
import scala.io.StdIn
import scala.util.{Failure, Success, Try}
import slick.lifted.Tag
import play.api.libs.json._
import scala.collection.mutable.ArrayBuffer


object IndexDAO{
  val connectIP = sys.env.getOrElse("POSTGRES_IP", "localhost").toString
  val connectPort = sys.env.getOrElse("POSTGRES_PORT", 5432).toString.toInt
  val database_user = sys.env.getOrElse("POSTGRES_USER", "postgres").toString
  val database_pw = sys.env.getOrElse("POSTGRES_PASSWORD", "postgres").toString
  val database_name = sys.env.getOrElse("POSTGRES_DB", "postgres").toString


  val  database =
    Database.forURL(
      url = "jdbc:postgresql://" + connectIP + ":" + connectPort + "/" + database_name + "?serverTimezone=UTC",
      user = database_user,
      password = database_pw,
      driver = "org.postgresql.Driver")

  val indexTable = TableQuery(new IndexTable(_))

  def create: Unit = {
    val running = Future(Await.result(database.run(DBIO.seq(
      indexTable.schema.createIfNotExists,
    )), Duration.Inf))
    running.onComplete{
      case Success(_) => println("Connection to DB & Creation of Tables successful!")
      case Failure(e) => println("Error: " + e)
    }
  }
  def update(figure: String, field:String, index:Int):Unit = {
     val insertAction = indexTable returning indexTable.map(_.id) 
      += (0,figure,field,index)
     database.run(insertAction)
  }

  def read: Future[JsValue] = {
    database.run(indexTable.result).map { rows =>
      val arrayField = Array.fill[String](20)("-1")
      val arrayPlayer = Array.fill[String](4)("-1")
      val arrayHome = Array.fill[String](4)("-1")
  
      rows.map {
        case (id, figure, field, index) =>
          field.toString match {
            case "Field" => arrayField(index.asInstanceOf[Int]) = figure
            case "Player" => arrayPlayer(index.asInstanceOf[Int]) = figure
            case "Home" => arrayHome(index.asInstanceOf[Int]) = figure
          }
      }
  
      val jsObj = Json.obj(
        "Field" -> Json.toJson(arrayField.toVector),
        "Player" -> Json.toJson(arrayPlayer.toVector),
        "Home" -> Json.toJson(arrayHome.toVector)
      )
      jsObj
    }
  }




   //def update(input:String):Unit
   def delete: Unit = {
     val deleteAction = indexTable.delete
     
     val resultFuture = database.run(deleteAction)
 
     resultFuture.onComplete {
      case Success(numRowsDeleted) => println(s"Deleted $numRowsDeleted rows from table.")
      case Failure(ex) => println(s"Error deleting rows: ${ex.getMessage}")
    }
   }
}