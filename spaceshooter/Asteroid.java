import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Asteroid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Asteroid extends Actor
{
    public static int astHC = 0;
    
    /**
     * Act - do whatever the Asteroid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        astMovement();
        removeInstance();
        hitAst();
    }
    
    public void astMovement()
    {
        setLocation(getX()-4,getY());
    }
    
    public void hitAst()
    {
        if (astHC >= 1)
        {
            MyWorld.player1Score += 20;
            MyWorld.player2Score += 20;
            astHC = 0;
            getWorld().removeObject(this);
        }
    }

    public void removeInstance()
    {
        if (isTouching(player1.class))
        {
            MyWorld.player1Score -= 5;
            getWorld().removeObject(this);
        }
        else if (isTouching(player2.class))
        {
            MyWorld.player2Score -= 5;
            getWorld().removeObject(this);
        }
        
        else if (getX() < 5)
        {
            getWorld().removeObject(this);
        }
    }
}
