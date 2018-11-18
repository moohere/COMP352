/**
 * if the list is empty throw this exception
 * @author Mustafa Omran-26745954 Muherthan Thalayasingam -27223064
 *
 */
public class empty extends RuntimeException {
	empty () {
		super("The class array is empty, please fill the array before removing elements");
	}
}
