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
	
	private static void demo() {
		int[] a = gen(20);
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
	 * 
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
	
	public static void main(String[] args) {
		demo3();
	}

}
