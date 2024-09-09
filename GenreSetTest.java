// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who 
// do.
// -- Yashili Thotakura (yashili)

package dailymixes;

/**
 * This class contains test cases for the GenreSet class.
 * 
 * @author Yashili Thotakura (yashili)
 * @version 2024.04.02
 */

public class GenreSetTest extends student.TestCase {
    //~ Fields ................................................................
    
    private GenreSet genreSet1;
    private GenreSet genreSet2;
    private GenreSet genreSet3;
    private GenreSet genreSet4;
    private GenreSet genreSet5;
    private GenreSet genreSet6;
    
    //~ Constructors ..........................................................
    
    /**
     * Sets up the test fixtures.
     */
    
    public void setUp() {
        genreSet1 = new GenreSet(20, 30, 40);
        genreSet2 = new GenreSet(40, 50, 60);
        genreSet3 = new GenreSet(30, 40, 50);
        genreSet4 = new GenreSet(10, 20, 30);
        genreSet5 = new GenreSet(50, 60, 70);
        genreSet6 = new GenreSet(20, 30, 40);
    }
    
    //~Public  Methods ........................................................
    
    /**
     * Tests the isWithinRange method of the GenreSet class.
     */
    
    public void testIsWithinRange() {
        assertTrue(genreSet3.isWithinRange(genreSet1, genreSet2));
        assertFalse(genreSet4.isWithinRange(genreSet1, genreSet2));
        assertFalse(genreSet5.isWithinRange(genreSet1, genreSet2));
    }

    /**
     * Tests the equals method of the GenreSet class.
     */
    
    public void testEquals() {
        assertTrue(genreSet1.equals(genreSet6));
        assertFalse(genreSet1.equals(genreSet4));
    }

    /**
     * Tests the compareTo method of the GenreSet class.
     */

    public void testCompareTo() {
        assertTrue(genreSet1.compareTo(genreSet3) < 0);
        assertTrue(genreSet3.compareTo(genreSet4) > 0);
        assertEquals(0, genreSet1.compareTo(genreSet1));
    }

    /**
     * Tests the toString method of the GenreSet class.
     */
    
    public void testToString() {
        assertEquals("Pop:20 Rock:30 Country:40", genreSet1.toString());
    }
}