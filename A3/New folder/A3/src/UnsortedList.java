/**
 * a unsorted list class that implemented using a unsorted linked list. 
 * @author Mustafa Omran - 26745954 - Muherthan Thalayasingam - 27223064
 * each job will have a random number assigned to it as the name, length. </br> 
 * Each time we create a job. Its entry is set to the jobs created and the value of job incremented. 
 */
public class UnsortedList <Key extends Comparable <Key>> {
	private Node first;
    private int counter;     
    
    /**
     * a class for the nodes
     * @author Mustafa Omran - 26745954 - Muherthan Thalayasingam - 27223064
     * the node class that allows us to build the linked list
     */
    private class Node {
    	Key key;                                          
    	Node next;   
    }

    /**
     * checks if the list is empty
     * @return boolean
     */
    public boolean isEmpty() {
    	return counter == 0;
    }
    
    /**
     * returns the size of the list
     * @return counter
     */
    public int size() {
    	return counter;
    }
    
    /**
     * inserts an object into the list
     * @param newKey
     */
    public void enqueue(Key newKey){
        Node temp = first;
        first = new Node();
        first.key = newKey;
        first.next = temp;
        counter++;
    }

    /**
     * deletes an object from the list
     * @return Object
     */
    public Key dequeue(){
    	if (first == null) 
    		return null;
    	else if (counter == 1) {
    		counter--;
    		return first.key;
    	}
    	    
    	
    	Node min = first;
    	Node minPrev = null;
    	Node current = min.next;
    	Node previous = first;
    	
    	while(current != null) {
    		Key currMin = min.key;
    	    Key nextKey = current.key;
    	    if(nextKey.compareTo(currMin) < 0) {
    	    	min = current;
    	        minPrev = previous;
    	    }
    	    previous = current;
    	    current = current.next;
    	}
    	
	    if(minPrev!=null)
	        minPrev.next = min.next;
	    else
	        first = min.next;
	    counter--;
	    return min.key;
    }
}
