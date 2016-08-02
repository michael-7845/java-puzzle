package leetcode.string;

import static d.M.*;

/*
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") return false
isMatch("aa","aa") return true
isMatch("aaa","aa") return false
isMatch("aa", "a*") return true
isMatch("aa", ".*") return true
isMatch("ab", ".*") return true
isMatch("aab", "c*a*b") return true
 */

public class REMatching {
	
	public static boolean match(String s, String p) {
		if(p.length() == 0) 
			return (s.length() == 0);
		
		if(p.length() == 1) {
			if((s.charAt(0)!=p.charAt(0)) && (p.charAt(0)!='.'))
				return false;
			else 
				return match(s.substring(1), p.substring(1));
		}
		
		// case 1: when the second char of p is not '*'
		if(p.charAt(1) != '*') {
			if(s.length() < 1)
				return false;
			if((s.charAt(0)!=p.charAt(0)) && (p.charAt(0)!='.')) {
				return false;
			} else {
				return match(s.substring(1), p.substring(1));
			}
		// case 2: when the second char of p is '*', complex case.
		} else {
			//case 2.1: a char & '*' can stand for 0 element
			if(match(s, p.substring(2)))
				return true;
			//case 2.2: a char & '*' can stand for 1 or more preceding element, 
			//so try every sub string
			int i = 0;
			while((i<s.length()) && (s.charAt(0)!=p.charAt(0)) && (p.charAt(0)!='.')) {
				if(match(s.substring(i+1), p.substring(2)))
					return true;
				i++;
			}
			return false;
		}
	}
	
	public static void demo() {
		p(match("aa","a"));
		p(match("aa","aa"));
		p(match("aaa","aa"));
		p(match("aa", "a*"));
		p(match("aa", ".*"));
		p(match("ab", ".*"));
		p(match("aab", "c*a*b"));
	}

	public static void main(String[] args) {
		demo();
	}

}
