public class Square implements Shape
{
    private int side;
    public Square(int s)
    {
        side = s;
    }

    public double getArea()
    {
        return (side * side);
    }

    public double getPerimeter()
    {
        return (side * 4);
    }
}