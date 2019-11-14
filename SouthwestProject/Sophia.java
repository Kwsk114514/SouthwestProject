import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sophia here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sophia extends Actor
{
    /**
     * Act - do whatever the Sophia wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
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
}
