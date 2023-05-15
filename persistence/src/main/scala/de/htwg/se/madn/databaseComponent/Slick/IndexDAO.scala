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

object IndexDAO{
  val connectIP = sys.env.getOrElse("POSTGRES_IP", "localhost").toString
  val connectPort = sys.env.getOrElse("POSTGRES_PORT", 5432).toString.toInt
  val database_user = sys.env.getOrElse("POSTGRES_USER", "postgres").toString
  val database_pw = sys.env.getOrElse("POSTGRES_PASSWORD", "postgres").toString
  val database_name = sys.env.getOrElse("POSTGRES_DB", "postgres").toString

  val database =
    Database.forURL(
      url = "jdbc:postgresql://" + connectIP + ":" + connectPort + "/" + database_name + "?serverTimezone=UTC",
      user = database_user,
      password = database_pw,
      driver = "org.postgresql.Driver")

  val indexTable = TableQuery(new IndexTable(_))

  def create: Unit = {
    //database.run(fieldTable.schema.create)
    val running = Future(Await.result(database.run(DBIO.seq(
      indexTable.schema.createIfNotExists,
    )), Duration.Inf))
    running.onComplete{
      case Success(_) => println("Connection to DB & Creation of Tables successful!")
      case Failure(e) => println("Error: " + e)
    }
  }
  def update(figure: Int, field:String, index:Int):Unit = {
     val insertAction = indexTable returning indexTable.map(_.id) 
      += (0,figure,field,index)
    database.run(insertAction)
  }
  def read:String = {
  //  val player1Query = sql"""SELECT * FROM "FIELD" """.as[(String)]
  //  val result1 = Await.result(database.run(player1Query), atMost = 10.second)
  //  result1
  ""
  }
  //def update(input:String):Unit
  //def delete: Unit
}
