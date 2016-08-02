package t;

import static d.M.*;

import java.util.Arrays;

/**
 * String的辅助工具类
 * @author Kemin Yu
 *
 */

public class S {

	public static char[] getCharArray(String s) {
		char[] carray = new char[s.length()];
		s.getChars(0, s.length(), carray, 0);
		return carray;
	}
	
	public static String fill(String s, int size, char c) {
		StringBuilder sb = new StringBuilder();
		int len = s.length();
		if(size>len) {
			for(int i=0;i<(size-len);i++) {
				sb.append(c);
			}
			sb.append(s);
		}else{
			sb.append(s);
		}
		return sb.toString();
	}
	
	public static void transition() {
		String str = "dabgecf";
		char[] bm;
		
		bm = str.toCharArray();
		for(int i=0;i<bm.length;i++) {
			p(bm[i]);
		}
		Arrays.sort(bm);
		
		str = String.valueOf(bm);
		p(str);
	}
	
	public static void demo() {
		//getCharArray()
//		char[] carr = getCharArray("1100101");
//		for(char c: carr) {
//			p(c);
//		}
		//fill()
//		p(fill("123", 7, '0'));
		//transition()
		transition();
	}
	
	public static void main(String[] args) {
		demo();
	}

}
