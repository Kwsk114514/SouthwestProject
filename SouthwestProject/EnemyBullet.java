import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyBullet extends Actor
{
    private int damage = 10;
    
    public EnemyBullet()
    {
        GreenfootImage image = getImage();
        image.scale(10, 10);
        setImage(image);
    }
    /**
     * Act - do whatever the EnemyBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setRotation(-180);
        move(1);
        
        Sophia sophia = (Sophia)getOneObjectAtOffset(0, 0, Sophia.class);
        if(sophia != null){
            handleCollisionSophia(sophia);
        }
    }
    
    protected void handleCollisionSophia(Sophia sophia){
        sophia.damage(damage);
        getWorld().removeObject(this);
    }
}
