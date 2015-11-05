import greenfoot.*;
import java.awt.*;

/**
 * Write a description of class Blackboard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Blackboard extends Actor
{
    GreenfootImage background;
    
    
    /**
     * Act - do whatever the Blackboard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
//     GreenfootImage UserImage = new GreenfootImage("User.png");
//     
//     GreenfootImage ComputerImage = new GreenfootImage("Computer.png");
    public Blackboard()
    {
        background = getImage();
    }
    public Blackboard(int NoOfPlayers)
    { 
       makeImage(NoOfPlayers);
      
    }
    
    public void makeImage(int NoOfPlayers)
    {
       setImage("blackboard.png");
        int x = 50;
       int y = 75;  
       
        background = getImage();
        Font font1 = new Font("Algerian", Font.BOLD,30);
       
        Color []c = {Color.red,Color.blue,Color.yellow,Color.green};
        
       for(int i = 1; i <= 4; i++)
       {
           if(i <= NoOfPlayers )
         
              background.drawImage(new GreenfootImage("User.png"), x, y);
                       
          else      
             background.drawImage(new GreenfootImage("Computer.png"), x, y);
             
           background.setFont(font1);
           background.setColor(c[i-1]);  
           background.drawString("Player "+i,110,y+30);
           
             y += 50; 
           //getWorld().addObject(new Text("0"),1250,y+65);  
           
       }
      // background.drawImage(new GreenfootImage("Dice1.png"),300,60);
    }
    

    
    public void act() 
    {
        // Add your action code here.
    } 
    
    
}
