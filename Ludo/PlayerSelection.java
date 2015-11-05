import greenfoot.*;
import java.awt.*;

/**
 * Write a description of class Players here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerSelection extends Actor
{
    private  int NoOfPlayers = 1;
    /**
     * Act - do whatever the Players wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public PlayerSelection()
    {
        
    }

    public PlayerSelection(int NoOfPlayers)
    {
        makeImage(Integer.toString(NoOfPlayers));
        this.NoOfPlayers = NoOfPlayers;
        
    }
    
    private void makeImage(String title)
    {
        
       
      setImage("ball.png");
      GreenfootImage image = getImage();
      // Font font = image.getFont();
      Font font = new Font("Algerian", Font.BOLD,38);
       //font = font.deriveFont(FONT_SIZE);
      image.setFont(font);
      image.setColor(Color.black);
      image.drawString(title, 30, 55);
      //image.drawString(title, x, y);

    }
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this))
        {
           Greenfoot.playSound("click.wav");
          PlayGame.NoOfPlayers = this.NoOfPlayers;
        }
    }    
}
