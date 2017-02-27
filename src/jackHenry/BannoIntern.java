package jackHenry;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.*;
import org.apache.http.util.EntityUtils;

public class BannoIntern {
	public static void main (String [] args) throws ClientProtocolException, IOException{
		//sets the url for banno as a string variable for easy access.
		String url = "https://banno.com/";
		CloseableHttpClient client = HttpClients.createDefault();
		//Creates a new HttpGet for the banno url
		HttpGet httpget = new HttpGet(url);
		//Executes the get request above
		CloseableHttpResponse response = client.execute(httpget);
		try {
			//Create an entity to capture the http response
			HttpEntity entity = response.getEntity();
			//Convert the entity to a string containing the HTML source code for the website
			String htmlSource = EntityUtils.toString(entity);
			//use trim to remove any excess white space for faster processing.
			htmlSource.trim();
			//Calls the findTwitter method in the FindTwitter class to find locate the twitter handle 
			String twitterHandle = FindTwitter.findTwitter(htmlSource);
			//Prints the twitter handle
			System.out.println("\nTwitter Handle: " + twitterHandle);
			//Calls the countFinance function to count the number of times financial institution appears and stores it.
			int financeInstitutionCount = FindFinancialInstitution.countFinance(htmlSource);
			//Prints the result of the countFinance function in the FindFinancialInstitution class.
			System.out.println("Number of times \"financial institution\" is found in the text: " +financeInstitutionCount);
			//Calls the countPNG function. Save the result to the numberOfPNG variable.
			int numberOfPNG = CountPNG.countPNG(htmlSource);
			//Prints the number of .png images saved under numberOfPNG variable.
			System.out.println("There are " + numberOfPNG + " .png images in this site.");
			TopThreeAlpaNum topThree = TopThreeAlpaNum.topThree(htmlSource);
			//These three lines convert the ascii value from the index of the most common letter
			//back to characters.
			String topNum = Character.toString((char)topThree.getFirstPosition());
			String secondNum = Character.toString((char)topThree.getSecondPos());
			String thirdNum = Character.toString((char)topThree.getThirdPos());
			//These three grab the number of occurrences in the 
			int firstOcc = topThree.getFirst();
			int secondOcc = topThree.getSecond();
			int thirdOcc = topThree.getThird();
			System.out.print("The top three letters are: " + topNum + " " + secondNum + " " + thirdNum);
			System.out.println(". They occur: " + firstOcc + ", " + secondOcc + ", and " + thirdOcc + " respectively.");
			CountPlatFeats features = CountPlatFeats.numOfFeats(htmlSource);
			int numOfProducts = features.getProductsNum();
			int numOfOthers = features.getNumOfOthers();
			System.out.println("There are " + numOfProducts + " in the product features section.");
			System.out.print("There are " + numOfOthers + " in the Website products section.");
			System.out.print(" All together there are "+ (numOfProducts + numOfOthers) + " features listed\n");
		} finally {
			//Ends the connection to the url
			httpget.releaseConnection();
		}
		
		
	}
}
