import java.util.ArrayList;

//Validation and Evaluation 
public class KeywordValidation extends KeywordMtd {
	
	//Create ArrayList(Array)
	ArrayList<String[] > userKeywordAnswerArray= new ArrayList<>();
	ArrayList<String[] > xlkeywordAnswerArray= new ArrayList<>();
	ArrayList<Float > finalmark = new ArrayList<>();
	
	//ArrayList to ArrayList(Array)
	public void userKeywordAnsToArray() {
		for(int j=0;j<userKeywordAnswer.size() ;j++) {
			String ab1=userKeywordAnswer.get(j);
			String abc1[]=ab1.split(" ");
			userKeywordAnswerArray.add(j, abc1);
	}
		xlKeywordAnsToArray();
		validation();
	}
	
	//ArrayList to ArrayList(Array)
	public void xlKeywordAnsToArray() {
		for(int j=0;j<xlKeywordAnswer.size() ;j++) {
			String ab1=xlKeywordAnswer.get(j);
			String abc1[]=ab1.split(" ");
			xlkeywordAnswerArray.add(j, abc1);
	}}
	
	//Validation and Add mark in array.
	public void validation() {
	
		for(int i=0;i<xlKeywordAnswer.size();i++) {
			float count=0f;
			for(int j=0;j<userKeywordAnswerArray.get(i).length;j++) {
				if(xlKeywordAnswer.get(i).contains(userKeywordAnswerArray.get(i)[j])) {
					count++;
				}
			}
			finalmark.add(i,(float) ((count/xlkeywordAnswerArray.get(i).length)*100.0f) );
			count=0;
		}
		marks();
	}
	
	//Marks Output.
	public void marks() {
		
		float total =0;
		
		float avg=0;
		
		for(int i=0;i<finalmark.size();i++) {
			System.out.println((i+1)+".)Que Mark "+finalmark.get(i));
			total=total+finalmark.get(i);	
		}
		avg=total/finalmark.size();
		System.out.println("Total Average Mark : "+avg);
	}
	
	//Call Method.
	public void enduser() {
		xlupdate();
		questionToArray();
		userKeywordAnsToArray();
	}

}
