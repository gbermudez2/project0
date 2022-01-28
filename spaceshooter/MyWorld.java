import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public int nores1 = 0;
    public int noresBoss = 0;

    public static int bossTimer = 0;

    public static int player1Score = 0;
    public static int player2Score = 0;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1400, 400, 1);
    }

    public void act()
    {
        setPaintOrder(player1.class, player2.class, powerup.class, pellet.class, pellet2.class, boss1.class, eFast.class, Asteroid.class, BGstar.class);

        bossTimer += 1;
        spawnBoss();

        spawnBGstar();
        spawnPlayers();
        spawneFast();
        spawnAst();
    }

    public void spawnBoss()
    {
        if (bossTimer >= 3000)
        {
            if (noresBoss == 0)
            {
                addObject(new boss1(), 1400, 200);
                showText("----- Boss Battle -----",700, 20);
                noresBoss += 1;
            }
        }
    }
    
    public void spawneFast()
    {
        if (Greenfoot.getRandomNumber(200) < 1)
        {
            addObject(new eFast(), 1400, Greenfoot.getRandomNumber(400));
        }
    }

    public void spawnPower()
    {
        if (Greenfoot.getRandomNumber(900) < 1)
        {
            addObject(new powerup(), 1400, Greenfoot.getRandomNumber(400));
        }
    }

    public void spawnAst()
    {
        if (Greenfoot.getRandomNumber(150) < 1)
        {
            addObject(new Asteroid(), 1400, Greenfoot.getRandomNumber(400));
        }
    }

    public void spawnPlayers()
    {
        if (nores1 == 0)
        {
            addObject(new player1(), 100, 100);
            addObject(new player2(), 100, 300);
            player1Score = 0;
            player2Score = 0;
            nores1 += 1;
        }
    }

    public void spawnBGstar()
    {
        if (Greenfoot.getRandomNumber(20) < 1)
        {
            addObject(new BGstar(), 1400, Greenfoot.getRandomNumber(400));
        }
    }
}
