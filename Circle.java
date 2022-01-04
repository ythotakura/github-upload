// The class Circle implements the interface Shape.
public class Circle implements Shape
{
    // Variable used in this class.
    private int radius;

    // Constructor that sets the value for the radius.
    public Circle(int r)
    {
        radius  = r;
    }

    // Calculates the area of a circle.
    public double getArea()
    {
        return (3.14 * radius * radius);
    }

    // Calculates the perimeter of a circle.
    public double getPerimeter()
    {
        return(2 * 3.14 * radius);
    }
}