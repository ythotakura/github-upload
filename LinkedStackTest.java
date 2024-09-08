package towerofhanoi;

// Virginia Tech Honor Code Pledge:
// Project 3 Spring 2024
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who 
// do.
// -- Yashili Thotakura (yashili)

import java.util.EmptyStackException;

/**
 * The LinkedStackTest class is a test suite for the LinkedStack class.
 * It contains test cases to verify the functionality of methods
 * implemented in the LinkedStack class.
 * 
 * @author Yashili Thotakura
 * @version 2024.03.19
 * @param <T> 
 */

public class LinkedStackTest<T> extends student.TestCase {
    //~ Fields ................................................................

    private LinkedStack<String> stack;
    
    //~ Constructors ..........................................................
    
    /**
     * Sets up the test environment by initializing an empty LinkedStack.
     */
    
    public void setUp() {
        stack = new LinkedStack<>();
    }
    
    //~Public  Methods ........................................................

    /**
     * Test method for the size() method of the LinkedStack class.
     * Verifies that the size of the stack is updated correctly.
     */
    
    public void testSize() {
        stack.push("element");
        assertEquals(1, stack.size());
    }
    
    /**
     * Test method for the clear() method of the LinkedStack class.
     * Verifies that the stack is cleared and its size is updated correctly.
     */
    
    public void testClear() {
        stack.push("element1");
        stack.push("element2");
        stack.push("element3");
        assertEquals(3, stack.size());
        stack.clear();
        assertEquals(0, stack.size());
    }
    
    /**
     * Test method for the isEmpty() method of the LinkedStack class.
     * Verifies that the isEmpty method correctly identifies if the stack is 
     * empty.
     */
    
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push("element");
        assertFalse(stack.isEmpty());
    }
    
    /**
     * Test method for the peek() method of the LinkedStack class.
     * Verifies that the peek method returns the top element of the stack
     * without removing it, and handles the case of an empty stack.
     */
    
    public void testPeek() {
        Exception thrown = null;
        try {
            stack.peek();
        } 
        catch (Exception exception) {
            thrown = exception;
        }
        assertTrue(thrown instanceof EmptyStackException);

        stack.push("element1");
        assertEquals("element1", stack.peek());
    }
    
    /**
     * Test method for the pop() method of the LinkedStack class.
     * Verifies that the pop method removes and returns the top element of the 
     * stack, and handles the case of an empty stack.
     */
    
    public void testPop() {
        Exception thrown = null;
        try {
            stack.pop();
        } 
        catch (Exception exception) {
            thrown = exception;
        }
        assertTrue(thrown instanceof EmptyStackException);

        stack.push("element1");
        stack.push("element2");
        stack.pop();
        assertEquals(1, stack.size());
    }
    
    /**
     * Test method for the push() method of the LinkedStack class.
     * Verifies that the push method adds an element to the top of the stack
     * and updates the size of the stack.
     */
    
    public void testPush() {
        stack.push("element");
        assertEquals(1, stack.size());
    }
    
    /**
     * Test method for the toString() method of the LinkedStack class.
     * Verifies that the toString method returns a string representation of the
     *  stack.
     */
    
    public void testToString() {
        stack.push("element");
        assertEquals("[element]", stack.toString());
    }
}
