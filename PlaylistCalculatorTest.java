// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who 
// do.
// -- Yashili Thotakura (yashili)

package dailymixes;

/**
 * Test class for the PlaylistCalculator class.
 * 
 * @author Yashili Thotakura (yashili)
 * @version 2024.04.09
 */

public class PlaylistCalculatorTest extends student.TestCase {
    //~ Fields ................................................................
    
    private ArrayQueue<Song> songQueue;
    private Playlist[] playlists;
    private PlaylistCalculator calculator;

    //~ Constructors ..........................................................
    
    /**
     * Sets up the test fixture.
     * This method is called before each test case method.
     */
    
    public void setUp() {
        songQueue = new ArrayQueue<>();
        songQueue.enqueue(new Song("Song1", 50, 30, 20, ""));
        songQueue.enqueue(new Song("Song2", 40, 40, 20, ""));
        songQueue.enqueue(new Song("Song3", 30, 30, 40, ""));

        playlists = new Playlist[3];
        playlists[0] = new Playlist("Playlist1", 20, 30, 50, 30, 40, 30, 5);
        playlists[1] = new Playlist("Playlist2", 10, 20, 70, 40, 50, 10, 5);
        playlists[2] = new Playlist("Playlist3", 30, 30, 40, 20, 20, 60, 5);

        calculator = new PlaylistCalculator(songQueue, playlists);
    }
    
    /**
     * Tears down the test fixture.
     * This method is called after each test case method.
     */

    public void tearDown() {
        songQueue = null;
        playlists = null;
        calculator = null;
    }

    //~Public  Methods ........................................................
    
    /**
     * Test case for the addSongToPlaylist method.
     * Verifies that a song cannot be added to a playlist if the song queue is 
     * empty.
     * Also checks that the size of the song queue remains unchanged.
     */
    
    public void testAddSongToPlaylist() {
        assertFalse(calculator.addSongToPlaylist());
        assertEquals(3, songQueue.getSize());
    }

    /**
     * Test case for the getPlaylistIndex method.
     * Verifies that the correct index of a playlist is returned based on its 
     * name.
     * Checks both existing and non-existing playlist names.
     */

    public void testGetPlaylistIndex() {
        assertEquals(0, calculator.getPlaylistIndex("Playlist1"));
        assertEquals(1, calculator.getPlaylistIndex("Playlist2"));
        assertEquals(2, calculator.getPlaylistIndex("Playlist3"));
        assertEquals(-1, calculator.getPlaylistIndex("NonExistentPlaylist"));
    }
}
