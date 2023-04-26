package de.htwg.se.madn

import com.google.inject.Guice
import scala.io.StdIn.readLine
import scala.collection.immutable.LazyList.cons
import scala.util.{Try,Success,Failure}

object Madn {
  @main def main: Unit = {
    Try(commandAPI) match
      case Success(v) => println("Command Rest Server is running!")
      case Failure(v) => println("Command Server couldn't be started! " + v.getMessage + v.getCause)

    print("Server started\n")  
    val input = readLine()
  }
}