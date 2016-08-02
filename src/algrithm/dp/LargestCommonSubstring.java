package algrithm.dp;

import static d.M.*;
import static t.A.*;

/*
 * ������Ӵ�(LCS),���������:
 * 1.�����Ӵ���Ԫ�ر�������. => LCS1
 * 2.�����Ӵ���Ԫ�ؿ��Բ���������  => LCS2
 * 3.�����ַ��������������ַ�����������Ӵ�  => LCS3
 */

public class LargestCommonSubstring {
	
	/**
	 * ƥ��������
	 * δ���пռ��Ż�
	 * 
	 * ˵��һ�¿ռ��Ż���
	 * �Ӵ�ͳ������㷨���Կ����� ��ʵÿ�θ�ֵ�����õ�t[i][j]
	 * �õ�һ��t[i-1][j-1]��ʾ�õ�����һ�αȽϵ�״̬��Ϊ�˲��������õ�ֵ�����Կռ��Ż�����b��Ҫ�Ӻ���ǰ������Ḳ�����õ�״̬��Ϣ
	 * �ռ��Ż����Ϊlcs2()
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
	 * ƥ��������
	 * ���пռ��Ż�
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
