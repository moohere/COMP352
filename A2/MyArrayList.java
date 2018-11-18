import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * A dynamic array list implementation using List interface 
 * @author Mustafa Omran - 26745954 - Muherthan Thalayasingam - 27223064
 * The class can hold any elements and dynamically a just the size based on its need. 
 * @param <E>
 */
public class MyArrayList<E> implements List<E>{
	private Object[] array; 
	private int size; 

	/** 
	 * Constructor that initialize all attributes 
	 */
	public MyArrayList () {
		array = new Object[0];
		size=0; 
	}

	/**
	 * add an object to the end of the list
	 * @param object e 
	 * @return true if the element is added 
	 */
	
	public boolean add(E e) {
		if (array.length==size) {
			array = (Object[]) createNewArray(); 
		}
		size++; 
		array[size-1]=e; 
		return true;
	}

	@Override
	/**
	 * add an element based on index of the array. 
	 * @param int index 
	 * @param Object element
	 */
	public void add(int index, Object element) {
		
		if (index > array.length  ) { 
			throw new indexGreaterThan();
		}
		
		
		if (index == array.length ||  array[index] != null) {
			
			if (size() == array.length) {
				array = (Object[]) createNewArray();

				for (int i= size() ; i >= index; i--) {
					if (i == index) {
						array[i] = element; 
					}
					else {
						array[i] = array[i-1];
					}
				}

			}
			else {
				for (int i= size(); i >= index; i--) {
					if (i == index) {
						array[i] =  element; 
					}
					else {
						array[i] = array[i-1];
					}
				}

			}
		}
		else 
			array[index] =  element;
		
		
		
		size++; 
		

	}

	/**
	 * a helper method that doubles the size of the array when called 
	 * @return a new array with double the size 
	 */
	private Object createNewArray() { 
		int t = size; 
		if (size==0) 
			t = 1; 

		Object[] arraytemp = new Object[t*2];
		for (int i=0; i< array.length; i++) 
			arraytemp[i] = (Object) array[i];

		return arraytemp; 
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
	 * removed all the elements of the list and decrement the size
	 */
	public void clear() {
		for (int i=0; i < array.length ; i++ ) {
			array[i]= null; 
		}
		array = new Object[0]; 
		size = 0;
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
	/*
	 * unsupported method
	 */
	public boolean isEmpty() {
		if (size==0) 
			return true;
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
	public ListIterator listIterator(int index) {
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
		if (isEmpty()) {
			throw new empty(); 
		}
		
		boolean removed= false; 
		
		
		for (int i = 0; i < array.length ; i++) {		

			
			if (array[i]!= null && equalsArray(array[i], o)) {
				
				removed = true;
				array[i] = null; 
				size--;
				
					for (int w = i ; w < size ; w++) {
						
						array[w] = array[w + 1];
					}
				
			}

		}
		

		if (size ==0 || (array.length / size *100)<25) {
			Object[] temp = new Object[array.length/2]; 
			for (int i=0 ; i < temp.length ; i++) {
				temp[i] = array[i]; 
			}
			array = temp;
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
		
		if (index > array.length)
			throw new indexGreaterThan();
		else if (isEmpty()) 
			throw new empty(); 
		else {
			E element = null; 
			for(int i =0, k=0; i < array.length ; i++) {
				if (i==index) {
					element = (E) array[i]; 
					k=1; 
					size--;
				}
				else if (k==1) {
					array[i-1] = array[i]; 
				}
			}
			array[size]=null;

			if (size ==0 ||(array.length / size *100)<25) {
				Object[] temp = new Object[array.length/2]; 
				for (int i=0 ; i < temp.length ; i++) {
					temp[i] = array[i]; 
				}
				array = temp;
				return element; 
			}
		}




		return null;
	}

	@Override
	/*
	 * unsupported method
	 */
	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
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
		throw new UnsupportedOperationException(); 
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

	public String toString () {
		String value = "[";
		for (int i=0; i<size; i++) {
			
			value += array[i].toString();
			if (i+1 != size) {
				value += ", ";
			}
		}
		
		value +="]";

		return value;


	}

	

	public boolean equalsArray(Object obj, Object e) {
		if (! (obj.getClass() == e.getClass())) {
			int e1 =  Integer.valueOf((String) e) ;
			int o1 = (int) obj ;
			return (o1) ==  e1;
		}
		
		return false;
		
		
	}
	
	

}
