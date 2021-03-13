/*
 HW1 Taboo problem class.
 Taboo encapsulates some rules about what objects
 may not follow other objects.
 (See handout).
*/
package assign1;

import java.util.*;

public class Taboo<T> {
	private HashMap<T, HashSet<T>> NewRules;
	
	/**
	 * Constructs a new Taboo using the given rules (see handout.)
	 * @param rules rules for new Taboo
	 */
	public Taboo(List<T> rules) {
		NewRules = new HashMap<T, HashSet<T>>();
		for (int i=0; i < rules.size()-1; i++){
			if (rules.get(i) == null || rules.get(i+1) == null) continue;
			HashSet<T> rule = new HashSet<T>();
			if (NewRules.containsKey(rules.get(i))){
				rule = NewRules.get(rules.get(i));
			}
			rule.add(rules.get(i+1));
			NewRules.put(rules.get(i), rule);
		}
	}
	
	/**
	 * Returns the set of elements which should not follow
	 * the given element.
	 * @param elem
	 * @return elements which should not follow the given element
	 */
	public Set<T> noFollow(T elem) {
		return NewRules.containsKey(elem) ? NewRules.get(elem) : Collections.<T>emptySet(); // TODO YOUR CODE HERE
	}
	
	/**
	 * Removes elements from the given list that
	 * violate the rules (see handout).
	 * @param list collection to reduce
	 */
	public void reduce(List<T> list) {
		for (int i=0; i < list.size()-1; i++){
			if (NewRules.containsKey(list.get(i))){
				if(NewRules.get(list.get(i)).contains(list.get(i+1))){
					list.remove(i+1);
					i--;
				}
			}
		}
	}
}
