import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * a Heap class that implemented by an dynamic Array. 
 * @author Mustafa Omran - 26745954 - Muherthan Thalayasingam - 27223064
 * each job will have a random number assigned to it as the name, length. </br> 
 * Each time we create a job. Its entry is set to the jobs created and the value of job incremented. 
 */
public class ArrayHeap {
	private Job [] jobs; 
	private int size; 

	/** 
	 * Constructor that initialize all attributes 
	 */
	public ArrayHeap (int n) {
		jobs = new Job[n]; 

		size=1; 
	}

	/**
	 * add an Job to the end of the list
	 * @param Job e 
	 * @return true if the element is added 
	 */
	public void enque(Job e) {
		if (jobs.length==size) {
			jobs = createNewjobs();
		}
		if (jobs[1] == null) {
			jobs[1] = e; 
			size++;
		}

		else {

			size++; 
			jobs[size-1]=e; 

			int index =size-1 ;

			while (index > 1 && jobs[index].compareTo(jobs[parent(index)] )< 0) {
				swap(index, parent(index));
				index = parent(index);
			}
		}

		//Parent(jobs[size-1], size-1);
	}

	/**
	 * checks if the object at index has a parent
	 * @param index
	 * @return Job object
	 */
	public boolean hasParent (int index) {
		return jobs[index/2] != null; 
	}

	public int parent (int index ) {
		return  index/2;
	}


	/*
	public Job Parent (Job e, int index) {
		if (index == 1) {
			return e; 
		}
		else {
			if (index%2==0) {
				if (jobs[index].compareTo(jobs[index/2]) > 0) {
					return e;

				}
				else {
					Job temp = jobs[index/2]; 
					jobs[index/2] = jobs[index];
					jobs[index]=  temp;
					return Parent(jobs[index/2], index/2);
				}
			}
			else {

				if (jobs[index].compareTo(jobs[(index-1)/2]) > 0) {
					return e; 
				}
				else {
					Job temp = jobs[(index-1)/2]; 
					jobs[(index-1)/2] = jobs[index];
					jobs[index]=  temp;
					return Parent(jobs[(index-1)/2], (index-1)/2);
				}
			}
		}
	}
	 */


	/**
	 * add an element based on index of the jobs. 
	 * @param int index 
	 * @param Job element
	 */
	public void add(int index, Job element) {

		if (index > jobs.length  ) { 
			throw new indexGreaterThan();
		}


		if (index == jobs.length ||  jobs[index] != null) {

			if (size() == jobs.length) {
				jobs =  createNewjobs();

				for (int i= size() ; i >= index; i--) {
					if (i == index) {
						jobs[i] = element; 
					}
					else {
						jobs[i] = jobs[i-1];
					}
				}

			}
			else {
				for (int i= size(); i >= index; i--) {
					if (i == index) {
						jobs[i] =  element; 
					}
					else {
						jobs[i] = jobs[i-1];
					}
				}

			}
		}
		else 
			jobs[index] =  element;



		size++; 


	}

	/**
	 * a helper method that doubles the size of the jobs when called 
	 * @return a new jobs with double the size 
	 */
	private Job[] createNewjobs() { 
		int t = size; 
		if (size==0) 
			t = 2; 

		Job[] jobstemp = new Job[t*2];
		for (int i=0; i< jobs.length; i++) 
			jobstemp[i] = (Job) jobs[i];

		return jobstemp; 
	}


	/**
	 * removed all the elements of the list and decrement the size
	 */
	public void clear() {
		for (int i=0; i < jobs.length ; i++ ) {
			jobs[i]= null; 
		}
		jobs = new Job[0]; 
		size = 0;
	}



	/*
	 * unsupported method
	 */
	public boolean isEmpty() {
		if (size==1) 
			return true;
		return false;
	}




