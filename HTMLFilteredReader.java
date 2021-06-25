
/**
 * Extends the MySimpleURLReader class, adds two methods to it:
 * getPageContents() and getUnfilteredPageContents().
 * @author Melisa Tanrikulu
 * @version 25.06.2021
 */

public class HTMLFilteredReader extends MySimpleURLReader {
	
	// Constructors
	
	/*
	 * Creates a HTMLFilteredReader object.
	 * @param String url
	 */
	public HTMLFilteredReader( String url ) {
		super( url );
	}
	
	/*
	 * Returns only the text, without the html.
	 * @return page contents 
	 */
	public String getPageContents() {
		  // Variables
		  boolean found;
		  int lineCount;
		  int lengthOfLine;
		  String line;
		  String lineWithoutHTML;
		  String pageWithoutHTML;
		  
		  // Initialization
		  lineCount = getLineCount();
		  found = false;
		  lineWithoutHTML = "";
		  pageWithoutHTML = "";
		  
		  // Gets the contents of the page and split each line
		  String page = super.getPageContents();
		  String[] lines = page.split("\n");
		  
		  
		  // For each line ignores the part with "<...>" and adds the other parts to lineWithoutHTML
		  for ( int lineNumber = 0; lineNumber < lineCount; lineNumber++) {
			lineWithoutHTML = "";
		    line = lines[lineNumber].trim();
		    lengthOfLine = line.length();

		    // Ignores the part between "<script type=\"text/javascript\">" and "</script>"
		    if ( line.indexOf("<script type=\"text/javascript\">") >= 0 ) {
		    	do {
		    		// Gets the next line
		    		lineNumber++;
				    line = lines[lineNumber].trim();
				    
				    // If "</script>" is found, terminates the loop
				    if ( line.indexOf("</script>") >= 0 ) {
				    	found = true;
				    	line = lines[lineNumber].trim();
					    lengthOfLine = line.length();
				    }
		    	}
		    	// Continues until "</script>" is found
		    	while( !found );
		    }
		    
		    if ( line.equals("</body>"))
		    	break;
		    
		    // Finds the indices of "<", then finds ">" and ignores the part between them
		    for ( int firstIndex = 0; firstIndex < lengthOfLine; firstIndex++ ) {
		      if ( line.charAt( firstIndex ) == '<' ) {
		        for ( int lastIndex = firstIndex; lastIndex < lengthOfLine; lastIndex++ ) {
		          if ( line.charAt(lastIndex) == '>' ) {
		            firstIndex = lastIndex;
		            break;
		          }
		        }
		      }
		      
		      // If the char is not in "<...>" adds it to lineWithoutHTML
		      else {
		    	lineWithoutHTML += line.charAt(firstIndex);
		      }
		    }
		    
		    // Adds the line to the new page
		    
		    if ( lineWithoutHTML != "")
		    	pageWithoutHTML += lineWithoutHTML + "\n";
		   }
		  
		  return pageWithoutHTML;
		  }

	
	/*
	 * Returns the complete original page with html codes.
	 * @return page contents 
	 */
	public String getUnfilteredPageContents() {
		return super.getPageContents();
	}

}
