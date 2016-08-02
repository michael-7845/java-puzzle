package leetcode.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import static d.M.*;

/*
Given two words (start and end), and a dictionary, 
find the length of shortest transformation sequence from start to end, 
such that only one letter can be changed at a time 
and each intermediate word must exist in the dictionary. 

For example, given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
One shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", the program should return its length 5.
 */

public class WordLadder {
	
	public static int _delta(String a, String b) {
		Set<Character> setA = new HashSet<Character>();
		char[] ca = a.toCharArray();
		for(char c: ca) {
			setA.add(c);
		}
		
		Set<Character> setB = new HashSet<Character>();
		char[] cb = b.toCharArray();
		for(char c: cb) {
			setB.add(c);
		}
		
		setA.removeAll(setB);
//		p(setA);
		return setA.size();
	}
	
	public static void ladder(String[] dict, String target, int level, String cur, Stack<String> solution) {
		if(!solution.isEmpty() && solution.peek().equals(target)) {
			p(solution);
			return;
		}
		for(int i=level; i<dict.length; i++) {
			String w = dict[i];
			if(_delta(cur, w) == 1) {
				solution.push(w);
				ladder(dict, target, level+1, w, solution);
				solution.pop();
			}
		}
	}
	
	public static void demo() {
//		p(_delta("abc", "dbf"));
		
		String[] dict = {"hot","dot","dog","lot","log"};
		String target = "cog";
		Stack<String> solution = new Stack<String>();
		
		ladder(dict, target, 0, "hit", solution);
	}

	public static void main(String[] args) {
		demo();
	}

}
