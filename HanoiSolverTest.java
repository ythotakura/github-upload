package towerofhanoi;

// Virginia Tech Honor Code Pledge:
// Project 3 Spring 2024
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who 
// do.
// -- Yashili Thotakura (yashili)

/**
 * The HanoiSolverTest class is a test suite for the HanoiSolver class.
 * It contains test cases to verify the functionality of methods
 * implemented in the HanoiSolver class.
 * 
 * @author Yashili Thotakura
 * @version 2024.03.19
 */

public class HanoiSolverTest extends student.TestCase {
    //~ Fields ................................................................
    
    private HanoiSolver hanoiSolver;
    private Disk disk1;
    private Disk disk2;
    private Disk disk3;

    //~ Constructors ..........................................................
    
    /**
     * Sets up the test environment by initializing a HanoiSolver object with 3 
     * disks.
     */
    
    public void setUp() {
        hanoiSolver = new HanoiSolver(3);
        disk1 = new Disk(10);
        disk2 = new Disk(15);
        disk3 = new Disk(20);
    }

    /**
     * Test method for the disks() method of the HanoiSolver class.
     * Verifies that the number of disks in the Tower of Hanoi puzzle is 
     * returned correctly.
     */
    
    public void testDisks() {
        assertEquals(3, hanoiSolver.disks());
    }

    /**
     * Test method for the getTower method of the HanoiSolver class.
     * Verifies that the correct tower is returned based on the specified 
     * position.
     */
    
    public void testGetTower() {
        assertEquals(Position.LEFT, hanoiSolver.getTower(Position.LEFT).
            position());
        assertEquals(Position.MIDDLE, hanoiSolver.getTower(Position.MIDDLE).
            position());
        assertEquals(Position.RIGHT, hanoiSolver.getTower(Position.RIGHT).
            position());
    }
    
    /**
     * Tests the toString() method to make sure it returns the correct string
     */
    
    public void testToString() {
        hanoiSolver.getTower(Position.LEFT).push(disk3);
        hanoiSolver.getTower(Position.LEFT).push(disk2);
        hanoiSolver.getTower(Position.LEFT).push(disk1);
        assertFalse(hanoiSolver.toString().equals("[10, 15, 20][][][]"));
    }
    
    /**
     * Tests the solve() method
     */
    
    public void testSolve() {
        hanoiSolver.getTower(Position.LEFT).push(disk3);
        hanoiSolver.getTower(Position.LEFT).push(disk2);
        hanoiSolver.getTower(Position.LEFT).push(disk1);
        hanoiSolver.solve();
        assertEquals(3, hanoiSolver.getTower(Position.RIGHT).size());
    }
}
