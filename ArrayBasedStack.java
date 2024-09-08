package arraystack;

import java.util.EmptyStackException;

/**
 * Implementation of a stack using an array-based approach.
 * 
 * @param <T> the type of elements stored in the stack.
 * @author Yashili Thotakura (yashili)
 * @version 2024.02.22
 */

@SuppressWarnings("unchecked")
public class ArrayBasedStack<T> implements StackADT<T>
{
    //~ Fields ................................................................
    private T[] stackArray;
    private int size;
    private int capacity;
    
    //~ Constructors ..........................................................
    
    /**
     * Constructs an empty stack with the specified initial capacity.
     * 
     * @param initialCapacity the initial capacity of the stack.
     */
    public ArrayBasedStack(int initialCapacity) {
        this.stackArray = (T[]) new Object[initialCapacity];
        this.size = 0;
        this.capacity = initialCapacity;
    }
    
    /**
     * Constructs an empty stack with a default capacity of 100.
     */
    public ArrayBasedStack() {
        this(100); // Default capacity of 100
    }
    
    //~Public  Methods ........................................................
    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    @Override
    public T peek()
    {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        
        return stackArray[size - 1];
    }

    @Override
    public T pop()
    {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        
        T poppedItem = stackArray[--size];
        stackArray[size] = null;
        return poppedItem;
    }

    @Override
    public void push(T item)
    {
        if (size == capacity) {
            expandCapacity();
        }
        
        stackArray[size++] = item;
    }

    @Override
    public boolean contains(T item)
    {
        for (int i = 0; i < size; i++) {
            if (stackArray[i].equals(item)) {
                return true;
            }
        }
        
        return false;
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public void clear()
    {
        for (int i = 0; i < size; i++) {
            stackArray[i] = null;
        }
        size = 0;
    }

    @Override
    public Object[] toArray()
    {
        @SuppressWarnings("unchecked")
        T[] copy =   (T[]) new Object[this.size()];
        for (int i = 0; i < this.size(); i++) {
            copy[i] = this.stackArray[i];
        }
        
        return copy;
    }
    
    /**
     * Expands the capacity of the stack by doubling its current capacity.
    */
    private void expandCapacity() {

        @SuppressWarnings("unchecked")
        T[] newArray = (T[]) new Object[this.capacity * 2];

        for (int i = 0; i < this.capacity; i++) {
            newArray[i] = this.stackArray[i];
        }

        this.stackArray = newArray;
        this.capacity *= 2;
    }
    
    /**
     * Returns the string representation of the stack.
     * 
     * [] (if the stack is empty)
     * [bottom, item, ..., item, top] (if the stack contains items)
     * 
     * @return the string representation of the stack.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('[');

        boolean firstItem = true;
        for (int i = 0; i < this.size(); i++) {
            if (!firstItem) {
                builder.append(", ");
            }
            
            else {
                firstItem = false;
            }

            // String.valueOf will print null or the toString of the item
            builder.append(String.valueOf(this.stackArray[i]));
        }
        
        builder.append(']');
        return builder.toString();
    }
    
    /**
     * Two stacks are equal iff they both have the same size and contain the
     * same elements in the same order.
     *
     * @param other
     *            the other object to compare to this
     *
     * @return {@code true}, if the stacks are equal; {@code false} otherwise.
     */
    @Override
     public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        
        if (other == null) {
            return false;
        }
        
        if (this.getClass().equals(other.getClass())) {
            ArrayBasedStack<?> otherStack = (ArrayBasedStack<?>) other;
            if (this.size() != otherStack.size()) {
                return false;
            }
            Object[] otherArray = otherStack.toArray();
            for (int i = 0; i < this.size(); i++) {
                if (!(this.stackArray[i].equals(otherArray[i])))
                {
                    return false;
                }
            }
            
            return true;
        }
        
        return false;
    }
}