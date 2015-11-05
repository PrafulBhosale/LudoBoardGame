import greenfoot.*;
import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;
import java.util.List;

/**
 * Write a description of class StartupMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartupMenu extends Actor
{
    public static final float FONT_SIZE = 48.0f;
    
    
    /**
     * Act - do whatever the StartupMenu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
       
    }  
    
    public StartupMenu()
    {
       // this(100);
        makeImage("Ludo Game");
        
    }
    
    private void makeImage(String title)
    {
        
        //GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);
       // GreenfootImage image = new GreenfootImage("Menu.png");
       setImage("Menu.png");
       GreenfootImage image = getImage();
      // Font font = image.getFont();
      Font font = new Font("Algerian", Font.BOLD,(int)FONT_SIZE);
       //font = font.deriveFont(FONT_SIZE);
      
      image.setFont(font);
      image.setColor(Color.black);
      image.drawString(title, 160, 150);
      Font font1 = new Font("Algerian", Font.BOLD,30);
       //font = font.deriveFont(FONT_SIZE);
      image.setFont(font1);
      image.setColor(Color.gray);
      image.drawString("Select Players", 160, 200);
      

//         image.setColor(new Color(252,208,102, 128));
//         image.fillRect(0, 0, WIDTH, HEIGHT);
//         image.setColor(new Color(146, 103, 1));
//         image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
//            Font font = image.getFont();
//            font = font.deriveFont(FONT_SIZE);
//              image.setFont(font);
//              image.setColor(Color.WHITE);
//            image.drawString(title, 60, 100);
//         
//         setImage(image);
    }
}
