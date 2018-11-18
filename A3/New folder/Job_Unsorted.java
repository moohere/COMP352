import java.util.Random;
import java.util.Comparator;

/**
 * 
 * a job class that implements comparable, holding the and holding its value.
 * this job is used for the unsorted list. 
 * @author Mustafa Omran - 26745954 - Muherthan Thalayasingam - 27223064
 * each job will have a random number assigned to it as the name, length. </br> 
 * Each time we create a job. Its entry is set to the jobs created and the value of job incremented. 
 */
public class Job_Unsorted  implements Comparable <Job_Unsorted> {
	private String jobName;
	private int jobLength;
	private int currentJobLength;
	private int jobPriority;
	private int finalPriority;
	private long entryTime;
	private long endTime;
	private long waitTime;
	private int currentPriority;
	
	static int priorityBreakMemory = 0;
	static int starvation = 0;
	int priorityBreak = 0;
	static int jobNumber;
	static int counter = 1;
	
	Random random = new Random();
	
	/**
	 * Constructor that uses the random class to generate the jobs length (1-70) and priority (1-40)
	 */	
	public Job_Unsorted(){
		this.jobName = "JOB_" + (jobNumber +1);
		int length = random.nextInt(70) + 1;
		this.jobLength = length;
		this.currentJobLength = length;
		int priority = random.nextInt(40) + 1;
		this.jobPriority = priority;
		this.currentPriority = priority;
		this.finalPriority = priority;
		this.entryTime = 0;
		this.waitTime = 0;
		this.endTime = 0;
	}
	
	/**
	 * return the priority of final priority
	 * @return final priority
	 */
	@Override
	public int compareTo (Job_Unsorted other) {
		if (Integer.compare(this.getCurrentPriority(), other.getCurrentPriority()) != 0 ) 
			return Integer.compare(this.getCurrentPriority(), other.getCurrentPriority());
		else
			return Integer.compare(this.getPriorityBreak(), other.getPriorityBreak());
	}

	/**
	 * used to break even when two jobs have same priority
	 * @param x
	 */
	public void setPriorityBreak(int x) {
		this.priorityBreak = x;
	}
	
	public int getPriorityBreak() {
		return this.priorityBreak;
	}
	
	/**
	 * Get job name
	 * @return jobName
	 */
	public String getJobName() {
		return jobName;
	}

	/**
	 * Get job length 
	 * @return jobLength
	 */
	public int getJobLength() {
		return jobLength;
	}

	/**
	 * Get current job length
	 * @return currentJobLength
	 */
	public int getCurrentJobLength() {
		return this.currentJobLength;
	}

	/**
	 * Set current job length
	 */
	public void setCurrentLength() {
		this.currentJobLength--;
	}
	
	/**
	 * Get job priority
	 * @return jobPriority
	 */
	public int getJobPriority() {
		return jobPriority;
	}

	/**
	 * Set job priority
	 * @param jobPriority
	 */
	public void setJobPriority(int jobPriority) {
		this.jobPriority = jobPriority;
	}

	/**
	 * Get final priority
	 * @return finalPriority
	 */
	public int getFinalPriority() {
		return finalPriority;
	}

	/**
	 * Set final priority
	 * @param finalPriority
	 */
	public void setFinalPriority(int finalPriority) {
		this.finalPriority = finalPriority;
	}

	/** 
	 * get current priority
	 * @return currentPriority
	 */
	public int getCurrentPriority() {
		return currentPriority;
	}

	/**
	 * set current priority
	 * @param currentPriority
	 */
	public void setCurrentPriority(int currentPriority) {
		this.currentPriority = currentPriority;
	}
	
	/**
	 * get entry time
	 * @return entryTime
	 */
	public long getEntryTime() {
		return entryTime;
	}

	/**
	 * set entry time
	 * @param time
	 */
	public void setEntryTime(long time) {
		this.entryTime = time;
	}
	
	/**
	 * get end time
	 * @return endTime
	 */
	public long getEndTime() {
		return endTime;
	}

	/**
	 * set end time
	 * @param endTime
	 */
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	/**
	 * get wait time
	 * @return waitTime
	 */
	public long getWaitTime() {
		return waitTime;
	}

	/**
	 * set wait time
	 */
	public void setWaitTime() {
		this.waitTime = this.endTime - this.entryTime - this.jobLength;
	}

	/**
	 * get counter
	 * @return counter
	 */
	public int getCounter() {
		return counter;
	}

	/**
	 * set counter
	 * @param counter
	 */
	public void setCounter(int counter) {
		this.counter = counter;
	}	
}
