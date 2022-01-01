import java.util.ArrayList;
import java.util.Scanner;
import java.math.*;
public class ExampleForWhile 
{
    public static void main(String [] args) 
    {
        int math = 0;
        int num = 0;
        ArrayList <Integer> diceRoll = new ArrayList <Integer> ();
        Scanner input = new Scanner(System.in);
        System.out.println("How many times do you want to roll the dice?");
        while(num <= 0)
        {
            if(input.hasNextInt())
            {
                num = input.nextInt();
                if(num < 0)
                {
                    System.out.println("Your integer needs to be greater than 0!");
                    System.out.println("How many times do you want to roll the dice?");
                }
            }
            else
            {
                System.out.println("You need to type an integer!");
                System.out.println("How many times do you want to roll the dice?");
                input.next();
            }
        }
        for(int i = 0; i < num; i++)
        {
            math = (int)((Math.random() * 6) + 1);
            diceRoll.add(math);
        }
        System.out.println("Your rolls: " + diceRoll);
    }
}