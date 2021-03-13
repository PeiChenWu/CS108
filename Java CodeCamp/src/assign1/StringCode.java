package assign1;

import java.util.HashSet;
//import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adjacent chars that are the same.
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {
		if (str.length()==0) return 0;
		int max = 1;
		int currcount = 1;
		for (int i=0; i < str.length()-1; i++){
			if (str.charAt(i)==str.charAt(i+1)){
				currcount++;
				if (currcount > max) max = currcount;
			}
			else{
				currcount = 1;
			}
		}
		return max; // TODO ADD YOUR CODE HERE
	}

	
	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {
		if (str.length()==0) return "";
		String myList = new String();
		for (int j=0; j < str.length(); j++){
			char c = str.charAt(j);
			if ((c >= '0' && c <='9') && (j < str.length()-1)){
				for (int i = (int)c-48; i > 0; i--){
					myList += str.charAt(j+1);
				}
			}
			else {
				if (c < '0' || c > '9') myList += c;
			}
		}
		return myList; // TODO ADD YOUR CODE HERE
	}
	
	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
		HashSet<String> mySet = new HashSet<String>();
		for (int i=0; i+len <= a.length(); i++){
			mySet.add(a.substring(i, i+len));
		}
		for (int i=0; i+len <= b.length(); i++){
			if (mySet.contains(b.substring(i, i+len))){
				return true;
			}
		}
		return false; // TO DO ADD YOUR CODE HERE
	}
}
