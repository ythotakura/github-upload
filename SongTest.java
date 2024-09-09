// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who 
// do.
// -- Yashili Thotakura (yashili)

package dailymixes;

/**
 * This class contains test cases for the Song class.
 * 
 * @author Yashili Thotakura (yashili)
 * @version 2024.04.02
 */

public class SongTest extends student.TestCase {
    //~ Fields ................................................................
    
    private Song song1;
    private Song song2;
    private Song song3;
    
    //~ Constructors ..........................................................
    
    /**
     * Sets up the test fixtures.
     */
    
    public void setUp() {
        song1 = new Song("Song1", 20, 30, 40, "Playlist1");
        song2 = new Song("Song2", 30, 40, 50, "");
        song3 = new Song("Song1", 20, 30, 40, "Playlist1");
    }
    
    //~Public  Methods ........................................................
    
    /**
     * Tests the getPlaylistName method of the Song class.
     */

    public void testGetPlaylistName() {
        assertEquals("Playlist1", song1.getPlaylistName());
        assertEquals("", song2.getPlaylistName());
    }

    /**
     * Tests the toString method of the Song class.
     */

    public void testToString() {
        assertEquals("Song1 Pop:20 Rock:30 Country:40 Suggested: Playlist1", 
            song1.toString());
        assertEquals("Song2 Pop:30 Rock:40 Country:50 No-Playlist", 
            song2.toString());
    }

    /**
     * Tests the equals method of the Song class.
     */

    public void testEquals() {
        assertTrue(song1.equals(song1));
        assertTrue(song1.equals(song3));
        assertFalse(song1.equals(song2));
        
        Song song4 = new Song("Song4", 20, 30, 40, "Playlist1");
        assertFalse(song1.equals(song4));

        Song diffPop = new Song("Song1", 30, 30, 40, "Playlist1");
        assertFalse(song1.equals(diffPop));

        Song diffRock = new Song("Song1", 20, 40, 40, "Playlist1");
        assertFalse(song1.equals(diffRock));

        Song diffCountry = new Song("Song1", 20, 30, 50, "Playlist1");
        assertFalse(song1.equals(diffCountry));

        Song diffPlaylist = new Song("Song1", 20, 30, 40, "DifferentPlaylist");
        assertFalse(song1.equals(diffPlaylist));
    }
    
    /**
     * Tests the getGenreSet method of the Song class.
     * It verifies if the method returns the correct GenreSet object
     * representing the genres of the song.
     */
    
    public void testgetGenreSet() {
        GenreSet genreSet = song1.getGenreSet();
        assertEquals(20, genreSet.getPop());
        assertEquals(30, genreSet.getRock());
        assertEquals(40, genreSet.getCountry());
    }
}
