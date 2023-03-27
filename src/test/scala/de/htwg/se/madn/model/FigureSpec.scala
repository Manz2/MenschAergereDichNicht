package de.htwg.se.madn
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

import model.FigureComponent.FigureBaseImpl.Figure
import model.FigureComponent.FigureInterface
import scala.language.postfixOps

class FigureSpec extends AnyWordSpec with Matchers:
  "Figure" should {
    "compare two similar Figures as true" in {
      val figure1 = Figure("A",1)
      val figure2 = Figure("A",1)
      figure1.equals(figure2) should be(true)
    }
    "compare two different Figures as false" in {
      val figure1 = Figure("A",1)
      val figure2 = Figure("B",1)
      figure1.equals(figure2) should be(false)
    }
    "compare two different Figures in number as false" in {
      val figure1 = Figure("A",1)
      val figure2 = Figure("A",2)
      figure1.equals(figure2) should be(false)
    }
  }