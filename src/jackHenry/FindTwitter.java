package jackHenry;

import java.util.Scanner;

public class FindTwitter {
	public static String findTwitter(String htmlSource){
		// Creates a new Scanner
		Scanner scan = new Scanner(htmlSource);
		//Sets an integer horizon to use in the findWithinHorizon method
		int horizon = htmlSource.length();
		//Scans for the pattern before the twitter handle in the meta tag (can also use the href in the link at bottom).
		scan.findWithinHorizon("<meta name=\"twitter:site\" content=\"@", horizon);
		//Puts the remainder of that line into a character array
		char [] handle = scan.next().toCharArray();
		//Sets up an i to use as an iterator.
		int i = 0;
		//Create a blank string that we will eventually return
		String handleFinal = "";
		//While loop iterates through the character array until it finds the " at the end of the href url
		while(handle[i] != '"'){
			//handleFinal is put together out of the characters of the string, only until the " is hit.
			handleFinal = handleFinal + Character.toString(handle[i]);
			//i is incremented to move through the characters
			i++;
		}
		//This line capitalizes the first letter of the url to make it more presentable.
		handleFinal = handleFinal.substring(0, 1).toUpperCase() + handleFinal.substring(1,handleFinal.length());
		//Closes the scanner
		scan.close();
		//returns the twitter handle with and "@" at the beginning.
		return "@" + handleFinal;
	}
}
