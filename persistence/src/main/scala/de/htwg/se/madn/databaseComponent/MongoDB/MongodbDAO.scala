package de.htwg.se.madn
package databaseComponent

import play.api.libs.json.{JsArray, JsValue, Json}
import org.mongodb.scala.*
import org.mongodb.scala.model.Updates.set
import org.mongodb.scala.model.Filters.*
import org.mongodb.scala.result.{DeleteResult, InsertOneResult, UpdateResult}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success, Try}
import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration

object MongodbDAO {
  
  val database_pw = sys.env.getOrElse("MONGO_INITDB_ROOT_PASSWORD", "mongo").toString
  val database_username = sys.env.getOrElse("MONGO_INITDB_ROOT_USERNAME", "root").toString

  val uri: String = s"mongodb://$database_username:$database_pw@localhost:27017/?authSource=admin"
  val client: MongoClient = MongoClient(uri)
  val db: MongoDatabase = client.getDatabase("madn")
  val gameCollection: MongoCollection[Document] = db.getCollection("game")

  def create:Unit ={
    val gameDocument: Document = Document("_id" -> "gameDocument", "game" -> "")
    println("[CREATE mdbdao]")
    observerInsertion(gameCollection.insertOne(gameDocument))
    
    }

   def update(input:String) =
    println("[UPDATE mdbdao] " + input)
    observerUpdate(gameCollection.updateOne(equal("_id","gameDocument"), set("game", input)))

  /** DELETE */
  def delete:Unit = {
    Await.result(deleteFuture, Duration.Inf)
    println("[DELETE mdbdao]")
  }

  private def deleteFuture:Future[String] = {
    gameCollection.deleteMany(equal("_id", "gameDocument")).subscribe(
      (dr: DeleteResult) => println(s"Deleted gameDocument"),
      (e: Throwable) => println(s"Error while trying to delete gameDocument: $e")
    )
    Future {
      "Finished deleting!"
    }
  }

  def read:String =
    val gameDocument: Document = Await.result(gameCollection.find(equal("_id", "gameDocument")).first().head(), Duration.Inf)
    gameDocument("game").asString().getValue.toString


  private def observerInsertion(insertObservable: SingleObservable[InsertOneResult]): Unit = {
    insertObservable.subscribe(new Observer[InsertOneResult] {
      override def onNext(result: InsertOneResult): Unit = println(s"inserted: $result")

      override def onError(e: Throwable): Unit = println(s"insert onError: $e")

      override def onComplete(): Unit = println("completed insert")
    })
  }

  private def observerUpdate(insertObservable: SingleObservable[UpdateResult]): Unit = {
    insertObservable.subscribe(new Observer[UpdateResult] {
      override def onNext(result: UpdateResult): Unit = println(s"updated: $result")

      override def onError(e: Throwable): Unit = println(s"update onError: $e")

      override def onComplete(): Unit = println("completed update")
    })
  }


}
