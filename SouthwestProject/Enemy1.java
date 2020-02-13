import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy1 extends Actor
{
    private int baseHP = 50;
    private int HP = baseHP;
    private int x;
    
    private long interval = 1000;
    
    private long prevTime = System.currentTimeMillis();
    private long elapsedTime = 0;
    
    private GameManager manager;
    protected void addedToWorld(World world)
    {
        getImage().scale(28, 48);
        manager = getWorld().getObjects(GameManager.class).get(0);
    }
    
    /**
     * Act - do whatever the Enemy1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        long nowTime = System.currentTimeMillis();
        long deltaTime = nowTime - prevTime;
        elapsedTime += deltaTime;
        
        if(elapsedTime >= interval){
            getWorld().addObject(new EnemyBullet(), getX(), getY());
            elapsedTime = 0;
        }
        
        prevTime = nowTime;
        if(manager.getGameFlag() == true)
        {
             setLocation(getX(), getY()-10);
             if(getX()<=0||getY()<=0||getX()>=1279||getY()>=719)
             {
                 getWorld().removeObject(this);
             }
        }
    }
    
    public void damage(int damage){
        HP -= damage;
        if(HP <= 0){
            getWorld().removeObject(this);
        }
    }
}
