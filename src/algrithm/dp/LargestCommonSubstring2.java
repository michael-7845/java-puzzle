package algrithm.dp;

import static d.M.*;
import static t.A.*;

/*
 * 最长公共子串(LCS),有三种情况:
 * 1.公共子串的元素必须相邻. => LCS1
 * 2.公共子串的元素可以不相邻联单  => LCS2
 * 3.求多个字符串而不是两个字符串的最长公共子串  => LCS3
 */

public class LargestCommonSubstring2 {
	
	/**
	 * 递归求解
	 * dp(i,j) = d(i-1,j-1)+1 if a[i]=b[j]
	 *           max(d(i-1,j), d(i, j-1)) if a[i]!=b[j]
	 * 初始条件: d(0,j) = 0
	 *         d(i,0) = 0
	 */
	public static int lcs(String a, String b) {
		return lcs(a, b, a.length()-1, b.length()-1);
	}
	
	public static int lcs(String a, String b, int i, int j) {
		if((i==-1) || (j==-1)) return 0;
		if(a.charAt(i) == b.charAt(j)) {
			return lcs(a, b, i-1, j-1) + 1;
		} else {
			return Math.max(lcs(a, b, i-1, j), lcs(a, b, i, j-1));
		}
	}
	
	/**
	 * 动态规划求解
	 * 思路和递归求解类似
	 * 可以利用Integer[][]最长长度表，得到lcs子串最大长度
	 * 可以利用String[][]转换路径表，得到lcs子串
	 * 使用String[][]转换路径表更为直观，也可以通过分析Integer[][]最长长度表找到最长子串
	 */
	public static void _lcs2(String a, String b, Integer[][] lengthTable, String[][] pathTable) {
		for(int i=1; i<=a.length(); i++) {
			for(int j=1; j<=b.length(); j++) {
				if(a.charAt(i-1) == b.charAt(j-1)) {
					lengthTable[i][j] = lengthTable[i-1][j-1] + 1;
					pathTable[i][j] = "\\";
				} else {
//					t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
					if(lengthTable[i-1][j] > lengthTable[i][j-1]) {
						lengthTable[i][j] = lengthTable[i-1][j];
						pathTable[i][j] = "|";
					} else {
						lengthTable[i][j] = lengthTable[i][j-1];
						pathTable[i][j] = "-";
					}
				}
			}
		}
	}
	
	public static void _lcs2_string(String b, int i, int j, String[][] pathTable, StringBuffer result) {
		if((i==0) || (j==0)) return;
		
		if(pathTable[i][j].equals("\\")) {
			result.append(b.charAt(j-1));
			_lcs2_string(b, i-1, j-1, pathTable, result);
		} else if(pathTable[i][j].equals("|")) {
			_lcs2_string(b, i-1, j, pathTable, result);
		} else if(pathTable[i][j].equals("-")) {
			_lcs2_string(b, i, j-1, pathTable, result);
		}
	}
	
	public static void lcs2(String a, String b) {
		Integer[][] t = new Integer[a.length()+1][b.length()+1];
		for(int i=0; i<=a.length(); i++) {
			t[i][0] = 0;
		}
		for(int i=0; i<=b.length(); i++) {
			t[0][i] = 0;
		}
		
		String[][] path = new String[a.length()+1][b.length()+1];
		for(int i=0; i<=a.length(); i++) {
			path[i][0] = "o";
		}
		for(int i=0; i<=b.length(); i++) {
			path[0][i] = "o";
		}
		
		_lcs2(a, b, t, path);
		
		p("max length table");
		print2dArray(t);
		p("transition path table");
		print2dArray(path);
		
		StringBuffer result = new StringBuffer();
		_lcs2_string(b, a.length(), b.length(), path, result);
		p(result.reverse().toString());
	}
	
	public static void demo() {
		String a="afbecde", b="haijbkc";
//		p(lcs(a, b));
		lcs2(a, b);
	}
	
	public static void main(String[] args) {
		demo();
	}

}
