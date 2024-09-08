package towerofhanoi;

// Virginia Tech Honor Code Pledge:
// Project 3 Spring 2024
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who 
// do.
// -- Yashili Thotakura (yashili)

/**
 * The Position enum represents the possible positions of the towers in the 
 * Tower of Hanoi puzzle.
 * It includes the positions LEFT, MIDDLE, RIGHT, and DEFAULT.
 * @author Yashili Thotakura
 * @version 2024.03.19
 */

public enum Position {
    /** Left position. */
    LEFT, 
    
    /** Middle position. */
    MIDDLE, 
    
    /** Right position. */
    RIGHT, 
    
    /** Default position. Used for testing purposes. */
    DEFAULT;
}