	/**
	 * remove element based on index and return to the calling function
	 * @param int index 
	 * @return the element
	 */
	public Job deque() {

		if (isEmpty())
			throw new indexGreaterThan();

		else if (isEmpty()) 
			throw new empty(); 

		else {
			Job element = jobs[1];

			jobs[1]= jobs[size-1];


			jobs[size-1] = null; 
			size--; 

			
			hepify(1);
			
			/**
			while (!external(index)) {
				
				if (jobs[index].compareTo(jobs[index*2] ) > 0) {
					swap(index, index*2);
					index = 2*index; 
					continue;
				}
				if (hasrightchild(index)) {
					if (jobs[index].compareTo(jobs[index*2+1] ) > 0 ) {
						swap(index, index*2+1);
						index= index * 2 +1;
						continue;
					}
				}
				break;
			}

	*/

			if (size == 0||(jobs.length / size *100)<90) {
				Job[] temp = new Job[jobs.length/2]; 
				for (int i=0 ; i < temp.length ; i++) {
					temp[i] = jobs[i]; 
				}
				jobs = temp;
				return element; 
			}
			else {
				return element;
			}
		}

	}
	
	/**
	 * heapifys the heap tree to adjust it back to how it should be
	 * @param index
	 */
	public void hepify (int index ) {
		
		int left = leftChild(index);  
		int right = rightChild(index); 
		int smallest;   

		if (left <= size-1 && jobs[left].compareTo(jobs[index]) < 0)
			smallest = left;   
		else
			smallest = index;      

		if (right <= size-1 && jobs[right].compareTo(jobs[smallest]) < 0)
			smallest = right;  


		if (smallest != index) {
			swap(index, smallest);
			hepify(smallest);
		}
	}
	
	/**
	 * returns the left child
	 * @param i
	 * @return 2*i
	 */
	private static int leftChild(int i) {
		return 2*i ;
	}

	/**
	 * returns the right child
	 * @param i
	 * @return 2*i + 1
	 */
	private static int rightChild(int i) {
		return 2*i +1;
	}

	/**
	 * check if there is a right child
	 * @param index
	 * @return Object
	 */
	public boolean hasrightchild (int index) {
		return jobs[index*2+1] !=null; 
	}

	/**
	 * check if there is a left child
	 * @param index
	 * @return object
	 */
	public boolean external (int index) {
		return jobs[index*2] == null; 
	}

	/**
	 * swaps the value of two objects
	 * @param index
	 * @param index2
	 */
	public void swap (int index, int index2) {
		Job temp = jobs[index];
		jobs[index] = jobs[index2];
		jobs[index2]=  temp;
	}


	/*
	public Job child (Job e,int index) {
		if (jobs[index*2+1] == null ) {
			return e; 
		}
		else {

			if (jobs[index].compareTo(jobs[index*2])  >  0 || (jobs[index].compareTo(jobs[(index)*2+1])  > 0)) {
				System.out.println(jobs[index] + "= index  "+index +" " +" left child <" +jobs[index*2] +" Right >" + jobs[(index)*2+1] );
				if (jobs[index].compareTo(jobs[index*2]) > 0) {
					Job temp = jobs[index*2]; 
					jobs[index*2] = jobs[index];
					jobs[index]=  temp;
					return child(jobs[index*2], index*2); 
				}

				else {
					Job temp = jobs[(index)*2+1];

					jobs[(index)*2+1] = jobs[index];
					jobs[index]=  temp;
					return child(jobs[(index)*2+1], (index)*2+1);
				}
			}
			else {

				return e;

			}
		}
	}
	 */


	/**
	 * return the size of the list
	 * @return int size of the list
	 */
	public int size() {
		return size;
	}

	/**
	 * @return String of all the elemenet in the list
	 */
	public String toString () {
		String value = "[";
		for (int i=0; i<size-1; i++) {

			value += jobs[i];
			if (i+1 != size) {
				value += ", ";
			}
		}

		value +="]";

		return value;


	}
	
	/**
	 * calculates the max wait time
	 * @return object
	 */
	public Job getMaxWait () {

		Job temp = (Job) jobs[1];
		int index = -1;
		for (int i=size-1 ; i > 1 ; i--) {
			if (temp.getEntryTime() >  ((Job) jobs[i]).getEntryTime() && ((Job) jobs[i]).getJobLength() - ((Job) jobs[i]).getJobLengthRemaning() == 0){
				temp = (Job) jobs[i];
				index = i; 
				break; 
			}
		}
		if (index >= 0) {

			for (int i=0, k=0 ; i < size ; i++) {
				if (i == index) {
					jobs[i]= null; 
					k = 1; 
				}
				else if (k == 1) {
					jobs[i-1] = jobs[i];
				}
			}
			size--;

			return temp; 
		}
		else 	
			return null; 
	}





}

