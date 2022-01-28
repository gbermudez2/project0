import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class player1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class player1 extends Actor
{ 
    public int reloadTimer = 0;
    public static int reloadSpeed1 = 25;
    
    /**
     * Act - do whatever the player1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        movement();
        powerUp();
        fireProjectile();
        getWorld().showText("Player 1: " + MyWorld.player1Score + " // Controls - WASD",180,25);

        if (boss1.bossDead == true)
        {
            if (MyWorld.player1Score > MyWorld.player2Score)
            {
                Greenfoot.stop();
                getWorld().showText("PLAYER 1 WINS!", 700, 200);
            }
            else if (MyWorld.player2Score > MyWorld.player1Score)
            {
                Greenfoot.stop();
                getWorld().showText("PLAYER 2 WINS!", 700, 200);
            }
        }
    }

    public void movement()
    {
        if (Greenfoot.isKeyDown("d"))
        {
            setLocation(getX()+5, getY());
        }
        if (Greenfoot.isKeyDown("a"))
        {
            setLocation(getX()-5, getY());
        }
        if (Greenfoot.isKeyDown("w"))
        {
            setLocation(getX(), getY()-5);
        }
        if (Greenfoot.isKeyDown("s"))
        {
            setLocation(getX(), getY()+5);
        }
    }

    public void fireProjectile()
    {
        if (reloadTimer == 0)
        {
            getWorld().addObject(new pellet(), getX(), getY());
            Greenfoot.playSound("laser.mp3");
        }
        reloadTimer ++;
        if (reloadTimer >= reloadSpeed1)
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
            reloadSpeed1 -= 1;
            getWorld().removeObject(powerup);
        }
    }
}
