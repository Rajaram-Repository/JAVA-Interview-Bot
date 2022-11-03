import java.util.Scanner;

public class RunClass {
	
	public static void main(String[] args) {
	 //Object Create for RandomValidation class and KeywordValidation class 
     RandomValidation random = new RandomValidation();
     KeywordValidation keyword = new KeywordValidation();
	 
     //Declaration and  Initialization
     int count = 3 ; 
	 String randomString ="random";
	 String keywordString = "keyword";
	 
	 for(int i=1;i<4;i++) {
	 //Collect choice from user. 
	 System.out.println("Choose which type Keyword Questions or Random Questions");
	 System.out.println("Type : Random or Keyword ");
	 
	 Scanner scan = new Scanner(System.in);
	 String a = scan.nextLine(); 
	 
	 if(a.equalsIgnoreCase(keywordString)) {
		 keyword.enduser();
		 break;
	 }
	 else if (a.equalsIgnoreCase(randomString) ) {
		 random.enduser();
		 break;
	 }
	 else {
		 if(count == 1) {
			 System.out.println("Pls Restart");
			 break;
		 }
		 else {
		 System.out.println("you have only "+(count-1)+" changes");
		 }
	 }
	 count=count-1;
	}
	}
}
