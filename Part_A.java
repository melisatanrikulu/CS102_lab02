import cs1.SimpleURLReader;
/**
 * Reads the contents of "http://www.cs.bilkent.edu.tr/~ozturk/cs102/housman.txt"
 * and prints it and the number of lines it contains, on the console.
 * @author Melisa Tanrikulu
 * @version 25.06.2021
 */
public class Part_A {

	public static void main(String[] args) {
		// Initialization
		SimpleURLReader page = new SimpleURLReader("http://www.cs.bilkent.edu.tr/~ozturk/cs102/housman.txt");
		
		// Prints the contents of the page
		System.out.println(page.getPageContents());
		
		// Prints the number of lines it contains
		System.out.println(page.getLineCount());
	}

}
