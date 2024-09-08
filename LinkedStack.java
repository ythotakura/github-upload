package towerofhanoi;

// Virginia Tech Honor Code Pledge:
// Project 3 Spring 2024
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who 
// do.
// -- Yashili Thotakura (yashili)

import java.util.EmptyStackException;
import stack.StackInterface;

/**
 * The LinkedStack class represents a stack implemented using linked nodes.
 * It implements the StackInterface.
 *
 * @param <T> the type of elements in the stack
 * 
 * @author Yashili Thotakura
 * @version 2024.03.19
 */

public class LinkedStack<T> implements StackInterface<T> {
    //~ Fields ................................................................
    
    private Node<T> topNode;
    private int size;
    
    //~ Constructors ..........................................................
    
    /**
     * Constructs an empty LinkedStack.
     */
    
    public LinkedStack() {
        topNode = null;
        size = 0;
    }
    
    //~Public  Methods ........................................................
    
    /**
     * Returns the number of elements in the stack.
     *
     * @return the number of elements in the stack
     */
    
    public int size() {
        return size;
    }
    
    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Removes all elements from the stack.
     */
    
    public void clear() 
    {
        topNode = null;
        size = 0;
    }

    /**
     * Returns a string representation of the stack.
     *
     * @return a string representation of the stack
     */
    
    @Override
    public String toString() {
        String result = "[";
        Node<T> current = topNode;
        while (null != current) {
            result += "" + current.data;
            current = current.next;
            if (null != current) {
                result += ", ";
            }
        }
        
        result += "]";
        return result;
    }

    /**
     * Pushes an element onto the top of the stack.
     *
     * @param anEntry the element to be pushed onto the stack
     */
    
    public void push(T anEntry) {
        Node<T> node = new Node<T>(anEntry);
        node.setNextNode(topNode);
        topNode = node;
        size++;
    }
    
    /**
     * Retrieves the element at the top of the stack without removing it.
     *
     * @return the element at the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    
    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        
        return topNode.getData();
    }

    /**
     * Removes and returns the element at the top of the stack.
     *
     * @return the element at the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    
    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        
        Node<T> temp = topNode;
        topNode = topNode.next;
        size--;
        return temp.getData();
    }

    /**
     * The Node class represents a node in the linked stack.
     *
     * @param <T> the type of data stored in the node
     */
    
    private static class Node<T> {
        //~ Fields .............................................................
        
        private Node<T> next;
        private T data;
        
        //~ Constructors .....................................................
        
        /**
         * Constructs a new Node with the specified data.
         *
         * @param d the data to be stored in the node
         */
        
        public Node(T d) {
            data = d;
        }

        //~Public  Methods ...................................................
        
        /**
         * Sets the next node.
         *
         * @param n the next node to be set
         */
        
        public void setNextNode(Node<T> n) {
            next = n;
        }
        
        /**
         * Returns the next node.
         *
         * @return the next node
         */

        public Node<T> getNextNode() {
            return next;
        }

        /**
         * Returns the data stored in the node.
         *
         * @return the data stored in the node
         */
        
        public T getData() {
            return data;
        }
    }
}