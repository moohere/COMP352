import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * a Main for the unsorted list to test the output
 * @author Mustafa Omran - 26745954 - Muherthan Thalayasingam - 27223064
 * Main that set initialize array's based on amount of jobs and display the results to a file. </br>
 * Every 30 jobs completed. we will extract the starving job and inserted back to the array. 
 */
public class UnsortedOutput {
	public static void main(String[] args) throws FileNotFoundException {
		int[] maxNumberOfJobs = {100, 1000, 10000, 100000, 1000000};
		File file = new File("UnsortedOutput.txt"); 
		FileOutputStream fos = new FileOutputStream(file);
		PrintStream ps = new PrintStream(fos);
		System.setOut(ps);
		
		for (int k = 0; k < maxNumberOfJobs.length - 2; k ++ ) {		
			Job_Unsorted[] jobsInputArray = new Job_Unsorted[maxNumberOfJobs[k]];
			int cycles = 0;
			int jobsCompleted = 0;
			
			for (int i = 0; i < jobsInputArray.length; i++) {
				Job_Unsorted.jobNumber = i;
				jobsInputArray[i] = new Job_Unsorted();
			}
			
			UnsortedList<Job_Unsorted> upq = new UnsortedList<Job_Unsorted>();
			int priorityCounter  = 1;
						
			for (int i = 0; i < jobsInputArray.length; i++) {
				jobsInputArray[i].setEntryTime(Job_Unsorted.counter);
				jobsInputArray[i].setPriorityBreak(priorityCounter++);
				upq.enqueue(jobsInputArray[i]);
				Job_Unsorted.counter++;
				cycles++;
			}		
			
			int starvation = 0;
			
			long startTime = System.currentTimeMillis();
			int completed = 1;
			
			while(!upq.isEmpty()) {
				
				if (jobsCompleted == 30) {
					jobsCompleted = 0;
					starvation++;
					Job_Unsorted temp  = new Job_Unsorted();
					
					for (int i = jobsInputArray.length - 1; i >= 0; i--) {
						if (jobsInputArray[i].getCurrentJobLength() - jobsInputArray[i].getJobLength() == 0) {
							temp = jobsInputArray[i];
//							System.out.println(" ***** " + temp.getJobName() + " changed priority to avoid starvation.");
							break;
						} else cycles++;
					}					
					temp.setCurrentPriority(Job_Unsorted.starvation);
					temp.setPriorityBreak(Job_Unsorted.priorityBreakMemory - jobsInputArray.length + 1);
				}
				Job_Unsorted job = upq.dequeue();
				cycles++;
				job.setFinalPriority(1);
				
				Job_Unsorted.starvation = job.getCurrentPriority();	
				
				job.setCurrentLength();
				int length = job.getCurrentJobLength();
				
//				System.out.println("Now executing " + job.getJobName() + ". Job length: " + job.getJobLength()
//				+ " cycles; Current remaining length: " + job.getCurrentJobLength() + " cycles; "
//				+ "Initial priority: " + job.getJobPriority() + "; Current priority: " + job.getFinalPriority() + "---" + job.getPriorityBreak() + " " + job.getCurrentPriority());
				
				
				job.setPriorityBreak(job.getPriorityBreak() + jobsInputArray.length);
	
				if (length != 0) {
					upq.enqueue(job);
					cycles++;
					Job_Unsorted.priorityBreakMemory = job.getPriorityBreak();
				} else {
					jobsCompleted++;
					job.setEndTime(cycles);
					job.setWaitTime();
					
//					System.out.println(completed + ". Total time to complete " + job.getJobName() + ": " + job.getWaitTime() + " cycles.");
					completed++;
				}
			}
			
			long totalTime = System.currentTimeMillis() - startTime;
			long avgWait = 0;
			for (int i = 0; i < jobsInputArray.length; i++) {
				avgWait += jobsInputArray[i].getWaitTime();
			}
			avgWait = avgWait/jobsInputArray.length;
	
			System.out.println();
			System.out.println("Current system time (cycles): " + cycles);
			System.out.println("Total number of jobs executed: " + jobsInputArray.length + " jobs.");
			System.out.println("Average process waiting time: " + avgWait + " cycles.");
			System.out.println("Total number of priority changes: " + starvation);
			System.out.println("Actual system time needed to execute all hobs: " + totalTime + "ms.");
			System.out.println("");
			System.out.println("---------------------------------------------");
			System.out.println("");
		}
	}
}
