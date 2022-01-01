public class Test 
{

      public static void main(String[] args) {
        // int num = 1327;
        // while(num % 3 == 0 && (num % 5 != 0) && num <= 4542)
        // {
        //     System.out.println(num);
        //         //if(num % 3 == 0 && num % 5 != 0){
        //     //count++;
        //     //}
        //     num++;
        // }

          Animals ani = new Animals();

          ani.setText("Monkey");
          ani.setVal(10);
         
          //System.out.println(ani.toString());

          Animals ani1 = new Animals("Dinosaur");
          System.out.println(ani1.toString());

          Animals ani2 = new Animals(15);
          ani2 = new Animals("test");
          ani2.setVal(10);
          //ani2.setText("Dog");
          System.out.println(ani2.toString());

         Animals ani3  = new Animals("hi", 19);
         System.out.println(ani3.toString());
          

          // call a constructor that will take text


      }  
}
