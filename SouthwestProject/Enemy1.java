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
    
    private long interval = 1000;
    
    private long prevTime = System.currentTimeMillis();
    private long elapsedTime = 0;
    
    protected void addedToWorld(World world)
    {
        getImage().scale(28, 48);
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
    }
    
    public void damage(int damage){
        HP -= damage;
        
        if(HP <= 0){
            getWorld().removeObject(this);
        }
    }
}
