package de.htwg.se.madn
package databaseComponent

import slick.jdbc.PostgresProfile.api.*
class FieldTable(tag:Tag) extends Table[(String)](tag,"Field"){
    def name = column[String]("name",O.PrimaryKey)
    override def * = (name)
}
