package de.htwg.se.madn
package databaseComponent
import slick.lifted.Tag

import slick.jdbc.PostgresProfile.api.*
class IndexTable(tag:Tag) extends Table[(Int,String,String,Int)](tag,"Index"){
    def id = column[Int]("id",O.PrimaryKey,O.AutoInc)
    def figure = column[String]("idf")//,O.ForeignKey)
    def field = column[String]("name")//,O.ForeignKey)
    def index = column[Int]("index")
    override def * = (id,figure,field,index)
}
