import cs1.SimpleURLReader;

/**
 * Extends the SimpleURLReader class, adds three methods to it: getURL()
 * agetName() and getNumberOfCSSLinks().
 * @author Melisa Tanrikulu
 * @version 25.06.2021
 */
public class MySimpleURLReader extends SimpleURLReader {
	
	// Instance Data Members
	private String url;
	
	// Constructors
	
	/*
	 * Creates a MySimpleURLReader object.
	 * @param String url
	 */
	public MySimpleURLReader( String url ) {
		super(url);
		this.url = url;
		
	}
	/*
	 * Returns the url String used to create the SimpleURLReader object.
	 * @return url
	 */
	public String getURL() {
		return this.url;
	}
	
	/*
	 * Returns the filename part of the url.
	 * @return filename part of the url
	 */
	public String getName() {
		// Variables
		int index;
		String name;
		
		// Finds the index of last '/' character
		index = this.url.lastIndexOf("/");
		
		// Gets the filename part of the url
		name = this.url.substring(index + 1);
		
		return name;
		
	}
	
	/*
	 * Returns the number of CSS files in the link.
	 * @return count of CSS files
	 */
	public int getNumberOfCSSLinks() {
		// Variables
		int countOfCSSFiles;
		int lineCount;
		int index;
		String currentLine;
		String contentOfTheUrl;
		String[] lines;
		
		// Initialization
		countOfCSSFiles = 0;
		lineCount = getLineCount();
		
		// Gets the contents of the page and split each line
		contentOfTheUrl = getPageContents();
		lines = contentOfTheUrl.split("\n");
		
		// For each line checks whether the line contains "<link", if it does, checks whether this line contains ".css" 
		// and increases countOfCSSFiles if found
		for ( int lineNumber = 0; lineNumber < lineCount; lineNumber++) {
			currentLine = lines[lineNumber];
			index = currentLine.indexOf("<link");
			
			// If "<link" is not found, index is assigned to -1, otherwise, is it assigned to a nonnegative number
			if ( index >= 0) {
				// If ".css" is not found, index is assigned to -1, otherwise, is it assigned to a nonnegative number
				if ( currentLine.indexOf(".css") >= 0)
					countOfCSSFiles++;
			}
		}
		
		return countOfCSSFiles;
	}
}
