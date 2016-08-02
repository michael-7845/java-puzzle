package kemin.coding;

import static d.M.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * 给定整数的一个数组，找出这样3个数a,b,c，满足a+b+c=0,
 * 找出数组中所有满足加和为0的三个组的组合
 * 
 * @author Kemin Yu
 *
 */

public class ThreeZero {

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
				res[i++] = x-size;
			}
			return res;
		}
	}
	
	int[] array = {12, -19, -18, 15, -15, -11, -9, -7, -5, -4, -3, -2, -1, 0, 2, 3, 4, 5, 8, 9,};
	
	public ThreeZero(int size) {
		this.array = MyArray.gen(size);
	}
	
//	public void method1() {
//		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//		for(int i=0; i<array.length; i++) {
//			map.put(array[i], i);
//		}
//		
//		for(int i=0; i<array.length; i++) {
//			int x = array[i];
//			if(map.containsKey(target-x)) {
//				p(String.format("result: [%d] - %d, [%d] - %d", i, x, map.get(target-x), target-x));
//				break;
//			}
//		}
//	}
	
	public void method2() {
		Arrays.sort(this.array);
		
		for(int target=0; target<this.array.length; target++) {
			for(int i=0; i<this.array.length; i++) {
				for(int j=this.array.length-1; j>i; j--) {
					if((array[i]+array[j] == -array[target]) && (i!=j) && (i!=target) && (j!=target)) {
						p(String.format("result: [%d] - %d, [%d] - %d, [%d] - %d", 
								i, array[i], j, array[j], target, array[target]));
						break;
					}
				}
			}
		}

	}
	
	public static void demo() {
		ThreeZero tz = new ThreeZero(20);
//		ts.method1();
		tz.method2();
	}

	public static void demo2() {
		int[] a = MyArray.gen(20);
		for(int x: a) {
			d(x + ", ");
		}
	}
	
	public static void main(String[] args) {
		demo();
	}


}
