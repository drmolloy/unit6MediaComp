import java.awt.Rectangle;
public class BetterRectangle extends Rectangle
{
    public BetterRectangle()
    {
        super();
        super.setLocation(0,0);
        super.setSize(10,12);
    }
    public double getArea()
    {
        return this.width*this.height;
    }
    public double getPerimeter()
    {
        return (2*this.width)+(2*this.height);
    }
    public static void main(String[] args)
    {
        BetterRectangle rect = new BetterRectangle();
        System.out.println(rect.getArea());
    }
}
