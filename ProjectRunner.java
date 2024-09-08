package towerofhanoi;

// Virginia Tech Honor Code Pledge:
// Project 3 Spring 2024
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who 
// do.
// -- Yashili Thotakura (yashili)

/**
 * The ProjectRunner class is responsible for running the Tower of Hanoi puzzle 
 * solver application.
 * It allows specifying the number of disks as a command-line argument or 
 * defaults to 6 disks.
 * It initializes the Tower of Hanoi solver and creates a graphical window to 
 * display the puzzle.
 * 
 * @author Yashili Thotakura
 * @version 2024.03.19
 */

public class ProjectRunner {
    
    /**
     * The main method of the Tower of Hanoi puzzle solver application.
     * 
     * @param args The command-line arguments. If provided, the first argument 
     * is interpreted as the number of disks.
     *             If no argument is provided, the default number of disks is 6
     */
    
    public static void main(String[] args) {
        int disks = 6;
        if (args.length == 1) {
            disks = Integer.parseInt(args[0]);
        }
        
        HanoiSolver hanoi = new HanoiSolver(disks);
        PuzzleWindow puzzleWindow = new PuzzleWindow(hanoi);
    }
}