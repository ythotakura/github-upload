public class Circle implements Shape
{
    private int radius;
    public Circle(int r)
    {
        radius  = r;
    }

    public double getArea()
    {
        return (3.14 * radius * radius);
    }

    public double getPerimeter()
    {
        return(2 * 3.14 * radius);
    }
}