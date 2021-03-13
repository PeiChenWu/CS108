package assign1;

import java.util.*;

public class Appearances {
	
	/**
	 * Returns the number of elements that appear the same number
	 * of times in both collections. Static method. (see handout).
	 * @return number of same-appearance elements
	 */
	public static <T> int sameCount(Collection<T> a, Collection<T> b) {
		HashMap<T, Integer> A = new HashMap<T, Integer>();
		for (T elem: a){
			Integer value = A.get(elem);
			A.put(elem, (value == null) ? 1 : value + 1);
		}
		HashMap<T, Integer> B = new HashMap<T, Integer>();
		for (T elem: b){
			Integer value = B.get(elem);
			B.put(elem, (value == null) ? 1 : value + 1);
		}
		
		int count = 0;
		for (T elem: A.keySet()){
			if (A.get(elem).equals(B.get(elem))) count++;
		}	
		return count; // TODO ADD CODE HERE
	}
	
}
