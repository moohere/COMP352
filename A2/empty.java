/**
 * if the list is empty throw this exception
 * @author Mustafa Omran - Muherthan Thalayasingam 
 *
 */
public class empty extends RuntimeException {
	empty () {
		super("The class array is empty, please fill the array before removing elements");
	}
}
