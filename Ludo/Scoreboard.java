import greenfoot.*;
//import java.util.*;
import java.awt.*;

/**
 * Write a description of class Scoreboard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scoreboard extends Actor
{
    /**
     * Act - do whatever the Scoreboard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    String note;
    
    public Scoreboard(String note)
    {
        setNotification(note);
    }
    public void setNotification(String note)
    {
      setImage("Notification.png");
      GreenfootImage image = getImage();
      // Font font = image.getFont();
      Font font = new Font("Monotype Corsiva", Font.BOLD,40);
       //font = font.deriveFont(FONT_SIZE);
      this.note = note;
      image.setFont(font);
      image.setColor(Color.red);
      image.drawString(note,30, 30);
    }
}
