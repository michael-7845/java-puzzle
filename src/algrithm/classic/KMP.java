package algrithm.classic;

import static d.M.*;

/*
 * 字符串匹配经典算法KMP改进
 */
public class KMP {
	public static void main(String[] args) {  
		demo2();
    }  
	
	public static void demo() {
        String s = "abbabbbbcab"; // 主串  
        String t = "bbcab"; // 模式串  
        char[] ss = s.toCharArray();  
        char[] tt = t.toCharArray();  
        System.out.println(kmpIndex(ss, tt)); // KMP匹配字符串  
	}
	
	public static void demo2() {
		String t = "abcabx"; // 模式串  
		int[] n = next(t.toCharArray());
		for(int i: n) {
			p(i);
		}
	}
  
    /** 
     * 获得字符串的next函数值 
     *  
     * @param t 字符串 
     * @return next函数值 
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
     * KMP匹配字符串 
     *  
     * @param s 主串 
     * @param t 模式串 
     * @return 若匹配成功，返回下标，否则返回-1 
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
            return i - t.length; // 返回模式串在主串中的头下标  
    }  
}
