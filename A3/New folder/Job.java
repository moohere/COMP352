import java.util.Random;

/**
 * a job class that implements comparable, holding the and holding its value.
 * this job is used for the sorted list, and heap implementation. 
 * @author Mustafa Omran - 26745954 - Muherthan Thalayasingam - 27223064
 * each job will have a random number assigned to it as the name, length. </br> 
 * Each time we create a job. Its entry is set to the jobs created and the value of job incremented. 
 */
public class Job implements Comparable <Job>  {
	Random ran = new Random ();
	private String jobName; 
	
	private int jobLength;
	private int jobLengthRemaning;
	
	private int jobPriority;
	private int currentTime; 
	private long entryTime; 
	private int finalpriortiy; 
	public static long counter; 
	public static int jobsCreated=0; 
	private long endTime; 
	private long waitTime;

	public static int totalnumberofCycles =0;
	
	/**
	 * Constructor that uses the random class to generate the jobs length (1-70) and priority (1-40)
	 */
	public Job () {
		this.jobName = "Job_"+(jobsCreated+1);
		
		this.jobLength = ran.nextInt(40)+1; 
		this.jobPriority = ran.nextInt(70)+1; 
		
		finalpriortiy  = jobPriority;
		
		this.entryTime = ++jobsCreated;
		currentTime = (int) this.entryTime;
		counter = jobsCreated; 

		
		jobLengthRemaning = jobLength; 
		waitTime = 0; 
		endTime =0 ;
		
	}


	/**
	 * return the priority of final priority
	 * @return final priority
	 */
	public int getfinalpriortiy() {
		return finalpriortiy;
	}


	/**
	 * get the current time 
	 * @return current time 
	 */
	public int getCurrentTime() {
		return currentTime;
	}


	/**
	 * set the current time
	 * @param currentTime
	 */
	public void setCurrentTime(int currentTime) {
		this.currentTime = currentTime;
	}


	/**
	 * setting the final priority
	 * @param finalpriortiy
	 */
	public void setfinalpriortiy(int finalpriortiy) {
		this.finalpriortiy = finalpriortiy;
	}


	/**
	 * get the job name 
	 * @return job name
	 */
	public String getJobName() {
		return jobName;
	}

	/**
	 * set the job name
	 * @param jobName
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}


	/**
	 * get the length of job
	 * @return job length
	 */
	public int getJobLength() {
		return jobLength;
	}

	/**
	 * set the job length
	 * @param jobLength
	 */
	public void setJobLength(int jobLength) {
		this.jobLength = jobLength;
	}

	/**
	 * get the job priority
	 * @return the job prioirty
	 */
	public int getJobPriority() {
		return jobPriority;
	}

	/**
	 * set the job priority
	 * @param jobPriority
	 */
	public void setJobPriority(int jobPriority) {
		this.jobPriority = jobPriority;
	}

	/**
	 * getting entery time 
	 * @return	entery time 
	 */
	public long getEntryTime() {
		return entryTime;
	}

	/**
	 * set the entery time 
	 * @param entryTime
	 */
	public void setEntryTime(long entryTime) {
		this.entryTime = entryTime;
	}



	/**
	 * get the end time 
	 * @return end time 
	 */
	public long getEndTime() {
		return endTime;
	}

	/**
	 * set the end time 
	 * @param endTime
	 */
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}


	/** 
	 * get the wait time 
	 * @return wait itme 
	 */
	public long getWaitTime() {
		return waitTime;
	}


	/**
	 * set the wait time 
	 * @param waitTime
	 */
	public void setWaitTime(long waitTime) {

		this.waitTime = waitTime;
	}
	

	/**
	 * get the lengh of job remaining
	 * @return
	 */
	public int getJobLengthRemaning() {
		return jobLengthRemaning;
	}


	/**
	 * set the leng of the job reamining 
	 * @param jobLengthRemaning
	 */
	public void setJobLengthRemaning(int jobLengthRemaning) {
		this.jobLengthRemaning = jobLengthRemaning;
	}





	@Override
	/**
	 * compareTo one job to another basd on current time and final priority. 
	 */
	public int compareTo(Job o) {
		if (o.finalpriortiy == this.finalpriortiy) {
			return (int) ( this.currentTime - o.currentTime);
		}
		return this.finalpriortiy - o.finalpriortiy;
	}

	
	
	
	
	
	
}
