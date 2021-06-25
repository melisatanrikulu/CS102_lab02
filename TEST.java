/**
 * Test class for MySimpleURLReader, HTMLFilteredReader and WordSearch and their methods.
 * @author Melisa Tanrikulu
 * @version 25.06.2021
 */
public class TEST {

	public static void main(String[] args) {
		
		String url = "http://www.cs.bilkent.edu.tr/~ozturk/cs102/scrapethissite.html";
		
		/*
		// PART A. Testing MySimpleURLReader
		// Initialization
		MySimpleURLReader page = new MySimpleURLReader(url);
		
		// Prints the contents of the page
		System.out.println(page.getPageContents());
		
		// Prints the number of lines it contains
		System.out.println(page.getLineCount());
		*/
		
		
		// PART B. Testing getURL
		// Initialization
		MySimpleURLReader page = new MySimpleURLReader(url);
				
		// Prints the filename part of the url
		System.out.println(page.getURL());
		
		
		
		// PART C. Testing getNumberOfCSSLinks
		// Prints the number of CSS files
		System.out.println(page.getNumberOfCSSLinks());
		
		
		
		// PART D. Testing HTMLFilteredReader
		// Initialization
		HTMLFilteredReader page1 = new HTMLFilteredReader(url);
		
		// Prints the text without the html
		System.out.println(page1.getPageContents());
		
		
		
		// PART E. Testing WordSearch
		// Initialization
		WordSearch page2 = new WordSearch(url);
		
		// Array of words
		String[] words = {"Turkey", "Ankara"};
		
		// Searches for the words
		page2.wordSearch(words);

	}

}
