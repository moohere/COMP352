import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Date;

public class A1 {
	public static int slowOddonaci(int n) {
		if (n<=3) return 1;
		return slowOddonaci(n-1) + slowOddonaci(n-2) + slowOddonaci(n-3);
	}	
	
	public static long fastOddonaci(int n) {
		if (n<=3) return 1;
		
		// Calls the helper method which actually does the tail recursion.
		return helper(1, 1, 1, n-3);
	}
	
	private static long helper(int first, int second, int third, int term) {
		// If the term is 3 or below, it will return the third term which is 1 on the first recursive call.
		if (term <= 0) return third;
		
		// Otherwise, it will shift the values left by one, and then the third value will now be the sum of the past 3 values. 
		// We then do this for every previous terms.
		return helper(second, third, first+second+third, term-1);
	}

	
	public static void main(String[] args) throws IOException {
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("out.txt")));
		
		// The start of the linear recursive approach. I iterate up to n=100 and print into the text file.
		writer.write("Linear Recursion - fastOddanaci method:");
		writer.newLine();
		long startTime = new Date().getTime();
		for (int i = 1; i <= 100; i++) {
			if (i%5 == 0) {
				writer.write("Term " +i + ": " + fastOddonaci(i));
				writer.newLine();
			}
		}
		long endTime = new Date().getTime();
		writer.write("Time elapsed: " + (endTime-startTime)/1000 + " second(s).");
		writer.newLine();
		writer.newLine();
		
		// The start of the inefficient recursive approach. I iterate up to n=40 only since it would take forever. 
		// However, this value of n suffices to show the drastically different time requirements.
		writer.write("Non-linear Recursion - slowOddanaci method:");
		writer.newLine();
		long startTime2 = new Date().getTime();
		for (int i = 1; i <= 40; i++) {
			if (i%5 == 0) {
				writer.write("Term " + i + ": " + slowOddonaci(i));
				writer.newLine();
			}
				
		}
		writer.newLine();
		long endTime2 = new Date().getTime();
		writer.write("Time elapsed: " + (endTime2-startTime2)/1000 + " second(s).");
		writer.newLine();
		writer.close();
	}
}
