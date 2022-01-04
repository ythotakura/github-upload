public class Rectangle implements Shape
{
    private int width;
    private int height;
    public Rectangle(int w, int h)
    {
        width = w;
        height = h;
    }

    public double getArea()
    {
        return (width * height);
    }

    public double getPerimeter()
    {
        return((width * 2) + (height * 2));
    }
}