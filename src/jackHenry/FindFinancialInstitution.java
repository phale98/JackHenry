package jackHenry;

import java.util.Scanner;

public class FindFinancialInstitution {
	public static int countFinance(String htmlSource){
		//Sets up the target string, the thing we're looking for.
		String target = "financial institution";
		//Sets up a string to exclude the meta tags in the html
		String meta = "meta";
		//Creates a new scanner to parse the htmlSource
		Scanner scan = new Scanner(htmlSource);
		//Sets up a variable for the amount of times the target phrase is found
		int amount = 0;
		//While loop will keep moving through the document until it runs out of lines.
		while(scan.hasNext() == true){
			//First condition is satisfied it "meta" is NOT found on the line.
			if(scan.findInLine(meta) == null){
				//Second condition is satisfied if target is found on the line.
				if(scan.findInLine(target) != null){
					//Amount is incremented
					amount++;
				}
			}
			//Moves the scanner to the next line.
			scan.nextLine();
		}
		//Closes the scanner to prevent a resource leak.
		scan.close();
		//Returns the number of times financial institution is found in the text.
		return amount;
	}

}
