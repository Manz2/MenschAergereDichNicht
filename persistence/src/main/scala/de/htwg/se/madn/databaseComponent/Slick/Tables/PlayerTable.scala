package de.htwg.se.madn
package databaseComponent

import slick.jdbc.PostgresProfile.api.*
class PlayerTable(tag:Tag) extends Table[(String)](tag,"Player"){
    def name = column[String]("name",O.PrimaryKey)
    override def * = (name)
}
