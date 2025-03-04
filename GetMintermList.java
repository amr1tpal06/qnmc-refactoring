//manages list of user-entered min-terms
//gui
package qnmc;

import java.util.Set;
import java.util.TreeSet;

public class GetMintermList { //creates minterm list
	static Set<String> set=new TreeSet<String>(); //set
	
	public void setMinList(String x){
	
		set.add(x);
		
	}


public static Set<String> getMin(){
	return set;
} //returns minterm list
	
}

//getmintermlist retrieving from model to view



