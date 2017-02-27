package jackHenry;

import java.util.Scanner;

public class TopThreeAlpaNum {
	//Initializes all the class variables
	private int highNum;
	private int secondHigh;
	private int thirdHigh;
	private int highNumPos;
	private int secondHighPos;
	private int thirdHighPos;
	//Creates the constructor for the TopThreeAlpaNum Class
	public TopThreeAlpaNum(int numOne, int numTwo, int numThree, int highPos, int secHighPos, int thirdPos){
		highNum = numOne;
		secondHigh = numTwo;
		thirdHigh = numThree;
		highNumPos = highPos;
		secondHighPos = secHighPos;
		thirdHighPos = thirdPos;
		
	}
	//Creates a long list of getters and setters.
	public void setNumOne(int newValue){
		highNum = newValue;
	}
	public void setNumTwo(int newValue){
		secondHigh = newValue;
	}
	public void setNumThree(int newValue){
		thirdHigh = newValue;
	}
	public int getFirst(){
		return highNum;
	}
	public int getSecond(){
		return secondHigh;
	}
	public int getThird(){
		return thirdHigh;
	}
	public int getFirstPosition(){
		return highNumPos;
	}
	public int getSecondPos(){
		return secondHighPos;
	}
	public int getThirdPos(){
		return thirdHighPos;
	}
	public void setHighPos(int newValue){
		highNumPos = newValue;
	}
	public void setSecondPos(int newValue){
		secondHighPos = newValue;
	}
	public void setThirdPos(int newValue){
		thirdHighPos = newValue;
	}
	public static TopThreeAlpaNum topThree(String htmlSource){
		//Amounts will hold the final values. Indexes will be ascii values, numbers held at those values will be prevalence.
		int [] amounts = new int [130];
		//Make a new topThreeAlpaNum object.
		TopThreeAlpaNum result = new TopThreeAlpaNum(0,0,0,0,0,0);
		//Remove every non alphanumeric character in the string.
		String cleaned = htmlSource.replaceAll("[^a-zA-Z0-9]", "");
		//Put everything in upper case, so the ascii values aren't split between lower and upper case.
		//Also open a new scanner.
		Scanner scan = new Scanner(cleaned.toUpperCase());
		//Initialize line variable that will hold each line in the file.
		String line = "";
		//While loop parses the whole file like before.
		while(scan.hasNext() == true){
			//set the line equal to the next available line.
			line = scan.nextLine();
			//trim excess whitespace.
			line.trim();
			//Initialize char array values and set it to the current line.
			char [] values = line.toCharArray();
			//Set up a fore loop that increments the amounts array at the ascii value of values[i].
			//This makes sure that every character is counted in the line.
			for( int i=0; i<values.length;i++){
				amounts[(int) values[i]]++;
			}
		}
		//Initialize values for final results. Starting all at amounts[0].
		int firstNum = amounts[0];
		int secondNum = amounts[0];
		int thirdNum = amounts[0];
		int firstPos = 0;
		int secondPos = 0;
		int thirdPos = 0;
		//Increments the for loop the length of the whole amounts array.
		for(int i =0; i<amounts.length;i++){
			//Sets the firstNum and its position.
			if( amounts[i] > firstNum){
				firstNum = amounts[i];
				firstPos = i;
			}
			//Sets the secondNum and its position.
			if( amounts[i] < firstNum && amounts[i] > secondNum){
				secondNum = amounts[i];
				secondPos = i;
			}
			//Sets the thirdNum and it's position.
			if(amounts[i] < secondNum && amounts[i] > thirdNum){
				thirdNum = amounts[i];
				thirdPos = i;
			}
		}
		//Use the aforementioned getters and setters to set the result object to the appropriate values.
		//We use the result object so that we can return all 6 values in one function, as opposed to 6 different functions.
		result.setNumOne(firstNum);
		result.setNumTwo(secondNum);
		result.setNumThree(thirdNum);
		result.setHighPos(firstPos);
		result.setSecondPos(secondPos);
		result.setThirdPos(thirdPos);

		//close the scanner.
		scan.close();
		//return the appropriate result.
		return result;
	}
}
