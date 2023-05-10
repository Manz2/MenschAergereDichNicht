package de.htwg.se.madn
package databaseComponent

import slick.jdbc.PostgresProfile.api.*
class IndexTable(Tag:tag) extends Table[(Int,Int,String,Int)](tag,"Figure"){
    def id = column[Int]("id",O.PrimaryKey,O.AutoInc)
    def figure = column[Int]("id",O.ForeignKey)
    def field = column[String]("name",O.ForeignKey)
    def index = cloumn[Int]("index")
    override def * = (id,figure,field,index)
}
