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
    private int gameFlag = 0;
    private int worldWidth, worldHeight;
    private Enemy1 [] enemys;
    private int enemySize = 0;
    private int anySpeed = 0;
    protected void addedToWorld(World world)
    {
        worldWidth = world.getWidth();
        worldHeight = world.getHeight();
    }
    public void act() 
    {
        if(gameFlag == 1)
        {
            for(int i=0;i < enemySize;i++)
            {
                enemys[i].setLocation(enemys[i].getX(), enemys[i].getY()-anySpeed);
            }
            anySpeed += 1;
        }
    }
    public void setGameFlag(int flag)
    {
        if(gameFlag != 1 && flag == 1)
        {
            getWorld().addObject(new GameOverImage(), -100, worldHeight);
            enemys = new Enemy1 [getWorld().getObjects(Enemy1.class).size()];
            for(int i=0;i < getWorld().getObjects(Enemy1.class).size();i++)
            {
                enemys[i] = getWorld().getObjects(Enemy1.class).get(i);
            }
            enemySize = enemys.length;
            gameFlag = flag;
        }
    }
}
