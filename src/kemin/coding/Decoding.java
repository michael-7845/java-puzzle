package kemin.coding;

import static d.M.*;

/*
 * 包含了字符A-Z的一条消息，将使用如下的映射来编码数字：
 * 'a' - 1
 * 'b' - 2
 * ...
 * 'z' - 26
 * 给定一条消息， 其中包含了数字，确定解码它的方法的总的数目
 * 例如： 给定编码"12"，它将会解码为"ab"(1 2) 或 "l"(12)
 * 解码"12"的方法共有2中。 
 */

public class Decoding {
	
	public static int check(char one) {
		return (one!='0') ? 1 : 0;
	}
	
	public static int check(char one, char two) {
		return ((one=='1') || (one=='2' && two <='6')) ? 1 : 0;
	}
	
	public static int decode(char[] ca) {
		if(ca.length == 0 || ca[0] == '0') return 0;
		if(ca.length == 1) return check(ca[0]);
		
		int fn_2 = 1, // n-2
			fn_1 = 0, // n-1
			fn = 0;   // n
		
		fn_1 = check(ca[0])*check(ca[1]) + check(ca[0], ca[1]);
		
		for(int i=2; i<ca.length; i++) {
			if(check(ca[i])==1) fn += fn_1;
			if(check(ca[i-1], ca[i])==1) fn += fn_2;
			if(fn==0) return 0;
			fn_2 = fn_1;
			fn_1 = fn;
			fn = 0;
		}
		return fn_1;
	}
	
	public static void demo() {
		String s = "123";
		p(decode(s.toCharArray()));
		s = "234";
		p(decode(s.toCharArray()));
		s = "345";
		p(decode(s.toCharArray()));
		s = "200";
		p(decode(s.toCharArray()));
	}
	
	public static void main(String[] args) {
		demo();
	}

}
