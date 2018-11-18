import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Implementation of linked list class through list interface
 * @author Mustafa Omran - 26745954 - Muherthan Thalayasingam - 27223064
 *The class will have generic type that holds head and tail, and have doubly linked list spefication
 * @param <E>
 */
public class MyLinkedList <E> implements List <E>{
	private Node head; 
	private Node tail;
	private int size;

	/** 
	 * Constructor that initialize all attributes 
	 */
	public MyLinkedList () {
		size=0; 
		head = null; 
		tail = null;

	}
	/**
	 * private class node that hold the elemnts and pointer to the previous and next nodes. 
	 */
	private class Node <E> {
		Node before; 
		Node after;
		E element; 

		/**
		 *  constructor that initialize the variables 
		 */
		Node () { 
			before = null;
			after = null;
			element= null; 
		}
		
		/**
		 * constructor that take parameter and initialize the attributes accordingly 
		 * @param after the node after 
		 * @param before the node before 
		 * @param element the element
		 */

		Node(Node after, Node before, E element) {
			this.before = before; 
			this.after = after;
			this.element = element; 

		}
		
		/**
		 * set the element 
		 * @param e generic element
		 */

		void setElement(E e) {
			element = (E) e; 
		}

		/**
		 * return the element 
		 * @return element
		 */
		E getElement () {
			return element; 
		}
		
		/**
		 * set the next node
		 * @param next 
		 */

		void setNext(Node next) { 
			after = next;
		}
		
		/**
		 * set the previous node 
		 * @param prev takes a node 
		 */

		void setPrevious (Node prev) {
			before = prev; 
		}
		
		/** 
		 * returns the next node. 
		 * @return next node 
		 */

		Node getNext() { 
			return after;
		}

		/**
		 * return the previous node
		 * @return
		 */
		Node getPrevious () {
			return before;
		}



		/**
		 * equals method that compares if 2 elements. 
		 * @param obj takes object of node 
		 * @return true/false 
		 */
		public boolean equals(Node obj) {
			return obj.element.equals(this.element);
		}
		
		/**
		 * a to string method for the class 
		 */
		public String toString() {
			return element.toString(); 
		}


	}


	
	@Override
	/**
	 * add an object to the end of the list
	 * @param object e 
	 * @return true if the element is added 
	 */
	public boolean add(Object e) {
		Node temp = new Node(null,null, (E) e);  
		if (head == null) {
			head=tail=temp;
		}
		else if (head==tail) {
			head.setNext(temp);
			temp.setPrevious(head);
			temp.setNext(null);
			tail = temp; 

		}
		else {
			temp.setPrevious(tail);
			tail.setNext(temp);
			tail= temp; 
		}

		size++; 

		return true;
	}
	
	/**
	 * add an element based on index 
	 * @param int index 
	 * @param Object element
	 */

	@Override
	public void add(int index, Object element) {

		if (index > size+1 ) {
			throw new indexGreaterThan(); 
		}

		Node postion = head; 

		if (isEmpty()) {
			Node temp = new Node(head,tail, (E) element); 
			head=tail= temp; 
			size++;
			return; 
		}

		if (index == 0 ) {
			
			Node temp = new Node(head,null, (E) element); 
			head.setPrevious(temp);
			head= temp;
			size++;
			return;
		}

		
		
		if (index == size) {
			Node temp = new Node(null, tail, (E) element); 
			tail.setNext(temp);

			tail= temp;
			size++;
			return; 

		}
		
		int i =0;
		
		while(i < index ) {
			postion = postion.getNext();
			i++;
		}

		Node temp = new Node(postion, postion.getPrevious(), (E) element);
		postion.before.setNext(temp);
		postion.setPrevious(temp);

		size++; 




	}

	@Override
	/*
	 * unsupported method
	 */
	public boolean addAll(Collection c) {
		throw new UnsupportedOperationException(); 
	}

	@Override
	/*
	 * unsupported method
	 */
	public boolean addAll(int index, Collection c) {
		throw new UnsupportedOperationException(); 
	}

	@Override
	/**
	 * removed all the elements of the list and the nodes
	 */
	public void clear() {
		Node postion = head;


		while (postion.getNext() != null) {
			postion = postion.getNext(); 
			postion.before.setPrevious(null);
			postion.before.setNext(null);
			postion.before = null;
			size--; 
		}

		head=tail=null;


	}

	@Override
	/*
	 * unsupported method
	 */
	public boolean contains(Object o) {
		throw new UnsupportedOperationException(); 
	}

	@Override
	/*
	 * unsupported method
	 */
	public boolean containsAll(Collection c) {
		throw new UnsupportedOperationException(); 
	}

