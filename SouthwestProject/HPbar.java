import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HPbar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HPbar extends Actor
{
    GreenfootImage CurrentHP_img = new GreenfootImage("HP.png");
    GreenfootImage HP_img = new GreenfootImage("HP.png");
    GreenfootImage ReducedHP_img = new GreenfootImage("reducedHP.png");
    private int barWidth = 1200, barHeight = 20;
    private double current_HPrate = 1.0, goal_rate;
    /**
     * Act - do whatever the HPbar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public HPbar()
    {
        CurrentHP_img.scale(barWidth, barHeight);
        HP_img.scale(barWidth, barHeight);
        ReducedHP_img.scale(barWidth, barHeight);
    } 
    public void act()
    {
        if(goal_rate < current_HPrate)
        {
            current_HPrate -= (current_HPrate-goal_rate)*0.1;
            CurrentHP_img.drawImage(HP_img, (int)((double)barWidth*(1.0-current_HPrate)), 0);
            CurrentHP_img.drawImage(ReducedHP_img, (int)((double)barWidth*(-current_HPrate)), 0);
            setImage(CurrentHP_img);
        }
    }
    public void setHP(double rate)
    {
        CurrentHP_img.drawImage(HP_img, (int)((double)barWidth*(1.0-current_HPrate)), 0);
        CurrentHP_img.drawImage(ReducedHP_img, (int)((double)barWidth*(-current_HPrate)), 0);
        setImage(CurrentHP_img);
        goal_rate = rate;
    }
}
