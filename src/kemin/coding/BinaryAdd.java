package kemin.coding;

import static t.S.*;
import static d.M.*;

/**
 * 给定两个二进制字符串，返回他们的加和（也是一个二进制字符串的形式）
 * 
 * @author Kemin Yu
 *
 */

public class BinaryAdd {
	
	String a, b;
	public BinaryAdd(String a, String b) {
		this.a = a;
		this.b = b;
	}
	
	public String add() {
		StringBuilder sb = new StringBuilder();
		
		int len = Math.max(a.length(), b.length());
		char[] ca = getCharArray(fill(a, (len+1), '0'));
		char[] cb = getCharArray(fill(b, (len+1), '0'));
		
		char[] result = new char[len+1];
		int carry=0, value=0;
		for(int i=len;i>=0;i--) {
			int ia = ca[i]-'0';
			int ib = cb[i]-'0';
			value = (ia+ib+carry)%2;
			carry = (ia+ib+carry)/2;
			result[i] = (char)('0'+value);
		}
		
		return String.valueOf(result);
	}
	
	public String add2() {
		Integer iA = Integer.valueOf(this.a, 2);
		Integer iB = Integer.valueOf(this.b, 2);
		return Integer.toString((iA+iB), 2);
	}
	
	public static void demo() {
		BinaryAdd ba = new BinaryAdd("111", "1");
//		p(ba.add2());
		p(ba.add());
	}

	public static void main(String[] args) {
		demo();
	}

}
