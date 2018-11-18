import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * A simple main method ot test the heap
 * @author Mustafa Omran-26745954, Muherthan Thalayasingam - 27223064
 *
 */
public class Test {

	public static void main(String[] args) throws FileNotFoundException {
		ArrayHeap job = new ArrayHeap (100000) ; 
		
		PrintWriter print = new PrintWriter (new FileOutputStream("Try.txt", true)); 
		Long start = System.currentTimeMillis();
		for (int i=0; i < 10; i++) {
			job.enque(new Job());
		}
		Long end = System.currentTimeMillis();
		
		print.println(end-start);
		
		Long start1 = System.currentTimeMillis();
		for (int i=0; i < 10; i++) {
			System.out.println(job);
			System.out.println(job.deque()); }
		Long end1 = System.currentTimeMillis();
		System.out.println(job);
		print.println(end1-start1);

		print.close();
	}

}
