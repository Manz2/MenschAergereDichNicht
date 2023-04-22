package de.htwg.se.madn

import com.google.inject.Guice
import scala.io.StdIn.readLine
import scala.collection.immutable.LazyList.cons
import fileIoComponent.fileIoJsonImpl.fileIOAPI
import scala.util.{Try,Success,Failure}

object Madn {
  @main def main: Unit = {
    Try(fileIOAPI) match
      case Success(v) => println("Persistance Rest Server is running!")
      case Failure(v) => println("Persistance Server couldn't be started! " + v.getMessage + v.getCause)
  }
}