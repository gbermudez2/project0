import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class pellet2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class pellet2 extends Actor
{
    /**
     * Act - do whatever the pellet2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        projMovement();
        removeInstance();
    }
    
    public void projMovement()
    {
        setLocation(getX()+9,getY());
    }
    
    public void removeInstance()
    {
        if (isTouching(eFast.class))
        {
            eFast.fastHitCounter += 1;
            MyWorld.player2Score += 25;
            getWorld().removeObject(this);
        }
        
        else if (isTouching(Asteroid.class))
        {
            Asteroid.astHC += 1;
            MyWorld.player2Score += 15;
            getWorld().removeObject(this);
        }
        
        else if (isTouching(boss1.class))
        {
            boss1.boss1HC += 1;
            MyWorld.player2Score += 50;
            getWorld().removeObject(this);
        }
        
        else if (getX() > 1396)
        {
            getWorld().removeObject(this);
        }
    }
}
