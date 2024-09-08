package towerofhanoi;

// Virginia Tech Honor Code Pledge:
// Project 3 Spring 2024
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who 
// do.
// -- Yashili Thotakura (yashili)

/**
 * The DiskTest class is a test suite for the Disk class.
 * It contains test cases to verify the functionality of methods
 * implemented in the Disk class.
 * 
 * @author Yashili Thotakura
 * @version 2024.03.19
 */
public class DiskTest extends student.TestCase {
    //~ Constructors ..........................................................
    
    /**
     * Sets up the test environment by initializing a Disk object with width 10.
     * Verifies that the object is not null and has the correct width.
     */
    
    public void setUp() {
        Disk disk = new Disk(10);
        assertNotNull(disk);
        assertEquals(10, disk.getWidth());
    }
    
    //~Public  Methods ........................................................
    
    /**
     * Test method for the compareTo method of the Disk class.
     * Verifies that smaller disks compare less than larger disks,
     * and equal disks compare equally.
     */
    
    public void testCompareTo() {
        Disk smallerDisk = new Disk(5);
        Disk largerDisk = new Disk(15);
        Disk equalDisk = new Disk(10);
        assertTrue(smallerDisk.compareTo(largerDisk) < 0);
        assertTrue(largerDisk.compareTo(smallerDisk) > 0);
        assertEquals(0, equalDisk.compareTo(equalDisk));
    }

    /**
     * Test method for the toString method of the Disk class.
     * Verifies that the toString method returns the correct string 
     * representation of the disk's width.
     */
    
    public void testToString() {
        Disk disk = new Disk(10);
        assertEquals("10", disk.toString());
    }
    
    /**
     * Test method for the equals method of the Disk class.
     * Verifies that two disks with the same width are considered equal.
     */
    
    public void testEquals() {
        Disk disk1 = new Disk(10);
        Disk disk2 = new Disk(10);
        assertEquals(disk1, disk2);
    }
}