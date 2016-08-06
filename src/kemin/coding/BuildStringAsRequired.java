package kemin.coding;

import java.util.ArrayList;
import java.util.List;

import static d.M.*;
import static t.A.*;

/*
 * 要求递归实现：
输入1：输出：1；
输入2 ：输出：222   212   222；
输入3：输出：33333   32223   32123   32223   33333
 */
public class BuildStringAsRequired {
	
	public static String[] build(int n) {
		if (n==1) {
			return new String[] {"1"};
		}
		
		List<String> l = new ArrayList<String>();
		String value = Integer.toString(n); //本轮要添加的字符值(n)
		for(String s: build(n-1)) {
			StringBuilder sb = new StringBuilder(s);
			sb.insert(0, value);
			sb.append(value);
			l.add(sb.toString());
		}
		
		int length = l.get(0).length(); //本轮产生的字符串的长度
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<length; i++) {
			sb.append(value);
		}
		l.add(0, sb.toString());
		l.add(sb.toString());
		
		return l.toArray(new String[l.size()]);
	}
	
	public static void demo() {
		printArray(build(1));
		printArray(build(2));
		printArray(build(3));
	}

	public static void main(String[] args) {
		demo();
	}

}
