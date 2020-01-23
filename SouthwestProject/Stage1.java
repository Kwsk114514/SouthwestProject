
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stage1 extends World
{
    GreenfootImage background_img = new GreenfootImage("Background.jpg");
    GreenfootImage myworld_img = getBackground();
    
    private int scroll_vel = -1;
    private int imgpos1_x = 0;
    private int imgpos2_x = 2862;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Stage1()
    {
        super(1280, 720, 1); 
        background_img.scale(2862, 720);
        myworld_img.drawImage(background_img, imgpos1_x, 0);
        myworld_img.drawImage(background_img, imgpos2_x, 0);
        
        addObject(new EnemyManager(), 0, 0);
        addObject(new Sophia(), 200, getHeight() / 2);
        
    }
    public void act()
    {
        Scroll_image();
    }
    private void Scroll_image()
    {
        imgpos1_x += scroll_vel;
        imgpos2_x += scroll_vel;
        myworld_img.drawImage(background_img, imgpos1_x, 0);
        myworld_img.drawImage(background_img, imgpos2_x, 0);
        if(imgpos1_x <= -2862)
        {
            imgpos1_x = 2862;
        }
        if(imgpos2_x <= -2862)
        {
            imgpos2_x = 2862;
        }
    }
}
