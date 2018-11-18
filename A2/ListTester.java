import java.io.*;
import java.util.*; 

/**
 * Main method for testing array list, linked list and my implementation of the them. 
 * @author Mustafa Omran - 26745954 - Muherthan Thalayasingam - 27223064
 */
public class ListTester {
	
	public static void main(String[] args) throws IOException{
		System.out.println("\t*****-------- Welcome To my list compare *****--------");
		PrintWriter write = new PrintWriter(new FileOutputStream("testrun.txt",true));
		Random random = new Random(); 
		Scanner key = new Scanner(System.in); 
		
		
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		LinkedList<Integer> linklist = new LinkedList <Integer>();
		MyArrayList<Integer> myarraylist = new MyArrayList<Integer>();
		MyLinkedList<Integer> mylinkedlist = new MyLinkedList<Integer>();
		
		
		int n = 10;
		
		for (int i=0; i<=5; i++) {
			write.println("N is :" + n);
			
			printMyArrayList(n, write, myarraylist, random);
			printArrayList(n, write, arrayList, random);
			printMyLinkedList(n, write, mylinkedlist, random);
			printLinkedList(n, write, linklist, random);
			
			
			write.println("------------------------------------------------------------------------------------------------");
			write.println("");
			n*= 10;
			
			//System.out.println(arrayList);
			//System.out.println(linklist);
			//System.out.println(myarraylist);
			//System.out.println(mylinkedlist);
			
			
			arrayList.clear();
			myarraylist.clear();
			linklist.clear();
			mylinkedlist.clear();
			
		}
		
		
		
		write.close();
		key.close();
		System.out.println("\n\n\n\t*****-------- Please visit the source file for the results *****--------");
	}
	
	/**
	 * print the List with a given n for the size and write the result to test file, the operation include add and remove <br/>
	 * based on index and value. Random class is used to generate the values based on n and from 0 - N. 
	 * @param n number of times it will run and also act as base for the random number
	 * @param write a printwriter to write the file too 
	 * @param myarraylist a list
	 * @param random random class to generate the numbers 
	 */
	public static void printMyArrayList(int n, PrintWriter write, MyArrayList<Integer> myarraylist, Random random) {
		long timeBefore =0;
		long timeafter= 0;
		
		write.println();
		write.println("MyArrayList:  Insert@Start(ms) Insert@end (ms)  Insert@random (ms)");
		
		
		if (n<=100000) {
			timeBefore = System.currentTimeMillis();
		for (int i=0; i < n; i++) {
			myarraylist.add(0, (random.nextInt(2*n)+0));
		}
			timeafter = System.currentTimeMillis();
		write.printf("%20d", (timeafter-timeBefore));
		}
		else {
			write.printf("%25s", "Too Long"); 
		}
		

		timeBefore = System.currentTimeMillis();
		for (int i=0; i < n; i++) {
			myarraylist.add((random.nextInt(2*n)+0));
		}
		timeafter = System.currentTimeMillis();
		write.printf("%15d", (timeafter-timeBefore));
		
		if (n <= 10000) {
		timeBefore = System.currentTimeMillis();
		for (int i=0; i < n; i++) {
			myarraylist.add(random.nextInt(n)+0, (random.nextInt(2*n)+0));
		}
		timeafter = System.currentTimeMillis();
		write.printf("%20d", (timeafter-timeBefore));
		}
		
		else 
			write.printf("%20s","Too long"); 
		
		write.println();
		write.printf("Remove@start(ms)  Remove@end(ms)   Remove@random(ms)  Remove byvalue (ms)");
		write.println(); 
		
		timeBefore = System.currentTimeMillis();
		myarraylist.remove(0);
		timeafter = System.currentTimeMillis();
		write.printf("%d", (timeafter-timeBefore));
		
		timeBefore = System.currentTimeMillis();
		myarraylist.remove(myarraylist.size()-1);
		timeafter = System.currentTimeMillis();
		write.printf("%25d", (timeafter-timeBefore));
		
		if (n<=10000) {
			timeBefore = System.currentTimeMillis();
			for (int i=0; i<n;i++) {
			int index= random.nextInt(n)+0;
			myarraylist.remove(index);
	 
			}
			timeafter = System.currentTimeMillis();
			
			write.printf("%20d", (timeafter-timeBefore));
			
			timeBefore = System.currentTimeMillis();
			for (int i=0; i<n;i++) {
				String index= Integer.toString(random.nextInt(2*n)+0);
				myarraylist.remove(index);
			}
			timeafter = System.currentTimeMillis();

			
			write.printf("%20d", (timeafter-timeBefore));
		}
		else {
			write.printf("%20s %20s", "Too long", "Too long");
		}
		
		write.println();
		write.println();
		
		
	}
	
