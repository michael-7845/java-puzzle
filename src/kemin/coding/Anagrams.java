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
 * 题解：
 * 这道题看所给的字符串数组里面有多少个是同一个变形词变的。
 * 使用HashMap来帮助存老值和新值，以及帮忙判断是否是变形词。
 * 
 * 首先对每个string转换成char array然后排下序，HashMap里面的key存sort后的词，value存原始的词。
 * 然后如果这个排好序的词没在HashMap中出现过，那么就把这个sorted word和unsortedword put进HashMap里面。
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
