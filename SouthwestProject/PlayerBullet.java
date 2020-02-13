import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerBullet extends Actor
{
    private int damage = 10;
    private int speed = 6;
    
    public PlayerBullet()
    {
        GreenfootImage image = getImage();
        image.scale(10, 10);
        setImage(image);
        Greenfoot.playSound("shoot2.mp3");
    }
    
    /**
     * Act - do whatever the PlayerBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setRotation(0);
        move(speed);
        
        int x = getX();
        int y = getY();
        
        Enemy1 enemy = (Enemy1)getOneObjectAtOffset(0, 0, Enemy1.class);
        if(enemy != null){
            handleCollisionEnemy1(enemy);
        }
        if(x<=0||y<=0||x>=1279||y>=719){
            getWorld().removeObject(this);
        }
    }
    
    protected void handleCollisionEnemy1(Enemy1 enemy){
        enemy.damage(damage);
        getWorld().removeObject(this);
    }  
}