	/**
	 * print the List with a given n for the size and write the result to test file, the operation include add and remove <br/>
	 * based on index and value. Random class is used to generate the values based on n and from 0 - N. 
	 * @param n number of times it will run and also act as base for the random number
	 * @param write a printwriter to write the file too 
	 * @param arrayList a list
	 * @param random random class to generate the numbers 
	 */
	public static void printArrayList(int n, PrintWriter write, ArrayList<Integer> arrayList, Random random) {
		long timeBefore = 0;
		long timeafter = 0; 
		
		write.println("ArrayList:  Insert@Start(ms) Insert@end (ms)  Insert@random (ms)");
		if (n<= 100000) {
			timeBefore = System.currentTimeMillis();
		for (int i=0; i < n; i++) {
			arrayList.add(0, (random.nextInt(2*n)+0));
		}
			timeafter = System.currentTimeMillis();
			write.printf("%20d", (timeafter-timeBefore));
		}
		else
			write.printf("%25s", "Too Long");
		

		
		timeBefore = System.currentTimeMillis();
		for (int i=0; i < n; i++) {
			arrayList.add((random.nextInt(2*n)+0));
		}
		timeafter = System.currentTimeMillis();
		write.printf("%15d", (timeafter-timeBefore));
		
		if (n <= 10000) {
		timeBefore = System.currentTimeMillis();
		for (int i=0; i < n; i++) {
			arrayList.add(random.nextInt(n)+0, (random.nextInt(2*n)+0));
		}
		timeafter = System.currentTimeMillis();
		write.printf("%20d", (timeafter-timeBefore));
		}
		else {
			write.printf("%20s","Too long");  
		}
		
		write.println();
		write.printf("Remove@start(ms)  Remove@end(ms)   Remove@random(ms)  Remove byvalue (ms)");
		write.println(); 
		
		timeBefore = System.currentTimeMillis();
		arrayList.remove(0);
		timeafter = System.currentTimeMillis();
		write.printf("%d", (timeafter-timeBefore));
		
		timeBefore = System.currentTimeMillis();
		arrayList.remove(arrayList.size()-1);
		timeafter = System.currentTimeMillis();
		write.printf("%25d", (timeafter-timeBefore));
		
		if (n<=10000) {
			timeBefore = System.currentTimeMillis();
			for (int i=0; i<n;i++) {
			int index= random.nextInt(n)+0;
			arrayList.remove(index);
	 
			}
			timeafter = System.currentTimeMillis();
			
			write.printf("%20d", (timeafter-timeBefore));
			
			timeBefore = System.currentTimeMillis();
			for (int i=0; i<n;i++) {
			String index= Integer.toString(random.nextInt(2*n)+0);
			arrayList.remove(index);
	 
			}
			timeafter = System.currentTimeMillis();
			
			write.printf("%20d", (timeafter-timeBefore));
			}
		else {
			write.printf("%20s %20s", "Too long", "Too long");
		}
		
		write.println();
		write.println();
	}
	
	
	/**
	 * print the List with a given n for the size and write the result to test file, the operation include add and remove <br/>
	 * based on index and value. Random class is used to generate the values based on n and from 0 - N. 
	 * @param n number of times it will run and also act as base for the random number
	 * @param write a printwriter to write the file too 
	 * @param mylinkedlist a list
	 * @param random random class to generate the numbers 
	 */
	public static void printMyLinkedList(int n, PrintWriter write, MyLinkedList<Integer> mylinkedlist, Random random) {
		
		write.println();
		write.println("MyLinkedList:  Insert@Start(ms) Insert@end (ms)  Insert@random (ms)");
		
		
		long timeBefore = System.currentTimeMillis();
		for (int i=0; i < n; i++) {
			mylinkedlist.add(0, (random.nextInt(2*n)+0));
		}
		long timeafter = System.currentTimeMillis();
		write.printf("%20d", (timeafter-timeBefore));
		

		
		timeBefore = System.currentTimeMillis();
		for (int i=0; i < n; i++) {
			mylinkedlist.add((random.nextInt(2*n)+0));
		}
		timeafter = System.currentTimeMillis();
		write.printf("%15d", (timeafter-timeBefore));
		
		if (n <=1000) {
		
		timeBefore = System.currentTimeMillis();
		for (int i=0; i < n; i++) {
			mylinkedlist.add(random.nextInt(n)+0, (random.nextInt(2*n)+0));
		}
		timeafter = System.currentTimeMillis();
		write.printf("%20d", (timeafter-timeBefore));
		}
		
		else {
			write.printf("%20s","Too long");  
		}
		
		write.println();
		write.printf("Remove@start(ms)  Remove@end(ms)   Remove@random(ms)  Remove byvalue (ms)");
		write.println();
		
		timeBefore = System.currentTimeMillis();
		mylinkedlist.remove(0);
		timeafter = System.currentTimeMillis();
		write.printf("%d", (timeafter-timeBefore));
		
		timeBefore = System.currentTimeMillis();
		mylinkedlist.remove(mylinkedlist.size()-1);
		timeafter = System.currentTimeMillis();
		write.printf("%25d", (timeafter-timeBefore));
		
		
		
		if (n<=10000) {
		timeBefore = System.currentTimeMillis();
		for (int i=0; i<n;i++) {
		int index= random.nextInt(n)+0;
		mylinkedlist.remove(index);
 
		}
		timeafter = System.currentTimeMillis();
		
		write.printf("%20d", (timeafter-timeBefore));
		
		timeBefore = System.currentTimeMillis();
		for (int i=0; i<n;i++) {
		String index= Integer.toString(random.nextInt(2*n)+0);
		mylinkedlist.remove(index);
 
		}
		timeafter = System.currentTimeMillis();
		
		write.printf("%20d", (timeafter-timeBefore));
		
		}
		else {
			write.printf("%20s %20s", "Too long", "Too long");
		}
		
		write.println();
		write.println();
		
	}
	
