package de.htwg.se.madn
package databaseComponent

import slick.jdbc.PostgresProfile.api.*
class FigureTable(tag:Tag) extends Table[(Int,Int,String)](tag,"Figure"){
    def id = column[Int]("id",O.PrimaryKey,O.AutoInc)
    def number = column[Int]("number")
    def player = column[String]("name",O.ForeignKey)
    override def * = (id,number,player)
}
