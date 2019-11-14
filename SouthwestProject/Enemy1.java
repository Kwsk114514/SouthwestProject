import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy1 extends Actor
{
    
    private long interval = 1000;
    
    private long prevTime = System.currentTimeMillis();
    private long elapsedTime = 0;
    
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
    }    
}
