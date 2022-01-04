// Import statements needed for this class.
import java.util.ArrayList;
import java.util.Scanner;

public class ExampleForWhile 
{
    public static void main(String [] args) 
    {
        // Variables needed for this class.
        int math = 0;
        int num = 0;

        // ArrayList that holds the dice values.
        ArrayList <Integer> diceRoll = new ArrayList <Integer> ();

        // Asks the user how many times they want to roll the dice.
        Scanner input = new Scanner(System.in);
        System.out.println("How many times do you want to roll the dice?");

        // This while loop checks if the value given is an integer and positive.
        // Will ask the user to give another value if it does not meet the conditions.
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

        // This for loop gets the random dice values and puts them into the ArrayList.
        for(int i = 0; i < num; i++)
        {
            math = (int)((Math.random() * 6) + 1);
            diceRoll.add(math);
        }

        // Prints the values.
        System.out.println("Your rolls: " + diceRoll);
        input.close();
    }
}