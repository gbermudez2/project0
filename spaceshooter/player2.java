import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class player2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class player2 extends Actor
{
    public int reloadTimer = 0;
    public static int reloadSpeed2 = 25;
    
    /**
     * Act - do whatever the player1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        movement();
        powerUp();
        fireProjectile();
        getWorld().showText("Player 2: " + MyWorld.player2Score + " // Controls: ↑↓←→",180,375);
    }

    public void movement()
    {
        if (Greenfoot.isKeyDown("right"))
        {
            setLocation(getX()+5, getY());
        }
        if (Greenfoot.isKeyDown("left"))
        {
            setLocation(getX()-5, getY());
        }
        if (Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(), getY()-5);
        }
        if (Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY()+5);
        }
    }

    public void fireProjectile()
    {
        if (reloadTimer == 0)
        {
            getWorld().addObject(new pellet2(), getX(), getY());
            Greenfoot.playSound("laser.mp3");
        }
        reloadTimer ++;
        if (reloadTimer >= reloadSpeed2)
        {
            reloadTimer = 0;
        }
    }
    
    public void powerUp()
    {
        Actor powerup;
        powerup = getOneObjectAtOffset(0,0,powerup.class);
        if (isTouching(powerup.class))
        {
            reloadSpeed2 -= 1;
            getWorld().removeObject(powerup);
        }
    }
}
