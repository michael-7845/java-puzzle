package leetcode.string;

import static kemin.util.Pr.*;

public class CompressString {
	
	public static String compress(String orig) {
		StringBuffer sb = new StringBuffer();
		int length = orig.length();
		if(length <= 1)
			return orig;
		
		for(int i=0; i<length; i++) {
			int j = i+1;
			char c = orig.charAt(i);
			while(j<length && c==orig.charAt(j)) {
				j++;
			}
			sb.append(c);
			sb.append(j-i);
			i = j-1;
		}
		
		return sb.toString();
	}
	
	public static void demo() {
		String s1 = "aabcccaaaa";
        String expectedS1 = "a2b1c3a4";
        println(compress(s1));
	}

	public static void main(String[] args) {
		demo();
	}

}
