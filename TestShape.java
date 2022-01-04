public class TestShape 
{
    public static void main(String [] args)
    {
        Shape rectangle = new Rectangle(2, 3);
        Shape circle = new Circle(4);
        Shape square = new Square(6);

        print(rectangle);
        print(circle);
        print(square);
    }

    public static void print(Shape shape) 
    {
        System.out.println(shape.getArea());
        System.out.println(shape.getPerimeter());
    }
}