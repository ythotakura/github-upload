package towerofhanoi;

// Virginia Tech Honor Code Pledge:
// Project 3 Spring 2024
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who 
// do.
// -- Yashili Thotakura (yashili)

import cs2.Shape;
import student.TestableRandom;
import java.awt.Color;

/**
 * The Disk class represents a disk in the Towers of Hanoi puzzle.
 * Disks are visualized as rectangular shapes with varying widths.
 * Each disk is colored randomly upon instantiation.
 * 
 * @author Yashili Thotakura
 * @version 2024.03.19
 */

public class Disk extends Shape implements Comparable<Disk> {
    //~ Constructors ..........................................................
    
    /**
     * Constructs a new Disk with the specified width.
     * The background color of the disk is set randomly.
     *
     * @param width the width of the disk
     */
    
    public Disk(int width) {
        super(0, 0, width, 6);
        TestableRandom randomGenerator = new TestableRandom();
        int int1 = randomGenerator.nextInt(256);
        int int2 = randomGenerator.nextInt(256);
        int int3 = randomGenerator.nextInt(256);
        Color color = new Color(int1, int2, int3);
        this.setBackgroundColor(color);
    }

    //~Public  Methods ........................................................
    
    /**
     * Compares this disk with the specified disk for order.
     * Returns a negative integer, zero, or a positive integer as this disk is
     * narrower, equal to, or wider than the specified disk.
     *
     * @param otherDisk the disk to be compared
     * @return a negative integer, zero, or a positive integer as this disk is
     * narrower, equal to, or wider than the specified disk
     * @throws IllegalArgumentException if the specified disk is null
     */
    
    @Override
    public int compareTo(Disk otherDisk) {
        if (otherDisk == null) {
            throw new IllegalArgumentException();
        }
        
        return this.getWidth() - otherDisk.getWidth();
    }

    /**
     * Returns a string representation of the width of this disk.
     *
     * @return a string representation of the width of this disk
     */
    
    public String toString() {
        return Integer.toString(this.getWidth());
    }
 
    /**
     * Indicates whether some other object is "equal to" this one.
     * 
     * <p>This method compares the width of this disk with the width of the
     * specified object. If the specified object is also a Disk and has the 
     * same width, this method returns true; otherwise, it returns false.</p>
     *
     * @param obj the reference object with which to compare
     * @return true if this disk is equal to the specified object, 
     * false otherwise
     */
    
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        
        if (obj == null) {
            return false;
        }
        
        if (obj.getClass().equals(this.getClass())) {
            if (this.getWidth() == ((Disk)obj).getWidth()) {
                return true;
            }
        }
        
        return false;
    }
}