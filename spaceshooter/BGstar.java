import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BGstar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BGstar extends Actor
{
    /**
     * Act - do whatever the BGstar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        starMovement();
        offScreen();
    }
    
    public void starMovement()
    {
        setLocation(getX()-10,getY());
    }
    
    public void offScreen()
    {
        if (getX() < 3)
        {
            getWorld().removeObject(this);
        }
    }
}
