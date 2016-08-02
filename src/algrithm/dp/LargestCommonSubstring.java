package algrithm.dp;

import static d.M.*;
import static t.A.*;

/*
 * 最长公共子串(LCS),有三种情况:
 * 1.公共子串的元素必须相邻. => LCS1
 * 2.公共子串的元素可以不相邻联单  => LCS2
 * 3.求多个字符串而不是两个字符串的最长公共子串  => LCS3
 */

public class LargestCommonSubstring {
	
	/**
	 * 匹配矩阵求解
	 * 未进行空间优化
	 * 
	 * 说明一下空间优化：
	 * 从传统矩阵的算法可以看出， 其实每次赋值都是用到t[i][j]
	 * 用到一次t[i-1][j-1]表示用到了上一次比较的状态，为了不覆盖有用的值，所以空间优化对于b需要从后往前，否则会覆盖有用的状态信息
	 * 空间优化后成为lcs2()
	 */
	public static String lcs(String a, String b) {
		Integer[][] t = new Integer[a.length()][b.length()];
		
		int max = -1, iPos = -1, jPos = -1;
		
		for(int i=0; i<a.length(); i++) {
			for(int j=0; j<b.length(); j++) {
				if(a.charAt(i) == b.charAt(j)) {
					if((i==0) || (j==0))
						t[i][j] = 1;
					else
						t[i][j] = t[i-1][j-1] + 1;
				} else {
					t[i][j] = 0;
				}
				if(t[i][j] > max) {
					max = t[i][j];
					iPos = i;
					jPos = j;
				}
			}
		}
//		print2dArray(t);p(max);p(iPos);p(jPos);
		
//		int start = jPos-max+1;
//		int end = jPos;
//		return b.substring(start, end+1);
		
		int start = iPos-max+1;
		int end = iPos;
		return a.substring(start, end+1);
	}
	
	/**
	 * 匹配矩阵求解
	 * 进行空间优化
	 */
	public static String lcs2(String a, String b) {
		Integer[] t = new Integer[b.length()];
		
		int max = -1, iPos = -1, jPos = -1;
		
		for(int i=0; i<a.length(); i++) {
			for(int j=b.length()-1; j>=0; j--) {
				if(a.charAt(i) == b.charAt(j)) {
					if((i==0) || (j==0))
						t[j] = 1;
					else
						t[j] = t[j-1] + 1;
				} else {
					t[j] = 0;
				}
				if(t[j] > max) {
					max = t[j];
					iPos = i;
					jPos = j;
				}
			}
		}
		
		int start = jPos-max+1;
		int end = jPos;
		return b.substring(start, end+1);
		
//		int start = iPos-max+1;
//		int end = iPos;
//		return a.substring(start, end+1);
	}
	
	public static void demo() {
		String a = "21232523311324", b = "312123223445";
//		String a = "abcde", b = "hiab";
		p(lcs2(a, b));
	}

	public static void main(String[] args) {
		demo();
	}

}
