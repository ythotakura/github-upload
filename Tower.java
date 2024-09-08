package towerofhanoi;

// Virginia Tech Honor Code Pledge:
// Project 3 Spring 2024
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who 
// do.
// -- Yashili Thotakura (yashili)

/**
 * The Tower class represents a tower in the Tower of Hanoi puzzle.
 * It extends the LinkedStack class to manage disks stacked on the tower.
 * Each tower has a position (left, middle, or right) on the puzzle board.
 * Towers enforce the rule that a larger disk cannot be placed on top of a 
 * smaller disk.
 * 
 * 
 * @author Yashili Thotakura
 * @version 2024.03.19
 */

public class Tower extends LinkedStack<Disk> {
    //~ Fields ................................................................
    
    private Position position;
    
    //~ Constructors ..........................................................
    
    /**
     * Constructs a tower with the specified position.
     * 
     * @param position The position of the tower on the puzzle board.
     */
    
    public Tower(Position position) {
        super();
        this.position = position;
    }
    
    //~Public  Methods ........................................................
    
    /**
     * Retrieves the position of the tower on the puzzle board.
     * 
     * @return The position of the tower (left, middle, or right).
     */
    
    public Position position() {
        return position;
    }
    
    /**
     * Pushes a disk onto the top of the tower, enforcing the rule that a 
     * larger disk cannot be placed on top of a smaller disk.
     * 
     * @param disk The disk to be placed on top of the tower.
     * @throws IllegalStateException if the operation violates the rule of 
     * placing larger disks on top of smaller disks.
     */
    
    @Override
    public void push(Disk disk) {
        if (this.isEmpty() || peek().compareTo(disk) > 0) {
            super.push(disk);
        }
        
        else {
            throw new IllegalStateException();
        }
    }
}