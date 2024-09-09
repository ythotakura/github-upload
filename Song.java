// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who 
// do.
// -- Yashili Thotakura (yashili)

package dailymixes;

/**
 * The Song class represents a single song with its attributes like name, 
 * popularity scores in various genres, and a suggested playlist.
 * 
 * @author Yashili Thotakura (yashili)
 * @version 2024.04.02
 */

public class Song {
    //~ Fields ................................................................
    
    private String name;
    private String suggestedPlaylist;
    private GenreSet genreSet;

    //~ Constructors ..........................................................
    
    /**
     * Constructs a Song object with the given parameters.
     * 
     * @param name              The name of the song
     * @param pop               Popularity score of the song in the pop genre
     * @param rock              Popularity score of the song in the rock genre
     * @param country           Popularity score of the song in the country 
     *      genre
     * @param suggestedPlaylist The suggested playlist for the song
     */
    
    public Song(String name, int pop, int rock, int country, String 
        suggestedPlaylist) {
        this.name = name;
        this.genreSet = new GenreSet(pop, rock, country);
        this.suggestedPlaylist = suggestedPlaylist;
    }
    
    //~Public  Methods ........................................................
    
    /**
     * Returns a string representation of the Song object.
     * @return A string representation of the Song object
     */
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" ")
          .append(genreSet).append(" ");
        if (!suggestedPlaylist.isEmpty()) {
            sb.append("Suggested: ").append(suggestedPlaylist);
        } 
        
        else {
            sb.append("No-Playlist");
        }
        
        return sb.toString();
    }
    
    /**
     * Gets the suggested playlist for the song.
     * @return The suggested playlist for the song
     */

    public String getPlaylistName() {
        return suggestedPlaylist;
    }
    
    /**
     * Checks if this Song object is equal to another object.
     * @param obj The object to compare with
     * @return True if the objects are equal, false otherwise
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        Song song = (Song) obj;
        return name.equals(song.name) && genreSet.equals(song.genreSet) && 
            suggestedPlaylist.equals(song.suggestedPlaylist);
    }
    
    /**
     * Retrieves the name of the song.
     * 
     * @return The name of the song.
     */
    
    public String getName() {
        return name;
    }

    /**
     * Retrieves the genre set associated with the song.
     * 
     * @return The genre set object representing the genres of the song.
     */
    
    public GenreSet getGenreSet() {
        return genreSet;
    }
}
