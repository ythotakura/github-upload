package towerofhanoi;

//Virginia Tech Honor Code Pledge:
//Project 3 Spring 2024
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those who 
//do.
//-- Yashili Thotakura (yashili)

/**
 * The TowerTest class is a test suite for the Tower class.
 * It contains test cases to verify the functionality of methods
 * implemented in the Tower class.
 * 
 * @author Yashili Thotakura
 * @version 2024.03.19
 */

public class TowerTest extends student.TestCase {
    //~ Fields ................................................................
    
    private Tower tower;
    
    //~ Constructors ..........................................................
    
    /**
     * Sets up the test environment by initializing an empty Tower.
     */
    
    public void setUp() {
        tower = new Tower(Position.LEFT);
    }
    
    //~Public  Methods ........................................................
    
    /**
     * Test method for the position() method of the Tower class.
     * Verifies that the correct position of the tower is returned.
     */
    
    public void testPosition() {
        assertEquals(Position.LEFT, tower.position());
    }

    /**
     * Test method for the pop() method of the Tower class.
     * Verifies that disks are popped from the tower correctly.
     */

    public void testPop() {
        Disk disk = new Disk(5);
        tower.push(disk);

        assertEquals(disk, tower.pop());
        assertTrue(tower.isEmpty());
    }

    /**
     * Test method for the isEmpty() method of the Tower class.
     * Verifies that isEmpty method returns true when the tower is empty and 
     * false otherwise.
     */

    public void testIsEmpty() {
        assertTrue(tower.isEmpty());
        tower.push(new Disk(5));
        assertFalse(tower.isEmpty());
    }
}
