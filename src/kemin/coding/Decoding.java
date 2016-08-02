package kemin.coding;

import static d.M.*;

/*
 * �������ַ�A-Z��һ����Ϣ����ʹ�����µ�ӳ�����������֣�
 * 'a' - 1
 * 'b' - 2
 * ...
 * 'z' - 26
 * ����һ����Ϣ�� ���а��������֣�ȷ���������ķ������ܵ���Ŀ
 * ���磺 ��������"12"�����������Ϊ"ab"(1 2) �� "l"(12)
 * ����"12"�ķ�������2�С� 
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
