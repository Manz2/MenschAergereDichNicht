package de.htwg.se.madn

import FieldComponent.FieldInterface
import FieldComponent.fieldBaseImpl.Field
import FigureComponent.FigureBaseImpl.Figure
import FigureComponent.FigureInterface
import play.api.libs.json._

trait Command {
  def doStep: FieldInterface
  def undoStep:FieldInterface
  def redoStep:FieldInterface
}



object UndoManager{
    private var undoStack: List[Command] = Nil
    private var redoStack: List[Command] = Nil
    def doStep(stringCommand:String) : String =
        val json: JsValue = Json.parse(stringCommand)
        val fig = (json \ "Figur").as[String]
        val anzahl = (json \ "Anzahl").as[String].toInt
        val field_ = (json \ "Field").as[List[String]]
        val field = Field(Vector(field_.map(f => if (f == "-1") Figure("",-1) else Figure(f.charAt(0).toString,f.charAt(1).toString.toInt))).flatten)
        val command= new MoveCommand(Figure(fig.charAt(0).toString,fig.charAt(1).toString.toInt),anzahl,field)
        undoStack = command :: undoStack
        val fieldField : Vector[String] = command.doStep.data.map(f => f.playerName + f.number)
        val jsonReturn : JsValue = Json.obj(
            "Field" -> Json.toJson(fieldField)
        )
        jsonReturn.toString

        
    def undoStep(field:FieldInterface) : FieldInterface =
        undoStack match {
            case Nil => field//""
            case head :: stack => {
                val result = head.undoStep
                undoStack = stack
                redoStack = head :: redoStack
                result
            }
        }
    def redoStep(field:FieldInterface) : FieldInterface =
        redoStack match {
            case Nil => field
            case head::stack => {
                val result = head.redoStep
                redoStack = stack
                undoStack = head::undoStack
                result
            }
        }
    }