import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.List;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Write a description of class EnemyManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyManager extends Actor
{
    protected String csvpath = "enemy.csv";
    protected ArrayList<EnemySchedule> timeline;
    protected ArrayList<EnemySchedule> currentTimeline;
    
    private long prevTime = -1;
    private long elapsedTime = 0;
    
    public EnemyManager()
    {
        getImage().setTransparency(0);
        
        timeline = new ArrayList<EnemySchedule>();
        
        try{
            URL path = getClass()
                .getClassLoader()
                .getResource(csvpath);
            InputStream input = path.openStream();
            BufferedReader br = new BufferedReader(
                new InputStreamReader(input)
            );
            
            String line = null;
            while((line = br.readLine()) != null){
                String l[] = line.split(",");
                if(l.length == 0) continue;
                try{
                    timeline.add(new EnemySchedule(
                        Integer.parseInt(l[0].trim()),
                        Integer.parseInt(l[1].trim()),
                        Integer.parseInt(l[2].trim())
                    ));
                }catch(NumberFormatException e){
                    continue;
                }
            }
            
            br.close();
        }catch(Exception e){
            
        }
        
        currentTimeline = (ArrayList<EnemySchedule>)timeline.clone();
    }
    
    protected void addedToWorld(World world)
    {
        
    }
    
    /**
     * Act - do whatever the EnemyManager wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(prevTime == -1) prevTime = System.currentTimeMillis();
        
        long nowTime = System.currentTimeMillis();
        long deltaTime = nowTime - prevTime;
        elapsedTime += deltaTime;
        // getWorld().showText("time: " + elapsedTime, 100, 100);
        
        for(int i = 0; i < currentTimeline.size(); i++){
            EnemySchedule s = currentTimeline.get(0);
            if(s.getTime() <= elapsedTime){
                currentTimeline.remove(0);
                getWorld().addObject(new Enemy1(), s.getX(), s.getY());
            }else{
                break;
            }
        }

        prevTime = nowTime;
    }    
}
