import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOvarImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverImage extends Actor
{
    /**
     * Act - do whatever the GameOvarImage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int worldWidth, worldHeight;
    private int x, y;
    private long timeStep = 0;
    private long goalTimeStep = 0;
    protected void addedToWorld(World world)
    {
        worldWidth = world.getWidth();
        worldHeight = world.getHeight();
        setLocation(worldWidth/2, 0);
        getImage().setTransparency(0);
        goalTimeStep = 1000;
    }
    public void act() 
    {
        if(timeStep <= 1000)
        {
            setLocation(worldWidth/2, (int)(worldHeight*((double)timeStep/goalTimeStep)/2));
            setRotation((int)(timeStep*1.1));
            getImage().setTransparency((int)((double)timeStep/goalTimeStep*255));
        }
        timeStep += (goalTimeStep - timeStep)*0.025;
    }    
}
