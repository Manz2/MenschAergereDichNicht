package de.htwg.se.madn
package databaseComponent


trait DAOInterface {
  def create: Unit
  def read:String
  def update(input:String):Unit
  def delete: Unit
}
