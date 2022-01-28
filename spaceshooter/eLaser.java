import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class eLaser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class eLaser extends Actor
{
    /**
     * Act - do whatever the eLaser wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        projMovement();
        removeInstance();
    }
    
    public void projMovement()
    {
        setLocation(getX()-12,getY());
    }
    
    public void removeInstance()
    {
        if (isTouching(player1.class))
        {
            MyWorld.player1Score -= 15;
            getWorld().removeObject(this);
        }
        else if (isTouching(player2.class))
        {
            MyWorld.player2Score -= 15;
            getWorld().removeObject(this);
        }
        else if (getX() < 3)
        {
            getWorld().removeObject(this);
        }
    }
}
