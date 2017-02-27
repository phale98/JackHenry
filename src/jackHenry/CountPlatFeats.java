package jackHenry;

import java.util.Scanner;

public class CountPlatFeats {
	//Initialize class variables
	private int numInProducts;
	private int numOfOthers;
	//Create a constructor.
	public CountPlatFeats(int productsNum, int othersNum){
		numInProducts = productsNum;
		numOfOthers = othersNum;
	}
	//Set up my getters and setters.
	public int getProductsNum(){
		return numInProducts;
	}
	
	public int getNumOfOthers(){
		return numOfOthers;
	}
	
	public void setProductsNum(int newValue){
		numInProducts = newValue;
	}
	
	public void setNumOfOthers(int newValue){
		numOfOthers = newValue;
	}
	//This function actually does the work.
	public static CountPlatFeats numOfFeats(String htmlSource){
		//Set up two scanners, the while loops run until the end, so I use two.
		Scanner scan = new Scanner(htmlSource);
		Scanner scanTwo = new Scanner(htmlSource);
		//Set up variables to count the number of products in each section.
		int numOfProducts = 0;
		int numOfSectionAlts = 0;
		//I use booleans to make sure the while loop doesn't accidently start counting h3 class's in the next area.
		boolean inProdSection = false;
		boolean inSectionAlts = false;
		//While loop runs until the document ends.
		while(scan.hasNext()==true ){
			//If the line contains this section name we know we're inside of the area we're aiming at.
			if(scan.findInLine("<section class=\"section\" id=\"products\"")!=null){
				//Set the boolean to true to show that we're in the right section.
				inProdSection = true;
			}
			//
			if(scan.findInLine("<h3 class=")!=null && inProdSection == true){
				numOfProducts++;
			}
			if(scan.findInLine("</section")!=null){
				inProdSection = false;
			}
				scan.nextLine();
			}
		while(scanTwo.hasNext() == true){
			if(scanTwo.findInLine("<section class=\"section section-alt\">")!=null){
				inSectionAlts = true;
			}
			if(scanTwo.findInLine("<h3 class=")!= null && inSectionAlts == true){
				numOfSectionAlts++;
			}
			if(scanTwo.findInLine("</section")!=null){
				inSectionAlts = false;
			}
			scanTwo.nextLine();
		}
		scan.close();
		scanTwo.close();
		CountPlatFeats result = new CountPlatFeats(numOfProducts, numOfSectionAlts);
		return result;
	}
}
