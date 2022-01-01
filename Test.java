public class Test 
{
    public static void main(String[] args) 
    {
        Animals ani = new Animals();
        ani.setText("Monkey");
        ani.setVal(10);
        Animals ani1 = new Animals("Dinosaur");
        System.out.println(ani1.toString());

        Animals ani2 = new Animals(15);
        ani2 = new Animals("test");
        ani2.setVal(10);
        System.out.println(ani2.toString());

        Animals ani3  = new Animals("hi", 19);
        System.out.println(ani3.toString());
    }  
}