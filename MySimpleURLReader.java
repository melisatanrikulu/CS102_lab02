import cs1.SimpleURLReader;

/**
 * Extends the SimpleURLReader class, adds two methods to it: getURL()
 * and getName().
 * @author Melisa Tanrikulu
 * @version 21.06.2021
 */
public class MySimpleURLReader extends SimpleURLReader {
	
	String url;
	
	public MySimpleURLReader( String url ) {
		super(url);
		this.url = url;
		
	}
	/*
	 * Returns the url String used to create the SimpleURLReader object.
	 * @return
	 */
	public String getURL() {
		return this.url;
	}
	
	/*
	 * Returns the filename part of the url.
	 * @return
	 */
	public String getName() {
		// Variables
		int firstIndex;
		String name;
		
		// Finds the last '/' character
		firstIndex = this.url.lastIndexOf("/");
		
		// Gets the filename part of the url
		name = this.url.substring(firstIndex + 1);
		
		return name;
		
	}
}
