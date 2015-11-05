import greenfoot.*;
import java.util.*;

/**
 * Write a description of class YellowPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class YellowPlayer extends Player
{
    /**
     * Act - do whatever the YellowPlayer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private static int tokensReachedAtGoal = 0;
        static int dscore;
        static boolean Played = false;
     
     public YellowPlayer()
     {
         
     }
    
     public static void setTokensReachedAtGoal(int t)
    {
        tokensReachedAtGoal = t;
    }
    
    public static int getTokensReachedAtGoal()
    {
        return tokensReachedAtGoal;
    }
    
    
    public YellowPlayer(int homeX,int homeY)
    {
        this.path = new int[45][2];
        this.setHomeX(homeX);
        this.setHomeY(homeY);
        this.setPathCoordinates();
        
    }
    
   
    
      public void setPathCoordinates()
    {
       int X = 334;
        int Y = 793;
        
        for(int i=1; i<45; i++)
        {
            //String hp = this.hashPath.get(i);
            
            if((i>=1 && i<= 4)||(i>=9 && i<=10)||(i>=15 && i<=18)||(i>=40 && i<=44))
            {
             Y -= 72;
            this.path[i][0] = X;
            this.path[i][1] = Y;
            }
            
            if((i>=21 && i<=24)||(i>=29 && i<=30)||(i>=35 && i<=38))
            {
             Y += 72;   
            this.path[i][0] = X;
            this.path[i][1] = Y;
            }
            
            if((i>=11 && i<= 14)||(i>=19 && i<=20)||(i>=25 && i<=28))
            {
               X += 72;
             this.path[i][0] = X;
             this.path[i][1] = Y;
            }
            
            if((i>=5 && i<= 8)||(i>=31 && i<=34)||i==39)
            {
                X -= 72;
             this.path[i][0] = X;
             this.path[i][1] = Y;
            }
            
        }
    }
    public void act() 
    {
        int s = YellowPlayer.dscore;
        
       
            if(Greenfoot.mouseClicked(this))
            {
                 Greenfoot.playSound("click.wav");
                List<Scoreboard> sb = getWorld().getObjects(Scoreboard.class);
                
                if(!this.IsComputer() && sb.size() == 1)
                {

                    if(this.isAlive())
                    {
                        if(!this.isActive()&& s == 6)
                        {
                            //RedPlayer.dscore = -1;
                            int xs = this.getStartX();
                            int ys = this.getStartY();

                            List<Player> kp = getWorld().getObjectsAt(xs,ys, null);

                            Iterator<Player> it = kp.iterator();

                            while(it.hasNext())
                            {
                                Player op = it.next();

                                if(this.getClass()!= op.getClass())
                                {
                                    if(op.isAlive())
                                    {

                                        
                                        op.setLocation(op.getHomeX(), op.getHomeY());
                                        op.setActive(false);
                                        op.setStepcount(0);

                                        Greenfoot.playSound("kill.wav");
                                        
                                        this.setLocation(xs,ys);
                                        this.setActive(true);

                                        YellowPlayer.Played = true;
                                       sb.get(0).setNotification("Roll Dice");
                                    }

                                }
                                else
                                {
                                    this.setLocation(this.getStartX(), this.getStartY());
                                    this.setActive(true);

                                    
                                    YellowPlayer.Played = true;
                                    sb.get(0).setNotification("Roll Dice");

                                }
                            }
                            if(!YellowPlayer.Played)
                            {
                                this.setLocation(this.getStartX(), this.getStartY());
                                this.setActive(true);

                                YellowPlayer.Played = true;
                                sb.get(0).setNotification("Roll Dice");

                            }
                        }
                        else 
                        if(this.isActive())
                        {
                            // check if player reaches goal
                            int futureStepcount = this.getStepcount() + s;

                            if(futureStepcount < 45)
                            {   // check if player reaches goal
                                if((this.getGoalX() == this.path[futureStepcount][0]) && (this.getGoalY() == this.path[futureStepcount][1]))
                                {
                                    this.setStepcount(futureStepcount);

                                    this.setLocation(this.path[futureStepcount][0],this.path[futureStepcount][1]);
                                    this.setAlive(false);
                                    
                                    this.setImage("Goal.png");
                                    
                                    Greenfoot.playSound("ping.wav");
                                     
                                    YellowPlayer.Played = true;
                                    sb.get(0).setNotification("Roll Dice");
                                    
                                    YellowPlayer.setTokensReachedAtGoal(YellowPlayer.getTokensReachedAtGoal()+1); 
                                    if(YellowPlayer.getTokensReachedAtGoal() == 4)
                                    {
                                        int winnercount = 1;
                                        if(RedPlayer.getTokensReachedAtGoal() == 4) winnercount++;
                                        if(BluePlayer.getTokensReachedAtGoal() == 4) winnercount++;
                                        if(GreenPlayer.getTokensReachedAtGoal() == 4) winnercount++;
                                        
                                        Greenfoot.playSound("winningTune.wav");

                                        getWorld().addObject(new Text("Winner"+winnercount,5,30),1175,135);
                                    }
                                    else
                                        getWorld().addObject(new Text(Integer.toString(YellowPlayer.getTokensReachedAtGoal())),1175,235);

                                } 
                                // check if player kills other player
                                if(!YellowPlayer.Played)
                                {
                                    List<Player> kp = getWorld().getObjectsAt(this.path[futureStepcount][0],this.path[futureStepcount][1], null);

                                    Iterator<Player> it = kp.iterator();

                                    while(it.hasNext())
                                    {
                                        Player op = it.next();
                                        
                                        if(this.getClass()!= op.getClass())
                                        {
                                            if(op.isAlive())
                                            {
                                                op.setLocation(op.getHomeX(), op.getHomeY());
                                                op.setActive(false);
                                                op.setStepcount(0);
                                                
                                                Greenfoot.playSound("kill.wav");

                                                this.setStepcount(futureStepcount);
                                                this.setLocation(this.path[futureStepcount][0],this.path[futureStepcount][1]);
                                                YellowPlayer.Played = true;
                                                sb.get(0).setNotification("Roll Dice");
                                            }
                                        }
                                        else
                                        {
                                            // same player code
                                            this.setStepcount(futureStepcount);
    
                                            this.setLocation(this.path[this.getStepcount()][0],this.path[this.getStepcount()][1]);
    
                                            YellowPlayer.Played = true;
                                            sb.get(0).setNotification("Roll Dice");
                                        }
                                    }
                                    if(!YellowPlayer.Played)
                                    {
                                        this.setStepcount(futureStepcount);

                                        this.setLocation(this.path[futureStepcount][0],this.path[futureStepcount][1]);
                                         
                                        
                                        YellowPlayer.Played = true;
                                        sb.get(0).setNotification("Roll Dice");
                                        
                                    }
                                }
                            }
                            else
                            {
                                sb.get(0).setNotification("Invalid Move");
                                // select  another Player notification
                            }
                        }
                        else
                        if(!this.isActive() && s != 6)
                        {
                            YellowPlayer.Played = true;
                            sb.get(0).setNotification("Roll Dice");
                        }

                   
                        
                    }
                }
           // }
        }
    }    
}
