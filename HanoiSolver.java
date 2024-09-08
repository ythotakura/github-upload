package towerofhanoi;

// Virginia Tech Honor Code Pledge:
// Project 3 Spring 2024
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who 
// do.
// -- Yashili Thotakura (yashili)

import java.util.Observable;

/**
 * The HanoiSolver class represents the solver for the Tower of Hanoi puzzle.
 * It uses recursive algorithms to solve the puzzle with the specified number 
 * of disks.
 * 
 * @author Yashili Thotakura
 * @version 2024.03.19
 */

public class HanoiSolver extends Observable {
    //~ Fields ................................................................
    
    private Tower left;
    private Tower middle;
    private Tower right;
    private int numDisks;

    //~ Constructors ..........................................................
    
    /**
     * Constructs a new HanoiSolver object with the specified number of disks.
     *
     * @param numDisks the number of disks in the Tower of Hanoi puzzle
     */
    
    public HanoiSolver(int numDisks) {
        this.numDisks = numDisks;
        left = new Tower(Position.LEFT);
        middle = new Tower(Position.MIDDLE);
        right = new Tower(Position.RIGHT);
    }
    
    //~Public  Methods ........................................................
 
    /**
     * Returns the number of disks in the Tower of Hanoi puzzle.
     *
     * @return the number of disks
     */
    
    public int disks() {
        return numDisks;
    }
   
    /**
     * Returns the tower at the specified position.
     *
     * @param pos the position of the tower (LEFT, MIDDLE, or RIGHT)
     * @return the tower at the specified position
     */
    
    public Tower getTower(Position pos) {
        switch (pos) {
            case MIDDLE: 
                return middle;
        
            case RIGHT: 
                return right;
        
            default: 
                return left;
        }
    } 
    
    /**
     * Returns a string representation of the Tower of Hanoi puzzle.
     *
     * @return a string representation of the Tower of Hanoi puzzle
     */
    
    @Override
    public String toString() {
        String string = "";
        string += left.toString();
        string += middle.toString();
        string += right.toString();
        return string;
    }
    
    /**
     * Moves a disk from the source tower to the destination tower.
     *
     * @param source      the tower from which the disk is moved
     * @param destination the tower to which the disk is moved
     */
    
    private void move(Tower source, Tower destination) {
        destination.push(source.pop());
        setChanged();
        notifyObservers(destination.position());
    }
  
    /**
     * Solves the Tower of Hanoi puzzle recursively.
     *
     * @param currentDisks the number of disks to be moved
     * @param startPole    the starting tower
     * @param tempPole     the temporary tower
     * @param endPole      the ending tower
     */
    
    private void solveTowers(int currentDisks, Tower startPole, Tower tempPole, 
        Tower endPole) {
        if (currentDisks == 1) {
            move(startPole, endPole);
        }
        
        else {
            solveTowers(currentDisks - 1, startPole, endPole, tempPole);
            move(startPole, endPole);
            solveTowers(currentDisks - 1, tempPole, startPole, endPole);
        }
    }
    
    /**
     * Solves the Tower of Hanoi puzzle.
     */
    
    public void solve() {
        solveTowers(numDisks, left, middle, right);
    }
}