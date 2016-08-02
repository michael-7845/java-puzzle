package leetcode.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static d.M.*;

/*
Given a string s and a dictionary of words dict, 
determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
 */

public class WordBreak {
	
	public static boolean check1(String s, Set<String> dict, int start) {
		if(start == s.length())
			return true;
		
		for(String w: dict) {
			int len = w.length();
			int end = start + len;
			
			if(end > s.length())
				continue;
			
			if(s.substring(start, start+len).equals(w)) {
				if(check1(s, dict, start+len))
					return true;
			}
		}
		
		return false;
	}
	
	public static boolean check2(String s, Set<String> dict, int start) {
		boolean[] check = new boolean[s.length()+1];
		for(boolean b: check) b = false;
		check[0] = true;
		
		for(int i=0; i<s.length(); i++) {
			if(!check[i])
				continue;
			
			for(String w: dict) {
				int len = w.length();
				int end = i+len;
				if(end>s.length())
					continue;
				
				if(check[end])
					continue;
				
				if(s.substring(i, i+len).equals(w)) {
					check[end] = true;
				}
			}
		}
		
		return check[s.length()];
	}
	
	public static boolean check3(String s, Set<String> dict) {
		boolean[] check = new boolean[s.length()+1];
		for(boolean b: check) b = false;
		check[0] = true;
		
		for(int i=0; i<s.length(); i++) {
			if(check[i]) {
				for(int j=i+1; j<=s.length(); j++) {
					String w = s.substring(i, j);
					if(dict.contains(w))
						check[j] = true;
				}
			}
		}
		
		return check[s.length()];
	}
	
	public static void demo() {
		Set<String> dict = new HashSet<String>(Arrays.asList("leet", "code"));
//		p(check1("leetcode", dict, 0));
//		p(check2("leetcode", dict, 0));
		p(check3("leetcode", dict));
	}

	public static void main(String[] args) {
		demo();
	}

}
