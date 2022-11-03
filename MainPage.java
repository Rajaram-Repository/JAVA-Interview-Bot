import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//MainPage for CSV file data transfer into map & array .
public class MainPage {
	
	//Create Map
	HashMap<Integer,String> questionMap = new HashMap<>();
	HashMap<Integer,String> answerMap = new HashMap<>();
	//Create Array
	ArrayList<String > xlQuestionArray= new ArrayList<>();
	ArrayList<String > xlAnswerArray= new ArrayList<>();
	
	//variable-a for total Question length . 
	int a=0;
	//CSV file data transfer into map & array .
	public void xlupdate() {
		//try for collect CSV file and insert in array.
		try {
			HashMap<String,String> tempMap = new HashMap<String,String>();
			//Placed path and file into variable-objectFile. 
			File objectFile = new File("C:\\Users\\vinoth A\\Desktop\\bot1.csv");
			Scanner my = new Scanner (objectFile);
			
			//while for set line by line data from CSV.
			while(my.hasNextLine()) {
				String data = my.nextLine();
				//Split column by comma.
				String []arraydata =data.split(",");
				tempMap.put(arraydata[0], arraydata[1]);
			}
			//Map to Array.
			for(String x : tempMap.keySet()) {
				xlQuestionArray.add(x);
			}
			for(String x : tempMap.values()) {
				xlAnswerArray.add(x);
			}

			 
		}
		//If file not found Exception error show.
		catch(FileNotFoundException e) {
			System.out.println("CSV Format File Not Found.");
			e.printStackTrace();
		}
		//Array to Map.
		finally {
			for(int i=0;i<xlQuestionArray.size();i++) {
				questionMap.put(i, (xlQuestionArray.get(i)).toLowerCase());
				answerMap.put(i, (xlAnswerArray.get(i)).toLowerCase());		
		}
		}
		//total Question length .
		a=xlQuestionArray.size();
	}
}
