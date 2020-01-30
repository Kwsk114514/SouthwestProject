import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sophia here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sophia extends Actor
{
    private int speed = 2;
    private int baseHP = 100;
    private int HP = baseHP;
    
    private long interval = 500;
    
    private long prevTime = System.currentTimeMillis();
    private long elapsedTime = 0;
    
    private boolean prevKeyDownZ = false;
    
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
       
        int x = getX();
        int y = getY();
        
        if( Greenfoot.isKeyDown( "right" ) ){
            x += speed;
        }
        if( Greenfoot.isKeyDown( "left" ) ){
            x -= speed;
        }
        if( Greenfoot.isKeyDown( "up" ) ){
            y -= speed;
        }
        if( Greenfoot.isKeyDown( "down" ) ){
            y += speed;
        }

        setLocation(x, y);
        
        long nowTime = System.currentTimeMillis();
        long deltaTime = nowTime - prevTime;
        elapsedTime += deltaTime;
        
        if(Greenfoot.isKeyDown("z")){
            if(!prevKeyDownZ || elapsedTime >= interval){
                getWorld().addObject(new PlayerBullet(), getX(), getY());
                elapsedTime = 0;
            }
            prevKeyDownZ = true;
        }else{
            prevKeyDownZ = false;
        }
        
        prevTime = nowTime;

    }    
    public void damage(int damage)
    {
        HPbar hpbar = getWorld().getObjects(HPbar.class).get(0);
        
        HP -= damage;
        
        hpbar.setHP((double)HP / baseHP);
    }
}
