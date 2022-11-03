import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

//Random Questions number in array and collect answer from users. 
public class RandomMtd extends MainPage {
	//Create Object for RandomMethod.
	Random ran = new Random();
	
	//Create Set and Array.	
	Set <Integer> setArray = new LinkedHashSet<>();
	ArrayList<Integer > setToArray= new ArrayList<>();
	ArrayList<Integer > selectArray= new ArrayList<>();
	
	//Generate Random Number and add into SetArray.
	public void setRandomNumber() {
     while(setArray.size()<=a) {
    	 int	rand = ran.nextInt(a);
    	 	setArray.add(rand);
        }
     setRandomNumberToArray();
     }
	//SetArray to ArrayList.
	public void setRandomNumberToArray() {
		for(int x : setArray) {
			setToArray.add(x);
		}
		collectNoOfQue();
	}
	
	int c =3;
	//Collect Question From users.
	public void collectNoOfQue() {
		//loop for 3times chance.
		for(int i=0;i<3;i++) {
	    //Collect Count of Question.
		Scanner scan = new Scanner(System.in);
		System.out.println("How Many Question You Want to Write : ");
		int answer =scan.nextInt();
		
		//Check Lesser equal than NoOf Questions. 
		if(answer<=xlQuestionArray.size()) {
		for(int i1=0;i1<answer;i1++) {
			selectArray.add(i1, setToArray.get(i1));
		}
		collectAnswer();
		break;
		}
		//Repeat and Chance Reduce .
		else {
			System.out.println("Selected Questions Greater than your Csv file.");
			System.out.println("So please select less than "+(xlQuestionArray.size())+".");
			System.out.println("Only "+(c-1)+" change.");
			c=c-1;
		}
		}
		
	}
	//Create Array
	ArrayList<String > xlAnswer= new ArrayList<>();
	ArrayList<String > userAnswer= new ArrayList<>();
	
	//Collect Answer From Users.
	public void collectAnswer() {

		for(int i=0;i<selectArray.size();i++) {
			
			System.out.println(questionMap.get(selectArray.get(i)));
			Scanner scan = new Scanner(System.in);
			System.out.println("Answer : ");
			String answer =scan.nextLine();
		
			userAnswer.add(i, answer.toLowerCase());
			xlAnswer.add(i, answerMap.get(selectArray.get(i)));	
		}
		}

}
