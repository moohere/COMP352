import java.util.Arrays;

import javax.management.RuntimeErrorException;

/**
 * a sorted list class that implemented using a sorted linked list. 
 * @author Mustafa Omran - 26745954 - Muherthan Thalayasingam - 27223064
 * each job will have a random number assigned to it as the name, length. </br> 
 * Each time we create a job. Its entry is set to the jobs created and the value of job incremented. 
 */
public class SortedList {
	Object [] jobs;
	int size; 
	
	/** 
	 * Constructor that initialize all attributes 
	 */
	public SortedList (int size) { 
		jobs = new Object [size]; 
		this.size = 0; 
	}
	
	/**
	 * inserts the job into the linked list taking into account the sorting
	 * @param job
	 */
	public void enque (Job job) {
		if (isFull()) {
			throw new RuntimeErrorException(null, "Array is full");  
		}
		if (size ==0) {
			jobs[0] = job; 
			size++; 
		}
		else {
			
			
		for (int i=0; i < size ; i++ ) {
			
			if (job.compareTo( (Job) jobs[i]) < 0) {
		
				
				for (int k= size ; k >= i; k--) {
					if (k == i) {
						jobs[k] =  job; 
					}
					else {
						jobs[k] = jobs[k-1];
					}
			}
				size++; 
			return;
			}
			else if ((i+1) == size) {
				jobs[i+1] = job;
				size++; 
				return; 
			}
		}
	}
	}
	
	/**
	 * Removes the object from list
	 * @return Job object
	 */
	public Job  deque () {
		if (isEmpty()) {
			throw new RuntimeErrorException(null, "Array is empty");  
		}
		
		Job temp = (Job) jobs[0]; 
		jobs[0] = null; 
		
		for (int i= 1 ; i < size; i++) {
			jobs[i-1] = jobs[i]; 
		}
		size--;
		
		jobs[size] = null;
		
		
		return temp; 
	}
	
	/**
	 * Checks if the list is empty
	 * @return boolean
	 */
	public Boolean isEmpty() {
		return size == 0 ; 
	}
	
	/**
	 * Checks if the list is the same size number of jobs
	 * @return boolean
	 */
	public Boolean isFull () {
		return size == jobs.length; 
	}

	/**
	 * overrides the toString method
	 */
	@Override
	public String toString() {
		return "PQ [jobs=" + Arrays.toString(jobs) + "]";
	}

	/**
	 * checks the maximum time it takes
	 * @return Job object
	 */
	public Job getMaxWait () {
		 
		Job temp = (Job) jobs[0];
		int index = -1;
		for (int i=size-1 ; i > 0 ; i--) {
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
	
	/**
	 * basicall a peek, returns smallest job
	 * @return
	 */
	public Job firstItem () {
		return (Job) jobs[0];
	}
}

	
	