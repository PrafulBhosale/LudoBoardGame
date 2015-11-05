import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Adds functionality to the actor class for animated GIF files. Just extend this class instead
 * of Actor, then use the setImage method as normal. If you use the class without a gif file, 
 * it will just display the static image the same as Actor does.
 * 
 * @author Michael Berry
 * @version 10/09/08
 */
public abstract class RollDiceAnimation extends Actor
{
    /** The images used in the animation. */
    private GreenfootImage[] images;
    /** The index of the current frame in the GIF file. */
    private int currentIndex;
 
    /** Whether the animation is paused or not. */
    private boolean pause;

    /**
     * Set the image of the actor. If the image is a normal picture, it will be displayed as normal.
     * If it's an animated GIF file then it will be displayed as an animated actor.
     * @overrides setImage in Actor.
     */
    public void setImage()
    {
       
        pause = false;

        
        loadImages();
        for (int i=0 ; i<4 ; i++) 
        {
           
            setImage(images[i]);
           
            Greenfoot.delay(5);
        }
    }
    
    /**
     * Get all the images used in the animation
     * @return a list of GreenfootImages, corresponding to each frame.
     */
    public List<GreenfootImage> getImages()
    {
        ArrayList<GreenfootImage> images = new ArrayList<GreenfootImage>(this.images.length);
        for(GreenfootImage image : this.images) {
            images.add(image);
        }
        return images;
    }
    
    /**
     * Pause the animation.
     */
    public void pause()
    {
        pause = true;
    }
    
    /**
     * Resume the animation.
     */
    public void resume()
    {
        pause = false;
    }
    
    /**
     * Determines whether the animation is running
     * @return true if the animation is running, false otherwise
     */
    public boolean isRunning()
    {
        return !pause;
    }
 
 
    public void act()
    {
       
            
    }
    
    /**
     * Advance to the next frame in the animation.
     */
    private void nextFrame()
    {
       if(currentIndex > 4)
       {
           currentIndex = 0;
           setImage(images[currentIndex++]);
        
       }
       else
       {
           setImage(images[currentIndex++]);
       }
    }

    /**
     * Load the images
     */
    private void loadImages()
    {
     
      
        int numFrames = 4;
        images = new GreenfootImage[numFrames];
        String []imageName = {"1.png","2.png","3.png","4.png"};
        
        for (int i=0 ; i<numFrames ; i++) {
            GreenfootImage image = new GreenfootImage(imageName[i]);
            
            images[i] = image;
        }
        
    }
}