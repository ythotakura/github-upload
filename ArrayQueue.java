// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who 
// do.
// -- Yashili Thotakura (yashili)

package dailymixes;

import queue.EmptyQueueException;
import queue.QueueInterface;

/**
 * An implementation of the QueueInterface using an array.
 * @param <T> The type of elements stored in the queue.
 * 
 * @author Yashili Thotakura (yashili)
 * @version 2024.04.02
 */

public class ArrayQueue<T> implements QueueInterface<T> {
    //~ Fields ................................................................
    
    /**
     * The default capacity of the ArrayQueue if no initial capacity is 
     * specified.
     */
    
    public static final int DEFAULT_CAPACITY = 20;
    private T[] queue;
    private int dequeueIndex;
    private int size;
    private int enqueueIndex;
    
    //~ Constructors ..........................................................

    /**
     * Constructs an ArrayQueue with the specified initial capacity.
     * @param capacity The initial capacity of the queue
     */
    
    public ArrayQueue(int capacity) {
        @SuppressWarnings("unchecked")
        T[] tempQueue = (T[]) new Object[capacity + 1];
        queue = tempQueue;
        dequeueIndex = 0;
        enqueueIndex = 0;
        size = 0;
    }

    /**
     * Constructs an ArrayQueue with the default capacity.
     */
    
    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }
    
    //~Public  Methods ........................................................
    
    @Override
    public void clear() {
        for (int i = 0; i < queue.length; i++) {
            queue[i] = null;
        }
        dequeueIndex = 0;
        enqueueIndex = 0;
        size = 0;
    }

    /**
     * Increments the given index by one, taking into account the circular
     * nature of the underlying array.
     * @param index The index to be incremented.
     * @return The incremented index.
     */
    
    private int incrementIndex(int index) {
        return (index + 1) % queue.length;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        
        if (!isEmpty()) {
            result.append(queue[dequeueIndex]);
            int current = incrementIndex(dequeueIndex);
            while (current != enqueueIndex) {
                result.append(", ").append(queue[current]);
                current = incrementIndex(current);
            }
        }
        
        result.append("]");
        return result.toString();
    }
    
    /**
     * Compares this ArrayQueue with the specified object for equality.
     * Two ArrayQueues are equal if they contain the same elements in the same 
     * order.
     * @param obj The object to compare with.
     * @return true if the specified object is equal to this ArrayQueue, false 
     * otherwise.
     */
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (!(obj instanceof ArrayQueue)) {
            return false;
        }
        
        ArrayQueue<?> other = (ArrayQueue<?>) obj;
        if (getSize() != other.getSize()) {
            return false;
        }
        
        int current = dequeueIndex;
        int otherCurrent = other.dequeueIndex;
        for (int i = 0; i < getSize(); i++) {
            if (!queue[current].equals(other.queue[otherCurrent])) {
                return false;
            }
            current = incrementIndex(current);
            otherCurrent = other.incrementIndex(otherCurrent);
        }
        
        return true;
    }
    
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException("Cannot dequeue from an empty queue");
        }
        T front = queue[dequeueIndex];
        queue[dequeueIndex] = null; 
        dequeueIndex = (dequeueIndex + 1) % queue.length; 
        size--;
        return front;
    }
    
    /**
     * Ensures that the queue has enough capacity to enqueue an element.
     * If the queue is full, it doubles its capacity.
     */
    
    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (isFull()) {
            T[] temp = (T[])new Object[this.getLengthOfUnderlyingArray() * 2];
            for (int i = 0; i < size; i++) {
                temp[i] = queue[(dequeueIndex + i) % queue.length];
            }
            dequeueIndex = 0;
            enqueueIndex = size;
            queue = temp;
        }
    }
    
    /**
     * Adds the specified element to the end of the queue.
     * @param element The element to be added to the queue.
     */
    
    public void enqueue(T element) {
        ensureCapacity();
        queue[enqueueIndex] = element;
        enqueueIndex = (enqueueIndex + 1) % queue.length;
        size++;
    }
    
    /**
     * Returns the length of the underlying array.
     * @return The length of the underlying array.
     */
    
    public int getLengthOfUnderlyingArray() {
        return queue.length;
    }
    
    /**
     * Retrieves the element at the front of the queue without removing it.
     * @return The element at the front of the queue.
     * @throws EmptyQueueException if the queue is empty.
     */
    
    public T getFront() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        return queue[dequeueIndex];
    }
    
    /**
     * Returns the number of elements currently in the queue.
     * @return The number of elements in the queue.
     */
    
    public int getSize() {
        return size;
    }
    
    /**
     * Checks if the queue is full.
     * @return true if the queue is full, false otherwise.
     */
    
    private boolean isFull() {
        return (enqueueIndex + 1) % queue.length == dequeueIndex;
    }
    
    /**
     * Converts the queue to an array.
     * @return An array containing all the elements in the queue.
     * @throws EmptyQueueException if the queue is empty.
     */
    
    public Object[] toArray() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        Object[] array = new Object[size];
        int index = 0;
        for (int i = dequeueIndex; i != enqueueIndex; i = (i + 1) % 
            queue.length) {
            array[index++] = queue[i];
        }
        return array;
    }
}