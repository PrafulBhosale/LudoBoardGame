import greenfoot.*;
import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;
import java.util.List;
import java.util.*;
/**
 * Write a description of class PlayGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayGame extends Actor
{
    public static final float FONT_SIZE = 40.0f;
    public static int NoOfPlayers = 1;
     RedPlayer []r;
     BluePlayer []b;
     YellowPlayer []y;
     GreenPlayer []g;
     
    static Scoreboard sb = new Scoreboard("Roll Dice"); 
    //Player p;
    
    /**
     * Act - do whatever the PlayGame wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
       
        
        // Add your action code here.
        if(Greenfoot.mouseClicked(this))
           {
            Greenfoot.playSound("click.wav");   
            setUpPlayers(NoOfPlayers);
           }
          
                
    }
    public PlayGame()
    {
        
          makeImage("Play");
          r = new RedPlayer[4];
          b = new BluePlayer[4];
          y = new YellowPlayer[4];
          g = new GreenPlayer[4]; 
         
    }
    
    
    private void makeImage(String title)
    {
       
       setImage("Play.png");
       GreenfootImage image = getImage();
      // Font font = image.getFont();
      Font font = new Font("Algerian", Font.BOLD,(int)FONT_SIZE);
       //font = font.deriveFont(FONT_SIZE);
      image.setFont(font);
      image.setColor(Color.white);
      image.drawString(title,35,50);
    }
       
    public void setUpPlayers(int NoOfPlayers)
    {
        setupRedPlayers(NoOfPlayers);
        setupBluePlayers(NoOfPlayers);
        setupYellowPlayers(NoOfPlayers);
        setupGreenPlayers(NoOfPlayers);
        getWorld().addObject(new Blackboard(NoOfPlayers),1105,187);
        getWorld().addObject(new Dice(),1089,500);
        Dice.startGame = true;
        
        if(Dice.startGame == true)    
        getWorld().addObject(PlayGame.sb,1102,663);
        
        getWorld().addObject(new Text("0"),1175,135);
        getWorld().addObject(new Text("0"),1175,185);
        getWorld().addObject(new Text("0"),1175,235);
        getWorld().addObject(new Text("0"),1175,285);
        //getWorld().addObject(new Text("0"),1250,140);
        
        Greenfoot.playSound("ping.wav");
        //getWorld().addObject(new Text("0"),1200,80);     
             //removeTouching();
             Actor menu = getOneObjectAtOffset(0,0,StartupMenu.class);
             if(menu != null)
             {
             getWorld().removeObject(menu);
            }
            
            List<Actor> rule = getWorld().getObjects(Ruleboard.class);
             if(rule.get(0) != null)
             {
             getWorld().removeObject(rule.get(0));
            }
            
            List<Actor> ps = getWorld().getObjects(PlayerSelection.class);
            for(Actor a : ps)
            {
             getWorld().removeObject(a);
            }
             getWorld().removeObject(this);
             
             //GreenfootImage play = new GreenfootImage("blackboard.png");
             
             
    }
    
    public void setupRedPlayers(int NoOfPlayers)
    {
        r[0]= new RedPlayer(591,179);
        r[1]= new RedPlayer(660,111);
        r[2]= new RedPlayer(728,179);
        r[3]= new RedPlayer(660,247);

         getWorld().addObject(r[0],591,179);
         getWorld().addObject(r[1],660,111);
         getWorld().addObject(r[2],728,179);
         getWorld().addObject(r[3],660,247);
         
        for(int i = 0; i < 4; i++) 
        {
         r[i].setIsComputer(false);   
         r[i].setAlive(true);   
         r[i].setActive(false);
         r[i].setAtHome(true);
         r[i].setStepcount(0);
         r[i].setStartX(478);
         r[i].setStartY(74);
         r[i].setGoalX(406);
         r[i].setGoalY(433);
        }
         
    }
    
     public void setupBluePlayers(int NoOfPlayers)
    {
        b[0]= new BluePlayer(591,687);
        b[1]= new BluePlayer(660,619);
        b[2]= new BluePlayer(728,687);
        b[3]= new BluePlayer(660,756);

         getWorld().addObject(b[0],591,687);
         getWorld().addObject(b[1],660,619);
         getWorld().addObject(b[2],728,687);
         getWorld().addObject(b[3],660,756);
         
         for(int i = 0; i < 4; i++) 
        {
            if(NoOfPlayers < 2)
            b[i].setIsComputer(true);
         b[i].setAlive(true);
         b[i].setActive(false);
         b[i].setAtHome(true);
         b[i].setStepcount(0);
         b[i].setStartX(765);
         b[i].setStartY(504);
         b[i].setGoalX(406);
         b[i].setGoalY(433);
        }
    }
     public void setupYellowPlayers(int NoOfPlayers)
    {
        y[0]= new YellowPlayer(83,687);
        y[1]= new YellowPlayer(152,619);
        y[2]= new YellowPlayer(220,687);
        y[3]= new YellowPlayer(152,756);

         getWorld().addObject(y[0],83,687);
         getWorld().addObject(y[1],152,619);
         getWorld().addObject(y[2],220,687);
         getWorld().addObject(y[3],152,756);
         
         for(int i = 0; i < 4; i++) 
        {
             if(NoOfPlayers < 3)
            y[i].setIsComputer(true);
            
         y[i].setAlive(true);
         y[i].setActive(false);
         y[i].setAtHome(true);
         y[i].setStepcount(0);
         y[i].setStartX(334);
         y[i].setStartY(792);
         y[i].setGoalX(406);
         y[i].setGoalY(433);
        }
    }
     public void setupGreenPlayers(int NoOfPlayers)
    {
        g[0]= new GreenPlayer(83,179);
        g[1]= new GreenPlayer(152,111);
        g[2]= new GreenPlayer(220,179);
        g[3]= new GreenPlayer(152,247);

         getWorld().addObject(g[0],83,179);
         getWorld().addObject(g[1],152,111);
         getWorld().addObject(g[2],220,179);
         getWorld().addObject(g[3],152,247);
         
         for(int i = 0; i < 4; i++) 
        {
             if(NoOfPlayers < 4)
            g[i].setIsComputer(true);
            
         g[i].setAlive(true);
         g[i].setActive(false);
         g[i].setAtHome(true);
         g[i].setStepcount(0);
         g[i].setStartX(46);
         g[i].setStartY(360);
         g[i].setGoalX(406);
         g[i].setGoalY(433);
        }
    }
    
    // Getters & Setters
    public RedPlayer[] getRedPlayer() {
		return r;
	}

	public void setR(RedPlayer[] r) {
		this.r = r;
	}

	public BluePlayer[] getBluePlayer() {
		return b;
	}

	public void setB(BluePlayer[] b) {
		this.b = b;
	}

	public YellowPlayer[] getYellowPlayer() {
		return y;
	}

	public void setYp(YellowPlayer[] y) {
		this.y = y;
	}

	public GreenPlayer[] getGreenPlayer() {
		return g;
	}

	public void setG(GreenPlayer[] g) {
		this.g = g;
	}
}
