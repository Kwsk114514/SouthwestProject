import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameManager extends Actor
{
    /**
     * Act - do whatever the GameManager wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean gameFlag = false;
    private int worldWidth, worldHeight;
    
    private long interval = 1000;
    private long prevTime = System.currentTimeMillis();
    private long elapsedTime = 0;
    protected void addedToWorld(World world)
    {
        worldWidth = world.getWidth();
        worldHeight = world.getHeight();
    }
    public void act() 
    {
        if(gameFlag == true)
        {
            long nowTime = System.currentTimeMillis();
            long deltaTime = nowTime - prevTime;
            elapsedTime += deltaTime;
            if(elapsedTime >= 12000){
                World title = new Title();
                Greenfoot.setWorld(title);
                elapsedTime = 0;
            }
            prevTime = nowTime;
        }
    }
    public void setGameFlag(boolean setFlag)
    {
        if(gameFlag != true && setFlag == true)
        {
            getWorld().addObject(new GameOverImage(), -100, worldHeight);
            gameFlag = setFlag;
        }
    }
    public boolean getGameFlag()
    {
        //false:通常ゲーム進行
        //true:プレイヤー死亡時
        return gameFlag;
    }
}
