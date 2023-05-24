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
    val autoSave: Document = Document("_id" -> "autoSave", "game" -> "")
    observerInsertion(gameCollection.insertOne(autoSave))
    }

   def update(input:String) =
    println("update")
    observerUpdate(gameCollection.updateOne(equal("_id","autoSave"), set("game", input)))

  
  def delete:Unit = {
    Await.result(deleteFuture, Duration.Inf)
  }

  private def deleteFuture:Future[String] = {
    gameCollection.deleteMany(equal("_id", "autoSave")).subscribe(
      (dr: DeleteResult) => println(s"Deleted autoSave"),
    )
    Future {
      "deleted"
    }
  }

  def read:String =
    val autoSave: Document = Await.result(gameCollection.find(equal("_id", "autoSave")).first().head(), Duration.Inf)
    autoSave("game").asString().getValue.toString


  private def observerInsertion(insertObservable: SingleObservable[InsertOneResult]): Unit = {
    insertObservable.subscribe(new Observer[InsertOneResult] {
      override def onNext(result: InsertOneResult): Unit = println(s"inserted: $result")

      override def onError(e: Throwable): Unit = println(s"errorwhile inserting: $e")

      override def onComplete(): Unit = println("insert completed")
    })
  }

  private def observerUpdate(insertObservable: SingleObservable[UpdateResult]): Unit = {
    insertObservable.subscribe(new Observer[UpdateResult] {
      override def onNext(result: UpdateResult): Unit = println(s"updated: $result")

      override def onError(e: Throwable): Unit = println(s"Error while updating: $e")

      override def onComplete(): Unit = println("updated")
    })
  }


}
