import java.util.LinkedList;
import java.util.Queue;

/******************************************************************************
 *  Team Name: NWENT
 *  Partners: Connor Hoffman, Nick Martinez, Will Gibb
 *	Date: 9/11/2021   
 *
 * Contains methods to be called in other files of the program to be executed
 *  
 ******************************************************************************/


public class ringBuffer {
	private Queue<Double>thing=new LinkedList<Double>();
	private int cp;
    // creates an empty ring buffer with the specified capacity
    public ringBuffer(int capacity) {
    	cp=capacity;
    }

    // return the capacity of this ring buffer
    public int capacity() {
        return cp;
    }

    // return number of items currently in this ring buffer
    public int size() {
    	return thing.size();
    }

    public boolean isEmpty() {
        return size()==0;
    }

    public boolean isFull() {
        return size()==capacity();
    }

    // adds item x to the end of this ring buffer
    public void enqueue(double x) {
    	if(!isFull()) {
    		thing.add(x);
    	}
    }

    // deletes and returns the item at the front of this ring buffer
    public double dequeue() {
        return thing.poll();
    }

    // returns the item at the front of this ring buffer
    public double peek() {
        return thing.peek();
    }

    // tests and calls every instance method in this class
    public void main(String[] args) {
    	System.out.println("Capacity: "+ capacity()+" Size: " +size()+" Empty: "+isEmpty()+" Full: "+isFull()+" Peek: "+peek());
    }
    public String toString() {
    	return thing.toString();
    }

}
