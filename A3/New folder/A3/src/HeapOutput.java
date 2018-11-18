import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * a Main for the heap class to test the outputs
 * @author Mustafa Omran - 26745954 - Muherthan Thalayasingam - 27223064
 * Main that set initialize array's based on amount of jobs and display the results to a file. </br>
 * Every 30 jobs completed. we will extract the starving job and inserted back to the array. 
 */
public class HeapOutput {
	public static void main(String[] args) throws FileNotFoundException {
		
		int [] maxNumberOfJobs = {100,1000,10000};

		PrintWriter print = new PrintWriter (new FileOutputStream("HeapOutput.txt")); 

		for (int k =0 ; k <maxNumberOfJobs.length ; k++) {
			Job.counter = 0; 
			Job.jobsCreated =0; 
			
			ArrayHeap jobsInputArray = new ArrayHeap (maxNumberOfJobs[k]);
			for (int i=0; i < maxNumberOfJobs[k] ; i++) {
				jobsInputArray.enque(new Job());
			}

			int counter =0; 
			int totalChanges = 0 ; 
			long average = 0; 

			long start = System.currentTimeMillis();

			while (!jobsInputArray.isEmpty()) {
				Job temp; 
				Job.totalnumberofCycles++;
				temp = jobsInputArray.deque();
				
				/*
				print.println("Now excuting "+ temp.getJobName() +". Job length: "+ temp.getJobLength()
				+" Cycles; Remaning length: "+ temp.getJobLengthRemaning()
				+"; Initial priority "+ temp.getJobPriority() +"; Current priority "+
				temp.getfinalpriortiy()+"\n\n");
				*/


				if (temp.getJobLengthRemaning() > 0) {
					temp.setJobLengthRemaning(temp.getJobLengthRemaning() -1);
					Job.counter +=1; 
					temp.setCurrentTime((int)Job.counter);

					jobsInputArray.enque(temp);

				}

				else 
				{
					temp.setWaitTime((Job.counter -Job.jobsCreated));
					average += temp.getWaitTime();
					//print.println("Total time to complete "+ temp.getJobName()+ ": " + temp.getWaitTime() +" Cycles ");
					counter++;

					if (counter % 30 == 0) {
						temp = jobsInputArray.getMaxWait(); 
						if (temp != null ) {

							//print.println("**To Avoid starvation priority of :  "+ temp.getJobName()+ " Changed to 1 ");
							temp.setfinalpriortiy(1);
							Job.counter +=1; 

							temp.setEntryTime(counter);
							jobsInputArray.enque(temp);
							totalChanges++; 
						}

					}
				}

			}


			long end = System.currentTimeMillis();

			print.println("");

			print.println("Current system time (cycles): " + (Job.totalnumberofCycles) );
			print.println("Total number of jobs executed:  " + ( Job.jobsCreated) +" Jobs");
			print.println("Average process waiting time:  " + average/maxNumberOfJobs[k] +" Cycles.");
			print.println("Total number of priority chnages:  " + totalChanges );
			print.println("Actual system time needed to execute all hobs:  " + (end- start) +"ms.");

			print.println("");
			print.println("---------------------------------------------");
			print.println("");
			jobsInputArray.clear();
		}

		print.close();


	}
}
