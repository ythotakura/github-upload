// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who 
// do.
// -- Yashili Thotakura (yashili)

package dailymixes;

/**
 * The GenreSet class represents a set of genre scores, including rock, pop, 
 * and country. It provides methods to compare genre sets and check if a genre 
 * set falls within a specified range.
 * 
 * @author Yashili Thotakura (yashili)
 * @version 2024.04.02
 */

public class GenreSet implements Comparable<GenreSet> {
    //~ Fields ................................................................
    
    private int pop;
    private int rock;
    private int country;
    
    //~ Constructors ..........................................................
    
    /**
     * Constructs a GenreSet object with the given genre scores.
     * @param pop The score in pop genre
     * @param rock The score in rock genre
     * @param country The score in country genre
     */

    public GenreSet(int pop, int rock, int country) {
        this.pop = pop;
        this.rock = rock;
        this.country = country;
    }
    
    //~Public  Methods ........................................................
    
    /**
     * Retrieves the value representing the "rock" genre.
     * 
     * @return The value representing the "rock" genre.
     */
    
    public int getRock() {
        return rock;
    }
    
    /**
     * Retrieves the value representing the "pop" genre.
     * 
     * @return The value representing the "pop" genre.
     */
    
    public int getPop() {
        return pop;
    }
    
    /**
     * Returns a string representation of the genre set.
     * @return A string representation of the genre set
     */
    
    @Override
    public String toString() {
        return "Pop:" + pop + " Rock:" + rock + " Country:" + country;
    }
    
    /**
     * Checks if this genre set is equal to another object.
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
        GenreSet genreSet = (GenreSet) obj;
        return pop == genreSet.pop && rock == genreSet.rock && 
            country == genreSet.country;
    }
    
    /**
     * Checks if this genre set falls within a specified range defined by 
     * minimum and maximum genre sets.
     * @param minGenreSet The minimum genre set
     * @param maxGenreSet The maximum genre set
     * @return True if this genre set is within the specified range, false 
     *         otherwise
     */

    public boolean isWithinRange(GenreSet minGenreSet, GenreSet maxGenreSet) {
        return minGenreSet.isLessThanOrEqualTo(this) && 
            this.isLessThanOrEqualTo(maxGenreSet);
    }
    
    /**
     * Checks if this genre set is less than or equal to another genre set.
     * @param other The other genre set to compare with
     * @return True if this genre set is less than or equal to the other, false 
     *         otherwise
     */

    private boolean isLessThanOrEqualTo(GenreSet other) {
        return this.pop <= other.pop && this.rock <= other.rock && this.country 
            <= other.country;
    }
    
    /**
     * Compares this genre set with another genre set based on the sum of 
     * genre scores.
     * @param other The other genre set to compare with
     * @return A negative integer if this genre set is less than the other,
     *         zero if they are equal, and a positive integer if this genre set 
     *         is greater than the other
     */

    @Override
    public int compareTo(GenreSet other) {
        int sumThis = this.pop + this.rock + this.country;
        int sumOther = other.pop + other.rock + other.country;
        return Integer.compare(sumThis, sumOther);
    }
    
    /**
     * Retrieves the value representing the "country" genre.
     * 
     * @return The value representing the "country" genre.
     */
    
    public int getCountry() {
        return country;
    }
}