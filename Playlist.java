// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who 
// do.
// -- Yashili Thotakura (yashili)

package dailymixes;

/**
 * Represents a playlist with a set of songs and specific genre requirements.
 * This class implements Comparable interface to enable comparison between 
 * playlists based on various criteria.
 *  
 * @author Yashili Thotakura (yashili)
 * @version 2024.04.09
 */

public class Playlist implements Comparable<Playlist> {
    //~ Fields ................................................................
    
    private GenreSet minGenreSet;
    private GenreSet maxGenreSet;
    private Song[] songs;
    private int capacity;
    private int numberOfSongs;
    private String name;

    //~ Constructors ..........................................................
    
    /**
     * Constructs a Playlist object with the specified parameters.
     * 
     * @param playlistName Name of the playlist
     * @param minPop Minimum percentage of pop songs required in the playlist
     * @param minRock Minimum percentage of rock songs required in the playlist
     * @param minCountry Minimum percentage of country songs required in the 
     *      playlist
     * @param maxPop Maximum percentage of pop songs allowed in the playlist
     * @param maxRock Maximum percentage of rock songs allowed in the playlist
     * @param maxCountry Maximum percentage of country songs allowed in the 
     *      playlist
     * @param playlistCap Maximum capacity of the playlist
     */
    
    public Playlist(String playlistName, int minPop, int minRock, 
        int minCountry, int maxPop, int maxRock, int maxCountry, 
        int playlistCap) {
        this.name = playlistName;
        this.minGenreSet = new GenreSet(minPop, minRock, minCountry);
        this.maxGenreSet = new GenreSet(maxPop, maxRock, maxCountry);
        this.capacity = playlistCap;
        this.numberOfSongs = 0;
        this.songs = new Song[playlistCap];
    }

    //~Public  Methods ........................................................
    
    /**
     * Retrieves the minimum genre requirements for the playlist.
     * 
     * @return The minimum genre requirements for the playlist
     */
    
    public GenreSet getMinGenreSet() {
        return minGenreSet;
    }

    /**
     * Sets the name of the playlist.
     * 
     * @param name The name to set for the playlist
     */
    
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the number of spaces left in the playlist.
     * 
     * @return The number of spaces left in the playlist
     */
    
    public int getSpacesLeft() {
        return capacity - numberOfSongs;
    }

    /**
     * Retrieves the maximum genre requirements for the playlist.
     * 
     * @return The maximum genre requirements for the playlist
     */
    
    public GenreSet getMaxGenreSet() {
        return maxGenreSet;
    }

    /**
     * Compares this playlist with another playlist based on various criteria.
     * 
     * @param other The other playlist to compare with
     * @return A negative integer, zero, or a positive integer as this playlist
     *         is less than, equal to, or greater than the specified playlist.
     */
    
    public int compareTo(Playlist other) {
        int capacityComparison = Integer.compare(capacity, other.capacity);
        if (capacityComparison != 0) {
            return capacityComparison;
        }
        
        int spacesLeftComparison = Integer.compare(getSpacesLeft(), 
            other.getSpacesLeft());
        if (spacesLeftComparison != 0) {
            return spacesLeftComparison;
        }
        
        int minGenreComparison = minGenreSet.compareTo(other.minGenreSet);
        if (minGenreComparison != 0) {
            return minGenreComparison;
        }
        
        int maxGenreComparison = maxGenreSet.compareTo(other.maxGenreSet);
        if (maxGenreComparison != 0) {
            return maxGenreComparison;
        }
        
        return name.compareTo(other.name);
    }

    /**
     * Retrieves the number of songs currently in the playlist.
     * 
     * @return The number of songs currently in the playlist
     */
    
    public int getNumberOfSongs() {
        return numberOfSongs;
    }

    /**
     * Adds a new song to the playlist if it meets the genre requirements and 
     * the playlist is not full.
     * 
     * @param newSong The song to add to the playlist
     * @return true if the song was successfully added, false otherwise
     */
    
    public boolean addSong(Song newSong) {
        if (isFull() || !isQualified(newSong)) {
            return false;
        }
        
        songs[numberOfSongs++] = newSong;
        return true;
    }

    /**
     * Retrieves a string representation of the playlist.
     * 
     * @return A string representation of the playlist
     */
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Playlist: ").append(name);
        sb.append(", # of songs: ").append(numberOfSongs);
        sb.append(" (cap: ").append(capacity).append("), Requires: ");
        sb.append("Pop:").append(minGenreSet.getPop()).append("%-").
        append(maxGenreSet.getPop()).append("%, ");
        sb.append("Rock:").append(minGenreSet.getRock()).append("%-").
        append(maxGenreSet.getRock()).append("%, ");
        sb.append("Country:").append(minGenreSet.getCountry()).append("%-").
        append(maxGenreSet.getCountry()).append("%");
        return sb.toString();
    }

    /**
     * Checks if the playlist is full.
     * 
     * @return true if the playlist is full, false otherwise
     */
    
    public boolean isFull() {
        return numberOfSongs == capacity;
    }
    
    /**
     * Checks if the current playlist is equal to another object.
     * 
     * @param obj The object to compare with
     * @return true if the current playlist is equal to the specified object, 
     * false otherwise
     */

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (!(obj instanceof Playlist)) {
            return false;
        }
        
        Playlist other = (Playlist) obj;
        if (capacity != other.capacity || numberOfSongs != other.numberOfSongs 
            || !name.equals(other.name) ||
                !minGenreSet.equals(other.minGenreSet) || 
                !maxGenreSet.equals(other.maxGenreSet)) {
            return false;
        }
        
        for (int i = 0; i < numberOfSongs; i++) {
            if (!songs[i].equals(other.songs[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Retrieves the array of songs in the playlist.
     * 
     * @return The array of songs in the playlist
     */
    
    public Song[] getSongs() {
        return songs;
    }
    
    /**
     * Retrieves the maximum capacity of the playlist.
     * 
     * @return The maximum capacity of the playlist
     */

    public int getCapacity() {
        return capacity;
    }
    
    /**
     * Retrieves the name of the playlist.
     * 
     * @return The name of the playlist
     */

    public String getName() {
        return name;
    }
    
    /**
     * Checks if a given song meets the genre requirements of the playlist.
     * 
     * @param possibleSong The song to check
     * @return true if the song meets the genre requirements, false otherwise
     */

    public boolean isQualified(Song possibleSong) {
        GenreSet songGenreSet = possibleSong.getGenreSet();
        return songGenreSet.getPop() >= minGenreSet.getPop() &&
                songGenreSet.getPop() <= maxGenreSet.getPop() &&
                songGenreSet.getRock() >= minGenreSet.getRock() &&
                songGenreSet.getRock() <= maxGenreSet.getRock() &&
                songGenreSet.getCountry() >= minGenreSet.getCountry() &&
                songGenreSet.getCountry() <= maxGenreSet.getCountry();
    }
}