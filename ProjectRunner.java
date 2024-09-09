// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who 
// do.
// -- Yashili Thotakura (yashili)

package dailymixes;

import java.io.FileNotFoundException;
import java.text.ParseException;

/**
 * The main class responsible for running the project.
 * It initializes a PlaylistReader object to read input files and perform 
 * necessary operations.
 * 
 * The ProjectRunner class provides a main method to execute the project, 
 * which can handle command-line arguments
 * specifying input file names. If no arguments are provided, default file 
 * names are used.
 * 
 * @author Yashili Thotakura (yashili)
 * @version 2024.04.09
 */

public class ProjectRunner {
    
    //~ Constructors ..........................................................
    
    /**
     * The main method of the project.
     * 
     * @param args The command-line arguments specifying input file names 
     * (optional)
     * @throws ParseException If an error occurs while parsing input files
     * @throws DailyMixDataException If there is an issue with the daily mix 
     * data
     * @throws FileNotFoundException If the specified input files are not found
     */
    
    public static void main(String[] args) throws ParseException, 
    DailyMixDataException, FileNotFoundException {
        PlaylistReader reader;
        
        if (args.length == 2) {
            String songsFileName = args[0];
            String playlistsFileName = args[1];
            reader = new PlaylistReader(songsFileName, playlistsFileName);
        } else {
            reader = new PlaylistReader("input.txt", "playlists.txt");
        }
    }
}
