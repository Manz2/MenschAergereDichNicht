import swing._                                                          
import javax.swing.ImageIcon
import java.awt.Graphics                                           

case class ImagePanel(parameter : String) extends Panel                                                
{                                                                             
  var image = new ImageIcon(parameter).getImage

  override def paintComponent(g:Graphics2D) =                                 
  {
    super.paintComponent(g)
    drawingIcon(g)
  }
  
  def drawingIcon(g:Graphics) = 
  {
      g.drawImage(image,200,200,null)
  }                                                                      
}