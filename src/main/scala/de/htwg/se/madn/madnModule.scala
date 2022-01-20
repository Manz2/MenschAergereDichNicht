
package de.htwg.se.madn

import com.google.inject.AbstractModule
import com.google.inject.name.Names
import net.codingwell.scalaguice.ScalaModule

import model.PlayerComponent.PlayerInterface
import model.HomeComponent.HomeInterface
import model.FieldComponent.FieldInterface
import model.PlayerComponent._
import model.HomeComponent._
import model.FieldComponent._
import scala.util.{Try,Success,Failure}
import util.Observer
import scala.io.StdIn.readLine
import scala.util.Random
import Controller.controllerComponent.ControllerInterface
import Controller.controllerComponent._
import scala.io.StdIn.readLine



class madnModule extends AbstractModule {

    val defaultSize:Int = 9

    override def configure():Unit = {
        bind(classOf[PlayerInterface]).to(classOf[PlayerBaseImpl.Player])
        bind(classOf[HomeInterface]).to(classOf[HomeBaseImpl.Home])
        bind(classOf[FieldInterface]).to(classOf[fieldBaseImpl.Field])
        bind(classOf[ControllerInterface]).to(classOf[controllerBaseImpl.Controller])
    }
}
