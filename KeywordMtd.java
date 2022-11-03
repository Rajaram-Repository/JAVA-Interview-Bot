import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class KeywordMtd extends MainPage {
	//RemoveWords Class Object Creation.
	RemoveWords removeWords = new RemoveWords();
	
    //Create ArrayList(Array)
	ArrayList<String[] > keywordQuestionArray= new ArrayList<>();
	ArrayList<String[] > keywordAnswerArray= new ArrayList<>();
	
	ArrayList<Integer > keywordCountArray= new ArrayList<>();
	ArrayList<Integer > forIndexKeywordCountArray= new ArrayList<>();
	
	//Remove non Keywords into add QueArray.
	public void questionToArray() {
		for(int j=0;j<questionMap.size() ;j++) {
			String ab1=questionMap.get(j);
			String abc1[]=ab1.split(" ");
			String ckabc1[]=removeWords.removeSp(abc1);
			keywordQuestionArray.add(j, ckabc1);
	}
	answerToArray();
	}
	//Remove non Keywords into add AnsArray.
	public void answerToArray() {
		for(int j=0;j<answerMap.size() ;j++) {
			String ab1=answerMap.get(j);
			String abc1[]=ab1.split(" ");
			String ckabc1[]=removeWords.removeSp(abc1);
			keywordAnswerArray.add(j, ckabc1);
	}
	addKeywordQuestion();	
	}
	//Search keyword from Answer to next Question And Add count in Array list . 
	public void searchKeywordInArray(int a) {
		keywordCountArray.clear();
		forIndexKeywordCountArray.clear();
		for(int j=0;j<keywordQuestionArray.size();j++) {
				int count = 0;
			//Check contains from String Answer Array. 
			for(int l=0;l<keywordQuestionArray.get(j).length;l++) {
				if(xlAnswerArray.get(a).contains(keywordQuestionArray.get(j)[l])) {
					count++;
				   }
				 }
				keywordCountArray.add(count);
			}
			ascendingCountArray();
	}
	
	//Add Null for out of space boundary error.
	public void addNullArray() {
		for(int x=0;x<a*100;x++ ) {
			forIndexKeywordCountArray.add(null);
		}
	}
	
	//Ascending Order in Array and Find Index value of Array.
	public void ascendingCountArray() {
		int temp;
		int temp2;
	    addNullArray();
	
		for(int i=0;i<keywordCountArray.size();i++) {
			for(int j=i+1;j<keywordCountArray.size();j++) {	
				//Ascending Order in Array.
				if(keywordCountArray.get(i)<keywordCountArray.get(j)) {
					
					temp=keywordCountArray.get(j);
					keywordCountArray.set(j,keywordCountArray.get(i));
					keywordCountArray.set(i, temp);
					//Find Index value of Array.
					temp2=j;
					forIndexKeywordCountArray.set(j, i);
					forIndexKeywordCountArray.set(i, temp2);
				}
			}
		}
		
	}
	//Create Array
	ArrayList<Integer > selectKeywordArray= new ArrayList<>();
	ArrayList<Integer > setToKeywordArray= new ArrayList<>();
	Set <Integer> setKeywordArray = new LinkedHashSet<>();
	
	Random ran = new Random();
	//Return Type Method for random. 
	public int random(int a) {
	    	 int	rand = ran.nextInt(a);
	    	 return rand;
	     }
	
	//Add Question in Array.
	public  void addKeywordQuestion() {
		addNullArray();
        for(int i=0;i<a*10;i++) {
			if(forIndexKeywordCountArray.get(0)!=null) {
				//SetList check for Duplicate 
				 if(setKeywordArray.add(forIndexKeywordCountArray.get(0))) {
						setToKeywordArray.add(forIndexKeywordCountArray.get(0));
						int ab=forIndexKeywordCountArray.get(0);
						//Call Next Keyword Keyword Que. 
						searchKeywordInArray(ab);}
					 else {
						 //without keyword else work.
						 int	rand4 = random(a);
						 if(setKeywordArray.add(rand4)) {
							 setToKeywordArray.add(rand4);
							 searchKeywordInArray(rand4);
						 }
						 else {
							//Duplicate value rejection else work.
							int	rand1 = random(a);
							 searchKeywordInArray(rand1);
						 	 } } }
			else {
				//Array is NULL
				 int	rand4 = random(a);
				 if(setKeywordArray.add(rand4)) {
					 setToKeywordArray.add(rand4);
					 searchKeywordInArray(rand4);
				 }
				 else {
					//Duplicate value rejection else work. 
				    int	rand1 = random(a);
					searchKeywordInArray(rand1);
				 	 }
				 }}
        collectNoOfKeywordQue();    
	}
	
	int c =3;
	//Collect Question From users.
	public void collectNoOfKeywordQue() {
		//loop for 3times chance.
		for(int i=0;i<3;i++) {
		//Collect Count of Question.
		Scanner scan = new Scanner(System.in);
		System.out.println("How Many Question You Want to Write : ");
		
		int answer =scan.nextInt();
		//Check Lesser equal than NoOf Questions.
		if(answer<=xlQuestionArray.size()) {
			for(int i1=0;i1<answer;i1++) {
				selectKeywordArray.add(i1, setToKeywordArray.get(i1));
			}
		collectKeywordAnswer();
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
	ArrayList<String > xlKeywordAnswer= new ArrayList<>();
	ArrayList<String > userKeywordAnswer= new ArrayList<>();
		
	//Collect Answer From Users.
	public void collectKeywordAnswer() {
		
		for(int i=0;i<selectKeywordArray.size();i++) {
			
			System.out.println(questionMap.get(selectKeywordArray.get(i)));
			Scanner scan = new Scanner(System.in);
			System.out.println("Answer : ");
			String answer =scan.nextLine();
			
			userKeywordAnswer.add(i, answer.toLowerCase());
			xlKeywordAnswer.add(i, answerMap.get(selectKeywordArray.get(i)));
			
			
		}	}

}
