package jackHenry;

import java.util.Scanner;

public class CountPNG {
	public static int countPNG(String htmlSource){
		//Opens a new scanner for HTML Source
		Scanner scan = new Scanner(htmlSource);
		//Initialize the amount for png images.
		int amount = 0;
		//While loop to scan through the document.
		while(scan.hasNext() == true){
			//If statement is satisfied if it detects an image tag in the line
			if(scan.findInLine("<img")!=null){
				//If statement is satisfied if it finds a .png after the image tag in the line.
				if(scan.findInLine(".png")!=null){
					//Increment amount if both conditions are met.
					amount++;
				}
			}
			//Moves the scanner to the next line.
			scan.nextLine();
		}
		//Closes the scanner to prevent a resource leak
		scan.close();
		//returns the amount of pngs.
		return amount;
	}

}
