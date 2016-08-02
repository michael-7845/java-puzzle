package leetcode.string;

import static d.M.*;

/*
 * Finding the longest palindromic substring
 */

public class LongestPalindromicSubstring {
	
	public static int longestPal(String s) {
		int length = 0;
		String sub = "";
		
		for(int i=0; i<s.length(); i++) {
			String sub1 = getPal(s, i, i);
			if(length<sub1.length()) {
				length = sub1.length();
				sub = sub1;
			}
			
			String sub2 = getPal(s, i, i+1);
			if(length<sub2.length()) {
				length = sub2.length();
				sub = sub2;
			}
		}
		
		p(sub);
		return length;
	}
	
	public static String getPal(String s, int begin, int end) {
		while ((begin>=0) && (end<s.length()) && (s.charAt(begin)==s.charAt(end))) {
			begin--;
			end++;
		}
		return s.substring(begin+1, end);
	}
	
	public static void demo() {
		String s = "eabcbatlmnfeefnmlk";
//		p(getPal(s, 2, 3));
//		p(getPal(s, 3, 3));
//		p(getPal(s, 3, 4));
		p(longestPal(s));
	}

	public static void main(String[] args) {
		demo();
	}

}
