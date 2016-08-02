package kemin.coding;
import static d.M.*;

// ����һ���ַ�����Ҫ���ַ���ǰ������ɸ��ַ��Ƶ��ַ�����β��
// ���磬���ַ���"abcdef"��ǰ3���ַ�"abc"�Ƶ��ַ�����β������ôԭ���ַ��������"defabc"

public class StringReverse {
	
	public static String reverse(String s, int from, int to) {
		int _from=from, _to=to;
		StringBuilder sb = new StringBuilder(s);
		while(from<to) {
			char c = sb.charAt(from);
			sb.setCharAt(from++, sb.charAt(to));
			sb.setCharAt(to--, c);
		}
		return sb.substring(_from, _to+1);
	}
	
	public static String rotate(String s, int n, int m) {
		m %= n;
		String left = reverse(s, 0, m-1);
		String right = reverse(s, m, n-1);
		return reverse(left+right, 0, n-1);
	}
	
	public static void demo() {
		String s = "abcdef";
		p(rotate(s, s.length(), 4));
	}

	public static void main(String[] args) {
		demo();
	}

}
