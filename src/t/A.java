package t;

import static d.M.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Array的辅助工具类
 * @author Kemin Yu
 *
 */

public class A {
	/******************************************
	 * generate int[] array randomly
	 * @param size
	 * @return
	 *******************************************/
	public static int[] gen(int size) {
		Random r = new Random(113L);
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
	
	public static int[] genSorted(int size) {
		int[] _res = gen(size);
		Arrays.sort(_res);
		return _res;
	}
	
	private static void demo() {
		int[] a = gen(20);
		for(int x: a) {
			d(x + ", ");
		}
		p("");
		
		a = genSorted(6);
		for(int x: a) {
			d(x + ", ");
		}
	}
	
	/******************************************
	 * get list of Item, sorted by value
	 * @param a
	 * @return
	 ******************************************/
	public static List<Item> getSortedList(int[] a) {
		List<Item> list = new ArrayList<Item>();
		for(int i=0; i<a.length; i++) {
			list.add(new Item(i, a[i]));
		}
		list.sort(new Comparator<Item>(){
			@Override
			public int compare(Item o1, Item o2) {
				return o1.value-o2.value;
			}
			
		});
		return list;
	}
	
	private static int[] array = {12, -19, -18, 15, -15, -11, -9, -7, -5, -4, -3, -2, -1, 0, 2, 3, 4, 5, 8, 9,};
	static class Item {
		int index;
		int value;
		public Item(int index, int value) {
			this.index = index;
			this.value = value;
		}
		public String toString() {
			return String.format("[%d] - %d", index, value);
		}
	}
	
	private static void demo2() {
		List<Item> list = getSortedList(array);
		for(Item i: list) {
			p(i.toString());
		}
	}
	
	/**
	 * print 2d array
	 * @param args
	 */
	public static <T> void print2dArray(T[][] a) {
//		int row = a.length;
//		int col = a[0].length;
		for(T[] row: a) {
			for(T item: row) {
				d(String.format("| %5s ", item));
			}
			p("|");
		}
	}
	
	private static void demo3() {
		Integer[][] a = {{1, 2, 3}, {4, 15, 6}, {7, 228, 9}};
		print2dArray(a);
	}
	
	/**
	 * print array
	 * @param args
	 */
	public static <T> void printArray(T[] a) {
		for(T item: a) {
			d(String.format("%5s | ", item));
		}
		p("");
	}
	
	private static void demo4() {
		Integer[] a = {1, 2, 3, 4, 15, 6, 7, 228, 9};
		printArray(a);
	}
	
	/**
	 * merge 2 arrays
	 * @param args
	 */
	public static <T> T[] merge(T[] a, T[] b) {
		T[] c = (T[]) new Object[a.length+b.length];
		System.arraycopy(a, 0, c, 0, a.length);
		System.arraycopy(b, 0, c, a.length, b.length);
		return c;
	}
	
	public static int[] merge(int[] a, int[] b) {
		int[] c = new int[a.length+b.length];
		System.arraycopy(a, 0, c, 0, a.length);
		System.arraycopy(b, 0, c, a.length, b.length);
		return c;
	}
	
	public static void demo5() {
//		Integer[] a = {1, 2, 3};
//		Integer[] b = {4, 5, 6};
//		Integer[] c = (Integer[]) merge(a, b);
//		for(Integer i: c) {
//			p(i);
//		}
		int[] a = {1, 2, 3};
		int[] b = {4, 5, 6};
		int[] c = merge(a, b);
		for(int i: c) {
			p(i);
		}
	}
	
	public static void main(String[] args) {
		demo4();
	}

}
