import greenfoot.*;
import java.awt.*;
/**
 * Write a description of class Board here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Board extends World
{
    //private Text scoreLabel;
   
  
    
    /**
     * Constructor for objects of class Board.
     * 
     */
    public Board()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1400, 850, 1);
        addObject (new StartupMenu(), 1100, getHeight()/2-100);
        addObject (new PlayGame(), 1100, getHeight()/2+10);
        addObject (new PlayerSelection(1), 1050, getHeight()/2-150);
        addObject (new PlayerSelection(2), 1150, getHeight()/2-150);
        addObject (new PlayerSelection(3), 1050, getHeight()/2-80);
        addObject (new PlayerSelection(4), 1150, getHeight()/2-80);
        addObject (new Ruleboard(), 1098, 699);
        
        
         
          
    }
    
   
    
    
}