	@Override
	/*
	 * unsupported method
	 */
	public E get(int index) {
		throw new UnsupportedOperationException(); 
	}

	@Override
	/*
	 * unsupported method
	 */
	public int indexOf(Object o) {
		throw new UnsupportedOperationException(); 
	}

	@Override
	/**
	 * returns boolean if the list is empty 
	 * @return true if head is null
	 */
	public boolean isEmpty() {
		if (head== null) {
			return true; 
		}
		return false;
	}

	@Override
	/*
	 * unsupported method
	 */
	public Iterator iterator() {
		throw new UnsupportedOperationException(); 
	}

	@Override
	/*
	 * unsupported method
	 */
	public int lastIndexOf(Object o) {
		throw new UnsupportedOperationException(); 
	}

	@Override
	/*
	 * unsupported method
	 */
	public ListIterator listIterator() {
		throw new UnsupportedOperationException(); 
	}

	@Override
	/*
	 * unsupported method
	 */
	public ListIterator<E> listIterator(int index) {
		throw new UnsupportedOperationException(); 
	}

	@Override
	/**
	 * removed an object from the list and return true if object is removed
	 * @param Object o 
	 * @return true if object is removed 
	 * 
	 */
	public boolean remove(Object o) {
		Node temp= null; 
		if (o.getClass() != head.getClass()) {
		 temp = new Node(null, null, o); 
		}
		
		else {
			temp = (Node) o; 
		}
		
		boolean removed = false; 
		if (isEmpty()) {
			throw new empty(); 
		}
		else {
			
			if (temp.equals(head)) {
				Node postion= head.getNext(); 
				head.setNext(null);
				postion.setPrevious(null);
				head = postion; 
				size--; 
				return true; 
				
			}
			
			if (temp.equals(tail)) {
				Node postion = tail.getPrevious(); 
				tail.setPrevious(null);
				postion.setNext(null);
				size--; 
				tail = postion; 
				return true;
			}
			Node postion = head; 

			while (postion!=null) {
				if (postion.equals(temp)) {
					postion.before.setNext(postion.getNext());
					postion.after.setPrevious(postion.getPrevious());
					removed= true; 
					size--; 
					break;
				}
				postion = postion.getNext();
			}
		}
		return removed; 
	}

	@Override
	/**
	 * remove element based on index and return to the calling function
	 * @param int index 
	 * @return the element
	 */
	public E remove(int index) {
		Node removed = null; 
		if (isEmpty()) {
			throw new empty(); 
		}

		if (index>size-1) {
			throw new indexGreaterThan(); 
		}
		else {
			if (index==0) {
				removed = head;
				head = head.getNext();
				head.getPrevious().setNext(null);
				head.setPrevious(null);
				size--; 
				return (E)removed;
			}

			if (index == size-1) {
				removed = tail; 
				tail = tail.getPrevious(); 
				tail.getNext().setNext(null);
				size--; 
				return (E)removed;
			}
			Node postion = head; 
			int i =0; 
			while (i < size) {

				if (i == index) {
					removed = postion; 
					postion.before.setNext(postion.getNext());
					postion.after.setPrevious(postion.getPrevious());
					size--; 
					return (E) removed;
				}
				postion = postion.getNext();
				i++;
			}
		}
		return (E) removed; 
	}

	@Override
	/*
	 * unsupported method
	 */
	public boolean removeAll(Collection c) {
		throw new UnsupportedOperationException(); 
	}

	@Override
	/*
	 * unsupported method
	 */
	public boolean retainAll(Collection c) {
		throw new UnsupportedOperationException(); 
	}

	@Override
	/*
	 * unsupported method
	 */
	public Object set(int index, Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	/**
	 * return the size of the list
	 * @return int size of the list
	 */
	public int size() {
		return size; 
	}

	@Override
	/*
	 * unsupported method
	 */
	public List subList(int fromIndex, int toIndex) {
		throw new UnsupportedOperationException(); 
	}

	@Override
	/*
	 * unsupported method
	 */
	public Object[] toArray() {
		throw new UnsupportedOperationException(); 
	}

	@Override
	/*
	 * unsupported method
	 */
	public Object[] toArray(Object[] a) {
		throw new UnsupportedOperationException(); 
	}

	/**
	 * @return String of all the elemenet in the list
	 */
	
	public String toString() {
		Node postion = head;
		String myString="[";
		while (postion !=null) {
			
			myString += postion.toString();

			postion = postion.getNext();
			
			if (postion != null) {
				myString += ", ";
			}
		}
		myString +="]";
		return myString;
	}


}
