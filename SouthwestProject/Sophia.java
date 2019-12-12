import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sophia here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sophia extends Actor
{
    private int baseHP = 100;
    private int HP = baseHP;
    /**
     * Act - do whatever the Sophia wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    protected void addedToWorld(World world)
    {
        HPbar object = new HPbar();
        object.setHP(1.0);
        world.addObject(object, world.getWidth()/2, 20);
    }
    public void act() 
    {
        // Add your action code here.
       
       if( Greenfoot.isKeyDown( "right" ) ){
        setRotation(0);
        move(1);
    }
    if( Greenfoot.isKeyDown( "left" ) ){
        setRotation(0);
        move(-1);
    }
    if( Greenfoot.isKeyDown( "up" ) ){
        setRotation(270);
        move(1);
    }
    if( Greenfoot.isKeyDown( "down" ) ){
        setRotation(90);
        move(1);
    }



    }    
    public void damage(int damage)
    {
        HPbar hpbar = getWorld().getObjects(HPbar.class).get(0);
        
        HP -= damage;
        
        hpbar.setHP((double)HP / baseHP);
    }
}
