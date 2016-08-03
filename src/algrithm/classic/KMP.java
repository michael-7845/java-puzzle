package algrithm.classic;

import static d.M.*;

/*
 * �ַ���ƥ�侭���㷨KMP�Ľ�
 */
public class KMP {
	public static void main(String[] args) {  
		demo2();
    }  
	
	public static void demo() {
        String s = "abbabbbbcab"; // ����  
        String t = "bbcab"; // ģʽ��  
        char[] ss = s.toCharArray();  
        char[] tt = t.toCharArray();  
        System.out.println(kmpIndex(ss, tt)); // KMPƥ���ַ���  
	}
	
	public static void demo2() {
		String t = "abcabx"; // ģʽ��  
		int[] n = next(t.toCharArray());
		for(int i: n) {
			p(i);
		}
	}
  
    /** 
     * ����ַ�����next����ֵ 
     *  
     * @param t �ַ��� 
     * @return next����ֵ 
     */  
    public static int[] next(char[] t) {  
        int[] next = new int[t.length];  
        next[0] = -1;  
        int i = 0;  
        int j = -1;  
        while (i < t.length - 1) {  
            if (j == -1 || t[i] == t[j]) {  
                i++;  
                j++;  
                if (t[i] != t[j]) {  
                    next[i] = j;  
                } else {  
                    next[i] = next[j];  
                }  
            } else {  
                j = next[j];  
            }  
        }  
        return next;  
    }  
  
    /** 
     * KMPƥ���ַ��� 
     *  
     * @param s ���� 
     * @param t ģʽ�� 
     * @return ��ƥ��ɹ��������±꣬���򷵻�-1 
     */  
    public static int kmpIndex(char[] s, char[] t) {  
        int[] next = next(t);  
        int i = 0;  
        int j = 0;  
        while (i <= s.length - 1 && j <= t.length - 1) {  
            if (j == -1 || s[i] == t[j]) {  
                i++;  
                j++;  
            } else {  
                j = next[j];  
            }  
        }  
        if (j < t.length) {  
            return -1;  
        } else  
            return i - t.length; // ����ģʽ���������е�ͷ�±�  
    }  
}
