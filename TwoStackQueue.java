
package week12;

import java.util.ListIterator;
import java.util.Stack;

/**
 * A first-in-first-out collection of items.
 *
 * @author Mike Cui
 */

public class TwoStackQueue<T> implements Queue<T> {
    /**This is the left stack declaration.
     *
     */
    Stack<T> leftStack;
    /** This is the right stack declaration.
     * 
     */
    Stack<T> rightStack;

    /** This is the constructor method.
     * It is used to initialise the stacks.
     */
    public TwoStackQueue() {
        leftStack = new Stack<T>();
        rightStack = new Stack<T>();
    }//end constructor


    /**
     * Return true if and only if this Queue is empty.
     *
     * @return true if this Queue is empty, otherwise false.
     */
    public boolean isEmpty() {
        return leftStack.isEmpty() && rightStack.isEmpty();

    }//emd isEmpty

    /**
     * Return the length of this Queue.
     *
     * @return the number of items in this Queue.
     */
    public int size() {

        return leftStack.size() + rightStack.size();
    }//emd size

    /**
     * Return the item at the front of this Queue.
     *
     * @return the item at the front of this Queue.
     * @throws EmptyQueueException if this Queue is empty.
     */
    public T get() {
        if (rightStack.empty() && !leftStack.empty()) {
            while (!leftStack.empty()) {
                rightStack.push(leftStack.pop());
            }
        }
        return rightStack.peek();

    }//end get

    /**
     * Make this Queue empty.
     * dwe
     */
    public void clear() {
        leftStack.clear();
        rightStack.clear();

    }//end clear

    /**
     * Add an item to the rear of this Queue.
     *
     * @param item the item to be added to the rear of the Queue.
     */
    public void add(T item) {

        leftStack.add(item);

    }//end add

    /**
     * Remove and return the front item of this Queue.
     *
     * @return the item at the front of this Queue.
     * @throws EmptyQueueException if this Queue is empty.
     * Theoretically if i can code it shouldn't throw emptyqueue
     * as if it will it shouldn't even run.
     * This is controlled by the app class
     */
    public T remove() throws EmptyQueueException {
        int counter = 0;
        if (rightStack.empty() && !leftStack.empty()) {
            while (!leftStack.empty()) {
                rightStack.push(leftStack.pop());
            }
//            System.out.println("It said right was empty
//            and left wasn't empty");

        } //end if
        return rightStack.pop(); // is this all good?

    }//end remove

    /**
     * Return a string representation of this queue ordered from front to back.
     *
     * @return a string representation of this Queue.
     */
    public String toString() {
        ListIterator<T> rightList = rightStack.listIterator(rightStack.size());
        ListIterator<T> leftList = leftStack.listIterator(0);
        StringBuilder stringXD = new StringBuilder();
        int i = 0;

//System.out.print("Hi");
        while (rightList.hasPrevious()) {
            if (i != 0) {
                stringXD.append(", ");

            }
            stringXD.append(rightList.previous());
            i++;

//           int i=0;
//            System.out.print ("i= "+i++);
        }//end while for rightlist

        while (leftList.hasNext()) {
            if (i != 0) {
                stringXD.append(", ");

            }
            stringXD.append(leftList.next());
            i++;
//            int j=0;
//            System.out.print ("j= "+j++);
        }//end while for leftlist
//System.out.println(stringXD);
        String actualString = stringXD.toString();
        actualString = "[" + actualString + "]";
        return actualString;
    }//end toString

    /** This is purely for debugging reasons.
     * Technically only the programmer should use this
     * @return the To string of the two stacks
     * but will be from 0->end for both stacks and
     * will start with the leftstack
     */
    public String debug() {

        return leftStack.toString() + rightStack.toString();

    }//end method debug

}//end class
