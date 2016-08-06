package kemin.coding;

import java.util.ArrayList;
import java.util.List;

import static d.M.*;
import static t.A.*;

/*
 * Ҫ��ݹ�ʵ�֣�
����1�������1��
����2 �������222   212   222��
����3�������33333   32223   32123   32223   33333
 */
public class BuildStringAsRequired {
	
	public static String[] build(int n) {
		if (n==1) {
			return new String[] {"1"};
		}
		
		List<String> l = new ArrayList<String>();
		String value = Integer.toString(n); //����Ҫ��ӵ��ַ�ֵ(n)
		for(String s: build(n-1)) {
			StringBuilder sb = new StringBuilder(s);
			sb.insert(0, value);
			sb.append(value);
			l.add(sb.toString());
		}
		
		int length = l.get(0).length(); //���ֲ������ַ����ĳ���
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
