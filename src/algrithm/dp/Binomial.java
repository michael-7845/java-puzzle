package algrithm.dp;

import static d.M.*;
import static t.A.*;


/*
��̬�滮�㷨�ļ����ؼ��㣺
1����ô�������⣬Ҫ����������Ϊ������������
2������������ĳ�ʼ�������߽�������
3����̬�滮����ʽ����������Ϊ��������ʽ���ں���ῴ�����еĿ����Ż��ռ临�Ӷȣ���һ�����鼴�ɣ��Ż�Ҳ�Ǹ��ݵ���ʽ��������ʽ�ģ�������ƪ������ϸ˵����
4�������ķ�ʽ������˵˳�򣩱�����ʲô��--�������������̬�滮��С��������Ĺ��̣�רҵ���˵���ǵ���ʽ��������ʽ������������˳��
 */

/*
 * ��������Ϲ�ʽ
 * c(n,k) = c(n-1,k-1)+c(n-1,k)
 */

public class Binomial {
	
	public static Integer[][] bTable(int num) {
		Integer[][] t = new Integer[num+1][num+1];
		for(int i=0; i<num+1; i++) {
			t[i][0] = 1;
			t[i][i] = 1;
		}
		
		for(int n=2; n<num+1; n++) {
			for(int k=1; k<n; k++) {
				t[n][k] = t[n-1][k-1] + t[n-1][k];
			}
		}
		
		return t;
	}
	
	public static Integer[][] bTable2(int num) {
		Integer[][] t = new Integer[num+1][num+1];
		for(int n=0; n<=num; n++) {
			for(int k=0; k<=n; k++) {
				if ((k==0) || (n==k)) {
					t[n][k] = 1;
				} else {
					t[n][k] = t[n-1][k-1] + t[n-1][k];
				}
			}
		}
		return t;
	}
	
	public static Integer[][] bTable3(int num, int sel) {
		Integer[][] t = new Integer[num+1][sel+1]; //�������ֻ���c(num,sel)�� ��ôֻ��Ҫ���[num+1][sel+1]�͹�
		for(int n=0; n<=num; n++) {
			for(int k=0; k<=(sel<n?sel:n); k++) { //�������ֻ���c(num,sel)�� ��ôֻ��Ҫ���min(n, sel)�͹�
				if ((k==0) || (n==k)) {
					t[n][k] = 1;
				} else {
					t[n][k] = t[n-1][k-1] + t[n-1][k];
				}
			}
		}
		return t;
	}
	
	// ��ͳ�Ķ�̬�滮���
	// btable(), btable2(), btable3(), �����Ľ�
	public static int c(int n, int k) {
		Integer[][] table = bTable3(n, k);
		return table[n][k];
	}
	
	// �ݹ�ⷨ
	public static int c2(int n, int k) {
		if(n==k) return 1;
		if(k==0) return 1;
		return c2(n-1, k-1) + c2(n-1, k);
	}
	
	// �Դ�ͳ�Ķ�̬�滮�����пռ��Ż���ʹ��һά����������
	// ��һά������ҵ���������: ���ݹ�ʽ�����һ�ν���� i-i��i�ĺͣ� ע�ⲻҪ�����õ�ֵ���ǾͿ���
	public static int c3(int n, int k) {
		int[] t = new int[k+1];
		for(int i=0; i<=n; i++) {
			for(int j=(i>k?k:i); j>=0; j--) { //�����������
				if(j==0 || j==i) {
					t[j] = 1;
				} else {
					t[j] = t[j] + t[j-1];
				}
			}
		}
		return t[k];
	}
	
	public static void demo() {
//		Integer[][] table = (Integer[][])bTable3(5, 2);
//		print2dArray(table);
		int n = 8;
		int k = 3;
		p(c(n,k));
		p(c2(n,k));
		p(c3(n,k));
	}

	public static void main(String[] args) {
		demo();
	}

}
