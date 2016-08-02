package kemin.coding;

import static d.M.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, return all groups of strings that are anagrams.
 * Note: All inputs will be in lower-case.
 * 
 * ��⣺
 * ����⿴�������ַ������������ж��ٸ���ͬһ�����δʱ�ġ�
 * ʹ��HashMap����������ֵ����ֵ���Լ���æ�ж��Ƿ��Ǳ��δʡ�
 * 
 * ���ȶ�ÿ��stringת����char arrayȻ��������HashMap�����key��sort��Ĵʣ�value��ԭʼ�Ĵʡ�
 * Ȼ���������ź���Ĵ�û��HashMap�г��ֹ�����ô�Ͱ����sorted word��unsortedword put��HashMap���档
 * 
 * @author Kemin Yu
 *
 */

public class Anagrams {
	
	public static Map<String,List<String>> anagrams(String[] sarray) {
		Map<String,List<String>> result = new HashMap<String,List<String>>();
		
		for(String s: sarray) {
			char[] carray = s.toCharArray();
			Arrays.sort(carray);
			String key = String.valueOf(carray);
			
			if(result.containsKey(key)) {
				result.get(key).add(s);
			} else {
				result.put(key, new ArrayList<String>());
				result.get(key).add(s);
			}
		}
		
		return result;
	}
	
	public static void demo() {
		String[] strings = {"abcde", "abcd", "abc", "ab", "a", "abdec", "abecd", "abcde", "acb", "ba", "acb", "a"};
		Map<String,List<String>> map = anagrams(strings);
		for(String key: map.keySet()) {
			p(String.format("key %s:", key));
			p(map.get(key));
		}
	}

	public static void main(String[] args) {
		demo();
	}

}
