// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who 
// do.
// -- Yashili Thotakura (yashili)

package dailymixes;

/**
 * Custom exception class for DailyMix data-related exceptions.
 * This exception is used to indicate issues related to the DailyMix data.
 * 
 * @author Yashili Thotakura (yashili)
 * @version 2024.04.09
 */

public class DailyMixDataException extends Exception {
    //~ Constructors ..........................................................
    
    /**
     * Constructs a new DailyMixDataException with the specified detail message.
     * @param message The detail message (which is saved for later retrieval by 
     * the getMessage() method).
     */
    
    public DailyMixDataException(String message) {
        super(message);
    }
}
