package arraystack;

import java.util.EmptyStackException;
import student.TestCase;

/**
 * Test cases for the ArrayBasedStack class.
 * 
 * @author Yashili Thotakura (yashili)
 * @version 2024.02.22
 */

public class ArrayBasedStackTest extends TestCase {
    //~ Fields ................................................................
    private ArrayBasedStack<String> stack;
    private ArrayBasedStack<String> stack2;
    
    //~ Constructors ..........................................................
    /**
     * Sets up the test environment by creating two instances of ArrayBasedStack
     */
    public void setUp() {
        stack = new ArrayBasedStack<>();
        stack2 = new ArrayBasedStack<>();
    }

    //~Public  Methods ........................................................
    
    /**
     * Tests the isEmpty() method for the ArrayBasedStack class.
     */
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push("Element");
        assertFalse(stack.isEmpty());
    }
    
    /**
     * Tests the peek() method for the ArrayBasedStack class.
     */
    public void testPeek() {
        try {
            stack.peek();
            fail("Expected EmptyStackException, but no exception was thrown");
        } 
        catch (EmptyStackException e) {
            // Expected exception, do nothing
        }
        
        stack.push("Element1");
        stack.push("Element2");
        assertEquals("Element2", stack.peek());
    }
    
    /**
     * Tests the pop() method for the ArrayBasedStack class.
     */
    public void testPop() {
        try {
            stack.pop();
            fail("Expected EmptyStackException, but no exception was thrown");
        } 
        catch (EmptyStackException e) {
            // Expected exception, do nothing
        }
        
        stack.push("Element");
        int initialSize = stack.size();
        assertEquals("Element", stack.pop());
        assertEquals(initialSize - 1, stack.size());
    }
    
    /**
     * Tests the push() method for the ArrayBasedStack class.
     */
    public void testPush() {
        stack.push("Element1");
        assertEquals(1, stack.size());
        assertEquals("Element1", stack.peek());

        stack.push("Element2");
        assertEquals(2, stack.size());
        assertEquals("Element2", stack.peek());

        for (int i = 3; i < 101; i++) {
            stack.push("Element" + (i));
        }

        assertEquals("Element100", stack.peek());
        
        stack.push("Element101");
        assertEquals("Element101", stack.peek());
    }
    
    /**
     * Tests the contains() method for the ArrayBasedStack class.
     */
    public void testContains() {
        assertFalse(stack.contains("Element"));

        stack.push("Element1");
        stack.push("Element2");
        stack.push("Element3");

        assertTrue(stack.contains("Element1"));
        assertTrue(stack.contains("Element3"));
        assertFalse(stack.contains("NonExistentElement"));
        
        stack.pop();
        assertFalse(stack.contains("Element3")); 
        assertTrue(stack.contains("Element2")); 
    }
    
    /**
     * Tests the clear() method for the ArrayBasedStack class.
     */
    public void testClear() {
        stack.clear();
        assertTrue(stack.isEmpty());

        stack.push("Element1");
        stack.push("Element2");
        stack.push("Element3");

        assertFalse(stack.isEmpty());
        assertEquals(3, stack.size());

        stack.clear();

        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());

        stack.push("Element4");
        stack.push("Element5");

        assertFalse(stack.isEmpty());
        assertEquals(2, stack.size());

        stack.pop();
        stack.pop();

        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }
    
    /**
     * Tests the toString() method for the ArrayBasedStack class.
     */
    public void testToString() {
        assertEquals("[]", stack.toString());

        stack.push("Element1");
        assertEquals("[Element1]", stack.toString());

        stack.push("Element2");
        assertEquals("[Element1, Element2]", stack.toString());

        stack.push("Element3");
        assertEquals("[Element1, Element2, Element3]", stack.toString());

        stack.pop();
        assertEquals("[Element1, Element2]", stack.toString());

        stack.pop();
        assertEquals("[Element1]", stack.toString());

        stack.pop();
        assertEquals("[]", stack.toString());
    }
    
    /**
     * Tests the equals() method for the ArrayBasedStack class.
     */
    public void testEquals() {
        assertTrue(stack.equals(stack));

        assertFalse(stack.equals(null));
        assertFalse(stack.equals(new Object()));

        stack.push("Element1");
        stack.push("Element2");

        stack2.push("Element1");
        assertFalse(stack.equals(stack2));

        stack2.push("Element2");
        assertTrue(stack.equals(stack2));

        stack.push("Element3");
        assertFalse(stack.equals(stack2));
        
        stack.clear();
        stack2.clear();

        stack.push("Element1");
        stack.push("Element2");

        stack2.push("Element2");
        stack2.push("Element1");

        assertFalse(stack.equals(stack2));

        stack.clear();
        stack2.clear();

        stack.push("Element1");
        stack.push("Element2");

        stack2.push("Element1");
        stack2.push("Element2");

        assertTrue(stack.equals(stack2));
    }
    
    public void testDebuggerViews()
    {

        //Put a breakpoint on the line below
        
        ArrayBasedStack<String> testStack = new ArrayBasedStack<String>();
        
         
        
        //Put a breakpoint on the line below. Use Step Over to see each push.
        
        testStack.push("blizzard");
        
        testStack.push("barrage");
        
        testStack.push("deadeye");
        
        testStack.push("resurrect");
        
         
        
        assertTrue(testStack.toString().equals("[blizzard, barrage, deadeye, resurrect]"));
        
         
        
        //Put a breakpoint on the line below. Hit Step Over once to watch the pop.
        
        testStack.pop();
        
         
        
        assertTrue(testStack.toString().equals("[blizzard, barrage, deadeye]"));
        
         
        
        Object[] toArrayResult = testStack.toArray();
        
        //Drop a breakpoint on the line below.
        
        //Use the debugger mode to compare toArrayResult to testStack.
        
        assertTrue(toArrayResult[0].toString().equals("blizzard"));
        
        assertEquals(toArrayResult.length, 3);
        
         
        
        //The following test fails because the stack still has entries in it. However,
        
        //"expected <true> but was: <false>" is not very helpful.
        
        //Drop a breakpoint on the line below to see what the toString SHOULD look like.
        
        assertTrue(testStack.toString().equals("[]"));

    }
}