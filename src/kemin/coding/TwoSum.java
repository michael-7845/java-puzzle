package kemin.coding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import static d.M.*;

/**
 * 给定整数的一个数组，找出这样两个数，他们的和等于一个特定目标数字(target)
 * 
 * @author Kemin Yu
 *
 */
public class TwoSum {
	
	static class MyArray {
		public static int[] gen(int size) {
			Random r = new Random(103L);
			Set<Integer> s = new HashSet<Integer>();
			while(s.size()<size) {
				s.add(r.nextInt(size*2));
			}
			int[] res = new int[size];
			int i = 0;
			for(int x: s) {
				res[i++] = x;
			}
			return res;
		}
	}
	
	int target = 0;
	int[] array; // = {32, 1, 2, 35, 5, 9, 11, 13, 15, 16, 17, 18, 19, 20, 22, 23, 24, 25, 28, 29};
	
	public TwoSum(int target, int size) {
		this.target = target;
		this.array = MyArray.gen(size);
	}
	
	public void method1() {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<array.length; i++) {
			map.put(array[i], i);
		}
		
		for(int i=0; i<array.length; i++) {
			int x = array[i];
			if(map.containsKey(target-x)) {
				p(String.format("result: [%d] - %d, [%d] - %d", i, x, map.get(target-x), target-x));
				break;
			}
		}
	}
	
	public void method2() {
		Arrays.sort(this.array);
		
		for(int i=0; i<this.array.length; i++) {
			for(int j=this.array.length-1; j>i; j--) {
				if(array[i]+array[j] == target) {
					p(String.format("result: [%d] - %d, [%d] - %d", i, array[i], j, array[j]));
					return;
				}
			}
		}
	}
	
	public void method3() {
		Arrays.sort(this.array);
		
		int start=0, end=this.array.length-1;
		while(start<end) {
			int sum = array[start]+array[end];
			if(sum>target) {
				end--;
			}else if(sum<target) {
				start++;
			}else{
				p(String.format("result: [%d] - %d, [%d] - %d", 
						start, array[start], end, array[end]));
				return;
			}
		}
	}
	
	public static void demo() {
		TwoSum ts = new TwoSum(156, 50);
		ts.method1();
		ts.method2();
		ts.method3();
	}

	public static void main(String[] args) {
		demo();
	}

}
