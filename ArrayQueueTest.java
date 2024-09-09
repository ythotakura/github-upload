// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who 
// do.
// -- Yashili Thotakura (yashili)

package dailymixes;

import queue.EmptyQueueException;

/**
 * This class contains test cases for the ArrayQueue class.
 * 
 * @author Yashili Thotakura (yashili)
 * @version 2024.04.02
 */

public class ArrayQueueTest extends student.TestCase {
    //~ Fields ................................................................
    
    private ArrayQueue<String> queue1;
    private ArrayQueue<String> queue2;
    private ArrayQueue<String> queue3;
    private ArrayQueue<String> queue4;
    
    //~ Constructors ..........................................................
    
    /**
     * Sets up the test fixtures.
     */
    
    public void setUp() {
        queue1 = new ArrayQueue<>();
        queue2 = new ArrayQueue<>();
        queue3 = new ArrayQueue<>();
        queue4 = new ArrayQueue<>(3);
        

        queue2.enqueue("Apple");
        queue2.enqueue("Banana");
        queue2.enqueue("Cherry");
        
        queue3.enqueue("Grape");
        queue3.enqueue("Orange");
        queue3.enqueue("Pear");
    }
    
    //~Public  Methods ........................................................
    
    /**
     * Tests the enqueue and dequeue methods of the ArrayQueue class.
     */
    
    public void testEnqueueAndDequeue() {
        queue1 = new ArrayQueue<>();
        assertTrue(queue1.isEmpty());

        queue1.enqueue("Apple");
        queue1.enqueue("Banana");
        queue1.enqueue("Cherry");
        assertEquals(3, queue1.getSize());

        queue1.dequeue();
        assertEquals(2, queue1.getSize());
        queue1.dequeue();
        assertEquals(1, queue1.getSize());
        queue1.dequeue();
        assertTrue(queue1.isEmpty());
    }


    /**
     * Tests the getFront method of the ArrayQueue class.
     */

    public void testGetFront() {
        Exception thrown = null;
        try {
            queue1.getFront();
        } 
        catch (Exception exception) {
            thrown = exception;
        }
        assertTrue(thrown instanceof EmptyQueueException);

        queue1.enqueue("Apple");
        assertEquals("Apple", queue1.getFront());

        queue1.enqueue("Banana");
        assertEquals("Apple", queue1.getFront());

        queue1.dequeue();
        assertEquals("Banana", queue1.getFront());
    }

    /**
     * Tests the clear method of the ArrayQueue class.
     */
    
    public void testClear() {
        assertFalse(queue2.isEmpty());

        queue2.clear();
        assertTrue(queue2.isEmpty());
    }

    /**
     * Tests the toArray method of the ArrayQueue class.
     */

    public void testToArray() {
        Object[] array = queue2.toArray();
        assertEquals(3, array.length);
        assertEquals("Apple", array[0]);
        assertEquals("Banana", array[1]);
        assertEquals("Cherry", array[2]);
    }

    /**
     * Tests the equals method of the ArrayQueue class.
     */

    public void testEquals() {
        queue1.enqueue("Apple");
        queue1.enqueue("Banana");
        queue1.enqueue("Cherry");

        assertTrue(queue1.equals(queue2));
        assertFalse(queue1.equals(queue3));
    }
    
    /**
     * Tests the ensureCapacity method of the ArrayQueue class.
     * Ensures the underlying array is resized correctly based on the number of 
     * elements in the queue.
     */
    
    public void testEnsureCapacity() {
        assertEquals(4, queue4.getLengthOfUnderlyingArray());

        queue4.enqueue("Apple");
        queue4.enqueue("Banana");
        queue4.enqueue("Cherry");
        assertEquals(3, queue4.getSize());
        assertEquals(4, queue4.getLengthOfUnderlyingArray());

        queue4.enqueue("Grape");

        assertEquals(8, queue4.getLengthOfUnderlyingArray());
        assertEquals(4, queue4.getSize());

        queue4.dequeue();
        assertEquals(3, queue4.getSize());
        queue4.dequeue();
        assertEquals(2, queue4.getSize());
        queue4.dequeue();
        assertEquals(1, queue4.getSize());
        queue4.dequeue();
        assertTrue(queue4.isEmpty());
    }
}
