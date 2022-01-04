// The class Rectangle implements the interface Shape.
public class Rectangle implements Shape
{
    // Variables used in this class.
    private int width;
    private int height;
    
    // Constructor that sets the values for the width and the height.
    public Rectangle(int w, int h)
    {
        width = w;
        height = h;
    }

    // Calculates the area of a rectangle.
    public double getArea()
    {
        return (width * height);
    }

    // Calculates the perimeter of a rectangle.
    public double getPerimeter()
    {
        return((width * 2) + (height * 2));
    }
}