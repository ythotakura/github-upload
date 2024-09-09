// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who 
// do.
// -- Yashili Thotakura (yashili)

package dailymixes;

/**
 * Test class for the Playlist class.
 * 
 * @author Yashili Thotakura (yashili)
 * @version 2024.04.09
 */

public class PlaylistTest extends student.TestCase {
    //~ Fields ................................................................
    
    private Playlist playlist1;
    private Playlist playlist2;
    private Playlist playlist3;
    private Song song1;
    private Song song2;
    private Song song3;

    //~ Constructors ..........................................................
    
    /**
     * Sets up the test fixture.
     * This method is called before each test case method.
     */
    
    public void setUp() {
        playlist1 = new Playlist("Playlist1", 10, 20, 30, 50, 60, 70, 100);
        playlist2 = new Playlist("Playlist2", 20, 30, 40, 60, 70, 80, 150);
        playlist3 = new Playlist("Playlist3", 30, 40, 50, 70, 80, 90, 200);
        
        song1 = new Song("Song1", 10, 20, 30, "Playlist1");
        song2 = new Song("Song2", 20, 30, 40, "Playlist2");
        song3 = new Song("Song3", 30, 40, 50, "Playlist3");
    }

    //~Public  Methods ........................................................
    
    /**
     * Test case for the getName method.
     * Verifies that the correct name is returned for each playlist.
     */
    
    public void testGetName() {
        assertEquals("Playlist1", playlist1.getName());
        assertEquals("Playlist2", playlist2.getName());
        assertEquals("Playlist3", playlist3.getName());
    }

    /**
     * Test case for the getMinGenreSet method.
     * Verifies that the correct minimum genre set is returned for each 
     * playlist.
     */
    
    public void testGetMinGenreSet() {
        assertEquals(new GenreSet(10, 20, 30), playlist1.getMinGenreSet());
        assertEquals(new GenreSet(20, 30, 40), playlist2.getMinGenreSet());
        assertEquals(new GenreSet(30, 40, 50), playlist3.getMinGenreSet());
    }

    /**
     * Test case for the getMaxGenreSet method.
     * Verifies that the correct maximum genre set is returned for each 
     * playlist.
     */
    
    public void testGetMaxGenreSet() {
        assertEquals(new GenreSet(50, 60, 70), playlist1.getMaxGenreSet());
        assertEquals(new GenreSet(60, 70, 80), playlist2.getMaxGenreSet());
        assertEquals(new GenreSet(70, 80, 90), playlist3.getMaxGenreSet());
    }

    /**
     * Test case for the addSong method.
     * Verifies that songs can be added to playlists.
     */
    
    public void testAddSong() {
        assertTrue(playlist1.addSong(song1));
        assertTrue(playlist2.addSong(song2));
        assertTrue(playlist3.addSong(song3));
    }
    
    /**
     * Test case for the isFull method.
     * Verifies that playlists are correctly identified as full or not.
     */

    public void testIsFull() {
        assertFalse(playlist1.isFull());
        assertFalse(playlist2.isFull());
        assertFalse(playlist3.isFull());
        
        for (int i = 0; i < playlist1.getCapacity(); i++) {
            playlist1.addSong(new Song("Song" + i, 10, 20, 30, "Playlist1"));
            playlist2.addSong(new Song("Song" + i, 20, 30, 40, "Playlist2"));
            playlist3.addSong(new Song("Song" + i, 30, 40, 50, "Playlist3"));
        }
        
        assertTrue(playlist1.isFull());
    }

    /**
     * Test case for the getNumberOfSongs method.
     * Verifies that the correct number of songs is returned for each playlist.
     */
    
    public void testGetNumberOfSongs() {
        assertEquals(0, playlist1.getNumberOfSongs());
        assertEquals(0, playlist2.getNumberOfSongs());
        assertEquals(0, playlist3.getNumberOfSongs());
        
        playlist1.addSong(song1);
        playlist2.addSong(song2);
        playlist3.addSong(song3);
        
        assertEquals(1, playlist1.getNumberOfSongs());
        assertEquals(1, playlist2.getNumberOfSongs());
        assertEquals(1, playlist3.getNumberOfSongs());
    }

    /**
     * Test case for the isQualified method.
     * Verifies that songs are correctly qualified for playlists.
     */
    
    public void testIsQualified() {
        assertTrue(playlist1.isQualified(song1));
        assertTrue(playlist2.isQualified(song2));
        assertTrue(playlist3.isQualified(song3));
    }
    
    /**
     * Test case for the toString method.
     * Verifies that the string representation of each playlist is correct.
     */

    public void testToString() {
        assertEquals("Playlist: Playlist1, # of songs: 0 (cap: 100), "
            + "Requires: Pop:10%-50%, Rock:20%-60%, Country:30%-70%", 
            playlist1.toString());
        assertEquals("Playlist: Playlist2, # of songs: 0 (cap: 150), "
            + "Requires: Pop:20%-60%, Rock:30%-70%, Country:40%-80%", 
            playlist2.toString());
        assertEquals("Playlist: Playlist3, # of songs: 0 (cap: 200), "
            + "Requires: Pop:30%-70%, Rock:40%-80%, Country:50%-90%", 
            playlist3.toString());
    }
}