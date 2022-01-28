import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class powerup here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class powerup extends Actor
{
    private int powerTimer1 = 0;
    private int powerTimer2 = 0;
    /**
     * Act - do whatever the powerup wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        movement();
        removeInstance();
    }

    public void movement()
    {
        setLocation(getX()-7,getY());
    }

    public void removeInstance()
    {
        if (getX() < 5)
        {
            getWorld().removeObject(this);
        }
    }
}
