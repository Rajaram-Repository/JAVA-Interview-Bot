import java.util.ArrayList;

//Validation and Evaluation 
public class RandomValidation extends RandomMtd {
	
	//Create ArrayList(Array)
	ArrayList<String[] > userAnswerArray= new ArrayList<>();
	ArrayList<String[] > xlAnswerArray= new ArrayList<>();
	ArrayList<Float > finalmark = new ArrayList<>();
	
	//ArrayList to ArrayList(Array)
	public void userAnsToArray() {
		for(int j=0;j<userAnswer.size() ;j++) {
			String ab1=userAnswer.get(j);
			String abc1[]=ab1.split(" ");
			userAnswerArray.add(j, abc1);
	}
	xlAnsToArray();
	validation();
	}
	//ArrayList to ArrayList(Array)
	public void xlAnsToArray() {
		for(int j=0;j< xlAnswer.size() ;j++) {
			String ab1= xlAnswer.get(j);
			String abc1[]=ab1.split(" ");
			xlAnswerArray.add(j, abc1);
	}}
	
	//Validation and Add mark in array.
	public void validation() {
		
		for(int i=0;i< xlAnswer.size();i++) {
			float count=0f;
			for(int j=0;j<userAnswerArray.get(i).length;j++) {
				if( xlAnswer.get(i).contains(userAnswerArray.get(i)[j])) {
					count++;
				}
			}
			finalmark.add(i,(float) ((count/xlAnswerArray.get(i).length)*100.0f) );
			count=0;
		}
		marks();
	}
	
	//Marks Output.
	public void marks() {
		float total =0;
		
		float avg=0;
		for(int i=0;i<finalmark.size();i++) {
			System.out.println((i+0)+".)Que Mark "+finalmark.get(i));
			total=total+finalmark.get(i);
			
		}
		avg=total/finalmark.size();
		System.out.println("Total Average Mark : "+avg);
	}
	
	//Call Method.
	public void enduser() {
		xlupdate();
		setRandomNumber() ;
		userAnsToArray() ;
	}

}
