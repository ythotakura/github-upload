// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who 
// do.
// -- Yashili Thotakura (yashili)

package dailymixes;

import list.AList;

/**
 * The PlaylistCalculator class manages the addition of songs to playlists.
 * It contains methods to reject songs, add songs to playlists, and determine 
 * the appropriate playlist for a song.
 * 
 * The class maintains a list of playlists, a queue of songs waiting to be 
 * added to playlists,
 * and a list of rejected songs.
 * 
 * @author Yashili Thotakura (yashili)
 * @version 2024.04.09
 */

public class PlaylistCalculator {
    //~ Fields ................................................................
    
    private Playlist[] playlists;
    
    /**
     * The number of playlists available in the system.
     */
    
    public static final int NUM_PLAYLISTS = 3;
    
    /**
     * The minimum percentage value.
     * This constant represents the minimum percentage value that can be used 
     * in the system.
     */
    
    public static final int MIN_PERCENT = 0;
    private AList<Song> rejectedTracks;
    private ArrayQueue<Song> songQueue;
    
    /**
     * The maximum percentage value.
     * This constant represents the maximum percentage value that can be used 
     * in the system.
     */
    
    public static final int MAX_PERCENT = 100;

    //~ Constructors ..........................................................
    
    /**
     * Constructs a PlaylistCalculator with the given song queue and playlists.
     * 
     * @param songQueue The queue of songs waiting to be added to playlists
     * @param playlists The array of playlists available for adding songs
     * @throws IllegalArgumentException if the song queue or playlists are null
     */
    
    public PlaylistCalculator(ArrayQueue<Song> songQueue, Playlist[] playlists) 
    {
        if (songQueue == null || playlists == null) {
            throw new IllegalArgumentException("Song queue and playlists "
                + "cannot be null");
        }
        
        this.songQueue = songQueue;
        this.playlists = playlists;
        this.rejectedTracks = new AList<>();
    }
    
    //~Public  Methods ........................................................
    
    /**
     * Rejects the next song in the queue by removing it from the queue and 
     * adding it to the list of rejected tracks.
     */
    
    public void reject() {
        if (!songQueue.isEmpty()) {
            Song rejectedSong = songQueue.dequeue();
            rejectedTracks.add(rejectedSong);
        }
    }

    /**
     * Finds the playlist with the maximum capacity that can accept the given 
     * song.
     * 
     * @param aSong The song for which to find the playlist
     * @return The playlist with the maximum capacity that can accept the song, 
     * or null if no such playlist is found
     */
    
    private Playlist getPlaylistWithMaximumCapacity(Song aSong) {
        Playlist maxCapacityPlaylist = null;
        int maxCapacity = Integer.MIN_VALUE;

        for (Playlist playlist : playlists) {
            if (!playlist.isFull() && playlist.isQualified(aSong) && 
                playlist.getCapacity() > maxCapacity) {
                maxCapacity = playlist.getCapacity();
                maxCapacityPlaylist = playlist;
            }
        }

        return maxCapacityPlaylist;
    }

    /**
     * Adds the next song in the queue to an appropriate playlist, if possible.
     * 
     * @return true if the song is successfully added to a playlist, false 
     * otherwise
     */
    
    public boolean addSongToPlaylist() {
        if (songQueue.isEmpty()) {
            return false;
        }

        Song nextSong = songQueue.getFront();
        Playlist playlist = getPlaylistForSong(nextSong);
        if (playlist != null) {
            playlist.addSong(songQueue.dequeue());
            return true;
        }
        return false;
    }
    
    /**
     * Determines the appropriate playlist for the given song.
     * 
     * @param nextSong The song for which to find the playlist
     * @return The playlist for the given song, or null if no appropriate 
     * playlist is found
     */
    
    public Playlist getPlaylistForSong(Song nextSong) {
        if (nextSong == null) {
            return null;
        }
        
        return getPlaylistWithMaximumCapacity(nextSong);
    }

    /**
     * Retrieves the queue of songs waiting to be added to playlists.
     * 
     * @return The queue of songs
     */
    
    public ArrayQueue<Song> getQueue() {
        return songQueue;
    }

    /**
     * Retrieves the index of the playlist with the given name.
     * 
     * @param playlist The name of the playlist
     * @return The index of the playlist, or -1 if the playlist is not found
     */

    public int getPlaylistIndex(String playlist) {
        for (int i = 0; i < playlists.length; i++) {
            if (playlists[i].getName().equals(playlist)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Retrieves the array of playlists managed by this calculator.
     * 
     * @return The array of playlists
     */
    
    public Playlist[] getPlaylists() {
        return playlists;
    }

}