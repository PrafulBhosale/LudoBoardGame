import greenfoot.*;  
import java.awt.font.FontRenderContext;
import java.awt.*;

/**
 * This class provides objects that just show a bit of text on the screen.
 */
public class Text extends Actor
{
    Font font1 = new Font("Algerian", Font.BOLD,30);
    int x  = 90;
    int y  = 30;
    
   
    public Text(String text)
    {
        //this (text.length());
        setImage(new GreenfootImage("score.png"));
        setText(text);
    }

    public Text(String text,int x,int y)
    {
        //this (text.length());
        this.x = x;
        this.y = y;
        setImage(new GreenfootImage("score.png"));
        setText(text);
    }
    
    public void setText(String text)
    {
        GreenfootImage image = getImage();
        image.setColor(Color.white);
        
        image.setFont(font1);
        image.drawString(text,x,y);
    }
    
    public void setLocation(int x, int y)
    {
        super.setLocation(x + getImage().getWidth() / 2, y);
    }
    
}
