/**
 * Takes a text and search for a set of given words in this text.
 * @author Melisa Tanrikulu
 * @version 25.06.2021
 */
public class WordSearch extends HTMLFilteredReader {
	
	// Instance Data Members
	private String text;
	
	// Constructors
	
	/*
	 * Creates a WordSearch object with the given text.
	 * @param String text to be searched
	 */
	public WordSearch( String url ) {
		super( url );
		text = super.getPageContents();
	}
	
	/*
	 * Searchs the text for a set of given words.
	 * @param String[] wordList a set of words to be searched
	 */
	public void wordSearch(String[] wordList) {
		// Variables
		int lengthOfWordList;
		int lineCount;
		int[] wordFoundAtLine;
		String[] lineList;
		String currentLine;
		String searchedWord;
		
		// Initialization
		lengthOfWordList = wordList.length;
		wordFoundAtLine = new int[lengthOfWordList];
		lineList = text.split("\n");
		lineCount = lineList.length;
		
		// Searches for each word
		for ( int wordNumber = 0; wordNumber < lengthOfWordList; wordNumber++ ) {
			// Takes the word
			searchedWord = wordList[wordNumber];
			
			// Checks each line for the searched word
			for ( int lineNo = 0; lineNo < lineCount; lineNo++ ) {
				currentLine = lineList[lineNo];
				
				// If any line contains the word, its place is added in the array and the loop is terminated since
				// the word is found
				if ( currentLine.indexOf( searchedWord ) >= 0 ) {
					
					// lineNo is increased by one since indices start from 0 but line numbers start from 1
					wordFoundAtLine[wordNumber] = lineNo + 1;
					break;
				}
			}
		}
		
		// Displays the found word(s) and place of the word(s) in the text
		for ( int index = 0; index < lengthOfWordList; index++ ) {
			if ( wordFoundAtLine[index] != 0 ) {
				System.out.println( wordList[index] + " found at line " + wordFoundAtLine[index] );
			}
		}

		
	}
}
