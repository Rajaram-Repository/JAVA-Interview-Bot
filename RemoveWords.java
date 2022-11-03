import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

//Remove Words from String array.
public class RemoveWords {
// removeSp method used for remove non keywords.  
	public  String[] removeSp (String a[]) {
		//Create Array
		ArrayList <String> arrayToList =new ArrayList<> (Arrays.asList(a));
		//Create Array
		ArrayList <String> filterArray =new ArrayList<>();
		
		//Add non keywords.
		filterArray.add("`");
		filterArray.add("~");
		filterArray.add("!");
		filterArray.add("@");
		filterArray.add("#");
		filterArray.add("$");
		filterArray.add("%");
		filterArray.add("^");
		filterArray.add("&");
		filterArray.add("*");
		filterArray.add("(");
		filterArray.add(")");
		filterArray.add("_");
		filterArray.add("-");
		filterArray.add("+");
		filterArray.add("=");
		filterArray.add("{");
		filterArray.add("[");
		filterArray.add("]");
		filterArray.add("}");
		filterArray.add("|");
		filterArray.add(":");
		filterArray.add(";");
		filterArray.add("'");
		filterArray.add("<");
		filterArray.add(">");
		filterArray.add(",");
		filterArray.add(".");
		filterArray.add("?");
		filterArray.add(" ");
		filterArray.add("what");
		filterArray.add("is");
		filterArray.add("was");
		filterArray.add("the");
		filterArray.add("where");
		filterArray.add("are");
		filterArray.add("differences");
		filterArray.add("between");
		filterArray.add("and");
		filterArray.add("list");
		filterArray.add("of");
		filterArray.add("do");
		filterArray.add("by");
		filterArray.add("by");
		filterArray.add("many");
		filterArray.add("types");
		filterArray.add("its");
	
	//1st loop condition  arrayToList length(parameter array)
	for (int i=0;i<arrayToList.size();i++) {
		//2nd loop condition  filterArray length(non keyword remove array)
		for(int j=0;j<filterArray.size();j++) {
		    //if two array equals the values then add empty space 
			if(arrayToList.get(i).equalsIgnoreCase(filterArray.get(j))) {
				arrayToList.set(i," ");
				
			}

			}
		}
	//Create Array
	ArrayList <String> filterSpace =new ArrayList<>(arrayToList);
	//Create Array
	ArrayList <String> collectResult =new ArrayList<>();
		
	for( String x : filterSpace) {
		//collect non empty space arrays
		if(x!=" ") {
			collectResult.add(x);
		}
	
	}
	//Array list into array
    String [] result=collectResult.toArray(new String[collectResult.size()]);
		
	return result;
	
	}
}
