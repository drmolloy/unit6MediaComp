

/**
 * Write a description of class ComboLock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComboLock
{
    /** description of instance variable x (add comment for each instance variable) */
    private int posOne;
    private int posTwo;
    private int posThree;
    private int currentOne;
    private int currentTwo;
    private int currentThree;
    private int currentPos;
    private int timesTurnedRight;
    private int totalTicks;
    private boolean open;

    /**
     * Default constructor for objects of class ComboLock
     */
    public ComboLock(int secret1, int secret2, int secret3)
    {
        this.posOne = secret1;
        this.posTwo = secret2;
        this.posThree = secret3;
        this.totalTicks = 40;
        this.currentOne = 0;
        this.currentTwo = 0;
        this.currentThree = 0;
        this.timesTurnedRight = 0;
        this.open = false;
        this.currentPos = 0;
    }

    public void reset()
    {
        this.currentPos = 0;
        this.open = false;
    }
    
    public void turnRight(int ticks)
    {
        if (ticks > this.currentPos)
        {
            int difference = this.currentPos - ticks;
            this.currentPos = this.totalTicks + difference;
            if (timesTurnedRight==0)
            {
                this.currentOne = this.currentPos;
            }
            if (timesTurnedRight == 1)
            {
                this.currentThree = this.currentPos;
            }
        }
        else 
        {
            this.currentPos -= ticks;
            if (timesTurnedRight==0)
            {
                this.currentOne = this.currentPos;
            }
            if (timesTurnedRight == 1)
            {
                this.currentThree = this.currentPos;
            }
        }
        
        timesTurnedRight++;
    }
    
    public void turnLeft(int ticks)
    {
        if (this.currentPos+ticks > totalTicks)
        {
            this.currentPos = this.currentPos + ticks - this.totalTicks;
            this.currentTwo = this.currentPos;
        }
        else
        {
            this.currentPos += ticks;
            this.currentTwo = this.currentPos;
        }
    }
    
    public boolean open()
    {
        if (currentOne == posOne && currentTwo == posTwo && currentThree == posThree && timesTurnedRight == 2)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static void main()
    {
        ComboLock lock = new ComboLock(10,20,30);
        lock.turnRight(30);
        lock.turnLeft(50);
        lock.turnRight(30);
        if (lock.open() == true)
        {
            System.out.println("OPEN");
        }
        else
        {
            System.out.println("Locked");
        }
    }
}
