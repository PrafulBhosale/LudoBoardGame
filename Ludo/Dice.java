import greenfoot.*;
import java.util.*;
import java.util.List;
import java.awt.*;

/**
 * Write a description of class Dice here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dice extends RollDiceAnimation
{
    /**
     * Act - do whatever the Dice wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    DiceScore dc;
    private String defaultdice = "Dice.png";
    DiceTurn dt = new DiceTurn();
    Scoreboard sc = new Scoreboard("Roll Dice");
    static boolean startGame = false;
    
    public Dice()
    {
        
        //getWorld().addObject(dt,1200,130);
        //Player.setTurn(1);
    }

    public int throwDice()
    {
        
        int s = rollDice();
        String score = "s"+s+".png";
        dc = new DiceScore(score);
        getWorld().addObject(dc,940,751);
        
         
        super.setImage();
       // Greenfoot.delay(2);
        Greenfoot.playSound("tock.wav");
        
        return s;
    }

    public void playDice(int t) 
    {
            int s;       
            
            //sc.setNotification("Roll Dice");
            
            switch(t)
            {
                
                case 1: {
                             setTurnImage(RedPlayer.class); 
                             sc.setNotification("Roll Dice");
                             
                             s = throwDice();
                             RedPlayer.dscore = s;
                             setPlayerNotification(RedPlayer.class,RedPlayer.dscore,"Select Red Player");
                             //setTurnImage(RedPlayer.class);
                             RedPlayer.Played = true;
            
                            if(RedPlayer.Played == true)
                            {//getWorld().removeObject(sc);  
                                
                                
                                if(BluePlayer.getTokensReachedAtGoal() < 4) Player.setTurn(2);
                                else
                                if(YellowPlayer.getTokensReachedAtGoal() < 4) Player.setTurn(3);
                                else
                                if(GreenPlayer.getTokensReachedAtGoal() < 4) Player.setTurn(4);
                                else
                                    GameOver();
                                    
                                
                                
                                RedPlayer.Played = false;
                               
                                setTurnImage(RedPlayer.class); 
                                   // sc.setNotification("Roll Dice");
                                
                                //setTurnImage();
                            }
                        }
                             break;

               case 2: { 
                         setTurnImage(BluePlayer.class); 
                         sc.setNotification("Roll Dice");
                          s =  throwDice();
                          
                         // sc.setNotification("Roll Dice");
                         // getWorld().addObject(sc,1102,663);
                           
                           
                            if(PlayGame.NoOfPlayers < 2)
                            {
                                movePlayer(BluePlayer.class,s); // computer player
                                //setTurnImage(BluePlayer.class);
                                if(YellowPlayer.getTokensReachedAtGoal() < 4) Player.setTurn(3);
                                    else
                                    if(GreenPlayer.getTokensReachedAtGoal() < 4) Player.setTurn(4);
                                    else
                                    if(RedPlayer.getTokensReachedAtGoal() < 4) Player.setTurn(1);
                                    else
                                        GameOver();
                                setTurnImage(RedPlayer.class); 
                                    //sc.setNotification("Roll Dice");
                                //sc.setNotification("Roll Dice");
                                       // setTurnImage();
                            }
                        else
                        {
                            BluePlayer.dscore = s;
                            setPlayerNotification(BluePlayer.class,BluePlayer.dscore,"Select Blue Player");
                            BluePlayer.Played = true;
                            if(BluePlayer.Played)
                            {
                                //setTurnImage(BluePlayer.class);
                                if(YellowPlayer.getTokensReachedAtGoal() < 4) Player.setTurn(3);
                                else
                                if(GreenPlayer.getTokensReachedAtGoal() < 4) Player.setTurn(4);
                                else
                                if(RedPlayer.getTokensReachedAtGoal() < 4) Player.setTurn(1);
                                else
                                    GameOver();
                                BluePlayer.Played = false;   
                                setTurnImage(BluePlayer.class);
                                //setTurnImage();
                            }
                       }
                        }
                        
                        break;

                case 3: {
                            setTurnImage(YellowPlayer.class);
                            sc.setNotification("Roll Dice");
                            
                            s =  throwDice();
                            
                            //sc.setNotification("Roll Dice");
                           // getWorld().addObject(sc,1102,663);
                            
                                if(PlayGame.NoOfPlayers < 3)
                                   {
                                       movePlayer(YellowPlayer.class,s); // computer player
                                       //setTurnImage(YellowPlayer.class);
                                       if(GreenPlayer.getTokensReachedAtGoal() < 4) Player.setTurn(4);
                                        else
                                        if(RedPlayer.getTokensReachedAtGoal() < 4) Player.setTurn(1);
                                        else
                                        if(BluePlayer.getTokensReachedAtGoal() < 4) Player.setTurn(2);
                                        else
                                            GameOver();
                                       setTurnImage(RedPlayer.class); 
                                    //sc.setNotification("Roll Dice");
                                      // sc.setNotification("Roll Dice");
                                           // setTurnImage();
                                    }
                                else
                                {
                                    YellowPlayer.dscore = s;
                                    setPlayerNotification(YellowPlayer.class,YellowPlayer.dscore,"Select Yellow Player");
                                    YellowPlayer.Played = true;
                                    if(YellowPlayer.Played)
                                    {
                                        // setTurnImage(YellowPlayer.class);
                                        if(GreenPlayer.getTokensReachedAtGoal() < 4) Player.setTurn(4);
                                        else
                                        if(RedPlayer.getTokensReachedAtGoal() < 4) Player.setTurn(1);
                                        else
                                        if(BluePlayer.getTokensReachedAtGoal() < 4) Player.setTurn(2);
                                        else
                                            GameOver();
                                            
                                            YellowPlayer.Played = false;
                                        setTurnImage(YellowPlayer.class);
                                            //setTurnImage();
                                    }
                                    
                                }
                           
                        //Player.setIsPlayed(false);
                       }
                        break;

                case 4: {
                             setTurnImage(GreenPlayer.class);
                             sc.setNotification("Roll Dice");
                         s =  throwDice();
                         
                         //sc.setNotification("Roll Dice");
                        // getWorld().addObject(sc,1102,663);
                         
                        if(PlayGame.NoOfPlayers < 4)
                        {
                            movePlayer(GreenPlayer.class,s);
                            //setTurnImage(GreenPlayer.class);
                             if(RedPlayer.getTokensReachedAtGoal() < 4) Player.setTurn(1);
                                else
                                if(BluePlayer.getTokensReachedAtGoal() < 4) Player.setTurn(2);
                                else
                                if(YellowPlayer.getTokensReachedAtGoal() < 4) Player.setTurn(3);
                                else
                                    GameOver();
                                setTurnImage(RedPlayer.class); 
                                   // sc.setNotification("Roll Dice");    
                            //setTurnImage();
                        }
                        else
                        {
                            GreenPlayer.dscore = s;
                            setPlayerNotification(GreenPlayer.class,GreenPlayer.dscore,"Select Green Player");
                            GreenPlayer.Played = true;
                            
                             if(GreenPlayer.Played)
                            {
                                 //setTurnImage(GreenPlayer.class);
                                if(RedPlayer.getTokensReachedAtGoal() < 4) Player.setTurn(1);
                                else
                                if(BluePlayer.getTokensReachedAtGoal() < 4) Player.setTurn(2);
                                else
                                if(YellowPlayer.getTokensReachedAtGoal() < 4) Player.setTurn(3);
                                else
                                    GameOver();
                                    GreenPlayer.Played = false;
                                    setTurnImage(GreenPlayer.class);
                                   // setTurnImage();
                            }
                        }
                        
                           
                      }
                        //Player.setIsPlayed(false);
                        break;

                default: break;
            }
    }
    
    public void act() 
    {

        // dt = new DiceTurn();
        getWorld().addObject(dt,1140,130);
        int t = Player.getTurn();
        
        if(Player.getTurn() <= PlayGame.NoOfPlayers)
        {
         if(Greenfoot.mouseClicked(this))
         {
            
            playDice(t);
             Dice.startGame = false;
         }
        }
        else
        {
            if((sc.note == "Roll Dice") || (sc.note == "Invalid Move"))
            {
                Greenfoot.delay(100);
                playDice(t);
            }
        }
        

        setImage(defaultdice);

    } 

    public void GameOver()
    {
        getWorld().addObject(new Gameover(),699,423);
        Greenfoot.playSound("sadTrombone.wav");
        Greenfoot.stop();

        //Greenfoot.delay(60);
        

    }
    
    public void setPlayerNotification(java.lang.Class cls,int score,String note)
    {
       
         List<Player> P = getWorld().getObjects(cls);
         
         if((P.get(0).isActive() && P.get(0).isAlive()) || (P.get(1).isActive() && P.get(1).isAlive()) || (P.get(2).isActive() && P.get(2).isAlive()) || (P.get(3).isActive() && P.get(3).isAlive()) ||  score == 6) //&& Player.getTurn()== 1)
             if(!P.get(0).IsComputer()) 
                if(((P.get(0).getStepcount() + score) < 45 && P.get(0).isActive()) || ((P.get(1).getStepcount() + score) < 45 && P.get(1).isActive()) || ((P.get(2).getStepcount() + score) < 45 && P.get(2).isActive()) || ((P.get(3).getStepcount() + score) < 45 && P.get(3).isActive()))
                    sc.setNotification(note);
                else 
                  if(score == 6)
                    sc.setNotification(note);
                  else
                   sc.setNotification("Roll Dice");
               
    }
    
    public void setTurnImage(java.lang.Class cls)
    {

        int t = Player.getTurn();
 
        if(t == 1)
            dt.setLocation(1140,130);
        else
        if(t == 2)
            dt.setLocation(1140,177);
        else
        if(t == 3)
            dt.setLocation(1140,227);
        else
        if(t == 4)
            dt.setLocation(1140,277);

    }
    public int rollDice()
    {
        if(dc != null)
            getWorld().removeObject(dc);
        
        if(Dice.startGame == true)  
        { 
            if (PlayGame.sb != null)
            getWorld().removeObject(PlayGame.sb);
            
            getWorld().addObject(sc,1102,663);
        }

        return Greenfoot.getRandomNumber(6)+1;  
    }

    public void movePlayer(java.lang.Class cls,int s)
    {
        boolean Played = false;
        
        // check if player reaches goal
        
         List<Player> rp = getWorld().getObjects(cls);
         
        for(Player a : rp)
            { 
                if(Played)
                          break;
                          
                if(a.isAlive())
                {
                    if(a.isActive())
                    {
                        int futureStepcount = a.getStepcount() + s;

                        if(futureStepcount < 45)
                        {   
                            if((a.getGoalX() == a.path[futureStepcount][0]) && (a.getGoalY() == a.path[futureStepcount][1]))
                            {
                                a.setStepcount(futureStepcount);

                                a.setLocation(a.path[futureStepcount][0],a.path[futureStepcount][1]);
                                a.setAlive(false);
                                a.setImage("Goal.png");
                                  
                                Greenfoot.playSound("ping.wav");
                                Played = true;

                                if(cls == RedPlayer.class)
                                {
                                    RedPlayer.setTokensReachedAtGoal(RedPlayer.getTokensReachedAtGoal()+1); 
                                    if(RedPlayer.getTokensReachedAtGoal() == 4)
                                    {
                                        int winnercount = 1;
                                        if(BluePlayer.getTokensReachedAtGoal() == 4) winnercount++;
                                        if(YellowPlayer.getTokensReachedAtGoal() == 4) winnercount++;
                                        if(GreenPlayer.getTokensReachedAtGoal() == 4) winnercount++;
                                        
                                        Greenfoot.playSound("winningTune.wav");

                                        getWorld().addObject(new Text("Winner"+winnercount,5,30),1175,135);
                                    }
                                    else
                                        getWorld().addObject(new Text(Integer.toString(RedPlayer.getTokensReachedAtGoal())),1175,135);
                                }

                                if(cls == BluePlayer.class)
                                {
                                    BluePlayer.setTokensReachedAtGoal(BluePlayer.getTokensReachedAtGoal()+1);

                                    if(BluePlayer.getTokensReachedAtGoal() == 4)
                                    {
                                        int winnercount = 1;
                                        if(RedPlayer.getTokensReachedAtGoal() == 4) winnercount++;
                                        if(YellowPlayer.getTokensReachedAtGoal() == 4) winnercount++;
                                        if(GreenPlayer.getTokensReachedAtGoal() == 4) winnercount++;
                                        
                                        Greenfoot.playSound("winningTune.wav");

                                        getWorld().addObject(new Text("Winner"+winnercount,5,30),1175,185);
                                    }
                                    else
                                        getWorld().addObject(new Text(Integer.toString(BluePlayer.getTokensReachedAtGoal())),1175,185);
                                }

                                if(cls == YellowPlayer.class)
                                {

                                    YellowPlayer.setTokensReachedAtGoal(YellowPlayer.getTokensReachedAtGoal()+1);

                                    if(YellowPlayer.getTokensReachedAtGoal() == 4)
                                    {
                                        int winnercount = 1;
                                        if(BluePlayer.getTokensReachedAtGoal() == 4) winnercount++;
                                        if(RedPlayer.getTokensReachedAtGoal() == 4) winnercount++;
                                        if(GreenPlayer.getTokensReachedAtGoal() == 4) winnercount++;
                                        
                                        Greenfoot.playSound("winningTune.wav");

                                        getWorld().addObject(new Text("Winner"+winnercount,5,30),1175,235);
                                    }
                                    else
                                        getWorld().addObject(new Text(Integer.toString(YellowPlayer.getTokensReachedAtGoal())),1175,235);
                                }

                                if(cls == GreenPlayer.class)
                                {
                                    GreenPlayer.setTokensReachedAtGoal(GreenPlayer.getTokensReachedAtGoal()+1);

                                    if(GreenPlayer.getTokensReachedAtGoal() == 4)
                                    {
                                        int winnercount = 1;
                                        if(RedPlayer.getTokensReachedAtGoal() == 4) winnercount++;
                                        if(BluePlayer.getTokensReachedAtGoal() == 4) winnercount++;
                                        if(YellowPlayer.getTokensReachedAtGoal() == 4) winnercount++;
                                        
                                        Greenfoot.playSound("winningTune.wav");

                                        getWorld().addObject(new Text("Winner"+winnercount,5,30),1175,285);
                                    }
                                    else
                                        getWorld().addObject(new Text(Integer.toString(GreenPlayer.getTokensReachedAtGoal())),1175,285);
                                }
                            }    
                        }
                    }
                }
            }
            
        
                // check if player kills other player token

                if(!Played)

                    for(Player a : rp)
                    { 
                        if(Played)
                          break;
                          
                        if(a.isAlive())
                        {
                            if(a.isActive())
                            {
                                int futureStepcount = a.getStepcount() + s;

                                if(futureStepcount < 45)
                                {   
                                    List<Player> kp = getWorld().getObjectsAt(a.path[futureStepcount][0],a.path[futureStepcount][1], null);

                                    Iterator<Player> it = kp.iterator();

                                    while(it.hasNext())
                                    {
                                        Player op = it.next();
                                        
                                        if(a.getClass()!= op.getClass())
                                        {
                                            if(op.isAlive())
                                            {
                                                //  kp.get(0).setLocation(kp.get(0).getHomeX(), kp.get(0).getHomeY());
                                                //  kp.get(0).setActive(false);
                                                // kp.get(0).setStepcount(0);
                                                
                                                op.setLocation(op.getHomeX(), op.getHomeY());
                                                op.setActive(false);
                                                op.setStepcount(0);
                                                 
                                                Greenfoot.playSound("kill.wav");
                                                
                                                a.setLocation(a.path[futureStepcount][0],a.path[futureStepcount][1]);
                                                a.setStepcount(futureStepcount);
                                                Played = true;
                                               // s = 0;
                                                //break;
                
                
                                                
                                            }
                                        }
                                        else
                                        {
                                            a.setStepcount(futureStepcount);
                                            a.setLocation(a.path[futureStepcount][0],a.path[futureStepcount][1]);

                                               
                                            Played = true;
                                        }
                                    }

                                }    
                            }

                        }
                
                
                    }    
        //-------- Check if player kills other player at Start position or make player active if score = 6
        
        if(!Played)  
       

        for(Player a : rp)
        {  
            if(Played)
                break;
                          
            if(a.isAlive())
            {
                if(!a.isActive() && s == 6)
                {
                    //int futureStepcount = a.getStepcount() + s;
                    List<Player> kp = getWorld().getObjectsAt(a.getStartX(), a.getStartY(), null);

                    Iterator<Player> it = kp.iterator();

                    while(it.hasNext())
                    {
                        Player op = it.next();
                        
                        if(a.getClass()!= op.getClass())
                        {
                            if(op.isAlive())
                            {
                                
                                
                                op.setLocation(op.getHomeX(), op.getHomeY());
                                op.setActive(false);
                                op.setStepcount(0);
                                    
                                Greenfoot.playSound("kill.wav");
                                
                                a.setLocation(a.getStartX(), a.getStartY());
                                a.setActive(true);
                                Played = true;
                              


                                
                            }
                        }
                        else
                        {
                            a.setLocation(a.getStartX(), a.getStartY());
                            a.setActive(true);
                            Played = true;
                           // s = 0;
                        }
                    }
                    if(!Played)
                    {
                        a.setLocation(a.getStartX(), a.getStartY());
                        a.setActive(true);
                        Played = true;
                        //s = 0;
                    }
                }
            }
        }
        
                //-------------------------------------------------------     

                    
                    if(!Played)
                    for(Player a : rp)
                    {  
                        if(Played)
                          break; 
                          
                        if(a.isAlive())
                        {
                            if(a.isActive())
                            {
                                int futureStepcount = a.getStepcount() + s;
                                
                                if(futureStepcount < 45)
                                {
                                    a.setStepcount(futureStepcount);
    
                                    a.setLocation(a.path[futureStepcount][0],a.path[futureStepcount][1]);
                                    Played = true;
                                   
                                }

                            }
                        }
                  }
    }
}
