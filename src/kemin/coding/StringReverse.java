package kemin.coding;
import static d.M.*;

// 给定一个字符串，要求将字符串前面的若干个字符移到字符串的尾部
// 例如，将字符串"abcdef"的前3个字符"abc"移到字符串的尾部，那么原来字符串将变成"defabc"

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
