package algrithm.dp;

import static d.M.*;
import static t.A.*;

/*
 * ������Ӵ�(LCS),���������:
 * 1.�����Ӵ���Ԫ�ر�������. => LCS1
 * 2.�����Ӵ���Ԫ�ؿ��Բ���������  => LCS2
 * 3.�����ַ��������������ַ�����������Ӵ�  => LCS3
 */

public class LargestCommonSubstring2 {
	
	/**
	 * �ݹ����
	 * dp(i,j) = d(i-1,j-1)+1 if a[i]=b[j]
	 *           max(d(i-1,j), d(i, j-1)) if a[i]!=b[j]
	 * ��ʼ����: d(0,j) = 0
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
	 * ��̬�滮���
	 * ˼·�͵ݹ��������
	 * ��������Integer[][]����ȱ��õ�lcs�Ӵ���󳤶�
	 * ��������String[][]ת��·�����õ�lcs�Ӵ�
	 * ʹ��String[][]ת��·�����Ϊֱ�ۣ�Ҳ����ͨ������Integer[][]����ȱ��ҵ���Ӵ�
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
