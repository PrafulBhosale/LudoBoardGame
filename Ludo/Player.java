import greenfoot.*;
import java.util.*;

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
//      RedPlayer []r;
//      BluePlayer []b;
//      YellowPlayer []y;
//      GreenPlayer []g;
      HashMap<Integer,String> hashPath;
      
      Scoreboard scBlank = new Scoreboard("");
      
      static PlayGame pg;
      private int score;
      private int startX,startY;
      private int homeX,homeY;
      private int goalX,goalY;
      private int currentX,currentY;
      private int stepcount = 0;
      
      private int goalDistance = 44;
      int[][] path;
      private boolean isAtHome;
      private boolean isActive;
      private boolean isAlive;
      private boolean isComputer;
      
      private static int turn = 1;
      
      private static boolean isPlayed;
      
    // int NoOfPlayers;
     
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Player()
    {
         
        
      //this.NoOfPlayers = NoOfPlayers;
    }
    
    public void act() 
    {
        // Add your action code here.
    } 
    
    
    // Getters & Setters
   
    public boolean IsComputer() {
        return isComputer;
    }


    public void setIsComputer(boolean isComputer) {
        this.isComputer = isComputer;
    }
    public static boolean getIsPlayed() {
        return isPlayed;
    }
    public static void setIsPlayed(boolean ip)
    {
        isPlayed = ip;
    }
    
    public static int getTurn() {
        return turn;
    }


    public static void setTurn(int t) {
        
        if(t > 4)
            turn = 1;
        else    
            turn = t;
    }
    
   public int getGoalX() {
        return goalX;
    }


    public void setGoalX(int goalX) {
        this.goalX = goalX;
    }
    
    public int getGoalY() {
        return goalY;
    }


    public void setGoalY(int goalY) {
        this.goalY = goalY;
    }
    
    
   public int getScore() {
        return score;
    }


    public void setScore(int score) {
        this.score = score;
    }


    public int getStartX() {
        return startX;
    }


    public void setStartX(int startX) {
        this.startX = startX;
    }


    public int getStartY() {
        return startY;
    }


    public void setStartY(int startY) {
        this.startY = startY;
    }


    public int getHomeX() {
        return homeX;
    }


    public void setHomeX(int homeX) {
        this.homeX = homeX;
    }


    public int getHomeY() {
        return homeY;
    }


    public void setHomeY(int homeY) {
        this.homeY = homeY;
    }


    public int getCurrentX() {
        return currentX;
    }


    public void setCurrentX(int currentX) {
        this.currentX = currentX;
    }


    public int getCurrentY() {
        return currentY;
    }


    public void setCurrentY(int currentY) {
        this.currentY = currentY;
    }


    public int getStepcount() {
        return stepcount;
    }


    public void setStepcount(int stepcount) {
        this.stepcount = stepcount;
    }


    public int getGoalDistance() {
        return goalDistance;
    }


    public void setGoalDistance(int goalDistance) {
        this.goalDistance = goalDistance;
    }


    public int[][] getPath() {
        return path;
    }


    public void setPath(int[][] path) {
        this.path = path;
    }


    public boolean isAtHome() {
        return isAtHome;
    }


    public void setAtHome(boolean isAtHome) {
        this.isAtHome = isAtHome;
    }


    public boolean isActive() {
        return isActive;
    }


    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
    
    public boolean isAlive() {
        return isAlive;
    }


    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    
}
