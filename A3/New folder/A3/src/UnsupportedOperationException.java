/**
 * if the method is not supported throw this excpetion
 * @author Mustafa Omran-26745954, Muherthan Thalayasingam - 27223064
 *
 */
public class UnsupportedOperationException extends RuntimeException {
	public UnsupportedOperationException () {
		super("This method is not supported");
	}
}
