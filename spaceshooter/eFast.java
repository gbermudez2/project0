import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class eFast here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class eFast extends Actor
{
    public int reloadTimer = 0;
    public static int fastHitCounter = 0;
    /**
     * Act - do whatever the eFast wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        shipMovement();
        fireProjectile();
        removeInstance();
        hiteFast();
    }

    public void shipMovement()
    {
        setLocation(getX()-7,getY());
    }

    public void fireProjectile()
    {
        if (reloadTimer == 0)
        {
            getWorld().addObject(new eLaser(), getX(), getY());
        }
        reloadTimer ++;
        if (reloadTimer == 100)
        {
            reloadTimer = 0;
        }
    }
    
    public void hiteFast()
    {
        if (fastHitCounter >= 2)
        {
            MyWorld.player1Score += 30;
            MyWorld.player2Score += 30;
            fastHitCounter = 0;
            getWorld().removeObject(this);
        }
    }

    public void removeInstance()
    {
        if (getX() < 5)
        {
            MyWorld.player1Score -= 5;
            MyWorld.player2Score -= 5;
            getWorld().removeObject(this);
        }
    }
}
