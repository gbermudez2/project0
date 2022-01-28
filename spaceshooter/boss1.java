import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class boss1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class boss1 extends Actor
{
    public int reloadTimer = 0;
    private int bossMovement = 0;
    public static boolean bossDead = false;
    
    public static int boss1HC = 0;
    /**
     * Act - do whatever the boss1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    { 
        shipMovement();
        fireProjectile();
        hitBoss1();
    }

    public void shipMovement()
    {
        bossMovement += 1;
        if (bossMovement == 10)
        {
            setLocation(getX()-1,getY());
            bossMovement = 0;
            MyWorld.bossTimer = 0;
        }
    }
    
    public void hitBoss1()
    {
        if (boss1HC >= 300)
        {
            MyWorld.player1Score += 500;
            MyWorld.player2Score += 500;
            boss1HC = 0;
            getWorld().removeObject(this);
            bossDead = true;
        }
    }

    public void fireProjectile()
    {
        if (reloadTimer == 0)
        {
            getWorld().addObject(new eLaser(), getX(), Greenfoot.getRandomNumber(400));
        }
        reloadTimer ++;
        if (reloadTimer == 10)
        {
            reloadTimer = 0;
        }
    }
}
