package algrithm.classic;

import static d.M.*;

public class Permutate {

	public static int total = 0;
	
	public static void swap(String[] array, int i, int j) {
		String temp = new String();
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void arrange(String[] array, int pos, int len) {
		if(pos == len-1) {
			for(int i=0; i<len; i++) {
				d(array[i] + " ");
			}
			p("");
			total++;
		} else {
			for(int i=pos; i<len; i++) {
				swap(array, pos, i);
				arrange(array, pos+1, len);
				swap(array, pos, i);
			}
		}
	}
	
	public static void demo(String s) {
		String[] array = s.split(",");
		for(String s1: array) {
			p(s1);
		}
		arrange(array, 0, array.length);
	}
	
	public static void main(String[] args) {
		demo("a,b,c,d,e,f,g,h,i,j");
	}

}