	/**
	 * print the List with a given n for the size and write the result to test file, the operation include add and remove <br/>
	 * based on index and value. Random class is used to generate the values based on n and from 0 - N. 
	 * @param n number of times it will run and also act as base for the random number
	 * @param write a printwriter to write the file too 
	 * @param linklist a list
	 * @param random random class to generate the numbers 
	 */
	public static void printLinkedList(int n, PrintWriter write, LinkedList<Integer> linklist, Random random) {
		write.println();
		write.println("LinkedList:  Insert@Start(ms) Insert@end (ms)  Insert@random (ms)");
		
		
		long timeBefore = System.currentTimeMillis();
		for (int i=0; i < n; i++) {
			linklist.add(0, (random.nextInt(2*n)+0));
		}
		long timeafter = System.currentTimeMillis();
		write.printf("%20d", (timeafter-timeBefore));
		

		
		timeBefore = System.currentTimeMillis();
		for (int i=0; i < n; i++) {
			linklist.add((random.nextInt(2*n)+0));
		}
		timeafter = System.currentTimeMillis();
		write.printf("%15d", (timeafter-timeBefore));
		
		if (n<= 10000) {
		timeBefore = System.currentTimeMillis();
		for (int i=0; i < n; i++) {
			linklist.add(random.nextInt(n)+0, (random.nextInt(2*n)+0));
		}
		timeafter = System.currentTimeMillis();
		write.printf("%20d", (timeafter-timeBefore));
		
		}
		else {
			write.printf("%20s","Too long"); 
		}
		
		write.println();
		write.printf("Remove@start(ms)  Remove@end(ms)   Remove@random(ms)  Remove byvalue (ms)");
		write.println();
		
		timeBefore = System.currentTimeMillis();
		linklist.remove(0);
		timeafter = System.currentTimeMillis();
		write.printf("%d", (timeafter-timeBefore));
		
		timeBefore = System.currentTimeMillis();
		linklist.remove(linklist.size()-1);
		timeafter = System.currentTimeMillis();
		write.printf("%25d", (timeafter-timeBefore));
		
		
		
		if (n <=10000) {
			timeBefore = System.currentTimeMillis();
			for (int i=0; i<n;i++) {
			int index= random.nextInt(n)+0;
			linklist.remove(index);
	 
			}
			timeafter = System.currentTimeMillis();
			
			write.printf("%20d", (timeafter-timeBefore));
			
			timeBefore = System.currentTimeMillis();
			for (int i=0; i<n;i++) {
			String index= Integer.toString(random.nextInt(2*n)+0);
			linklist.remove(index);
	
			}
			timeafter = System.currentTimeMillis();
			
			write.printf("%20d", (timeafter-timeBefore));
			}
		else {
			write.printf("%20s %20s", "Too long", "Too long");
		}
		
		write.println();
		write.println();
	}


}
