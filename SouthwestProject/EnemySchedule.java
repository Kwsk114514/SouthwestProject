/**
 * Write a description of class EnemySchedule here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemySchedule  
{
    private int x;
    private int y;
    private int time;

    public EnemySchedule(int time, int x, int y)
    {
        this.x = x;
        this.y = y;
        this.time = time;
    }

    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public int getTime(){
        return time;
    }
}
