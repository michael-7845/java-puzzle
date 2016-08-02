package kemin.coding;

import static d.M.*;

import java.util.ArrayList;
import java.util.List;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top? 
 * 假设你在爬一个楼梯，该楼梯有n阶，你有两种爬法，每次爬一阶或者两阶。请问你有多少种爬法到达楼梯顶部。
 * 思路1：递归
 * 给定一个数n，有两种途径到达n
 * 一，从n-1处，爬一阶楼梯到达n
 * 二，从n-2处，爬两阶楼梯到达n
 * 符合典型的递归思想。
 * 结束条件，当n=1时，只有一种爬法。当n=2时，有两种爬法2+0,1+1
 * 
 * @author Administrator
 *
 */

public class ClimbsStairs {
	
	public static int climb(int n) {
		if(n == 1) {
			return 1;
		}
		if(n == 2) {
			return 2;
		}
		return climb(n-1)+climb(n-2);
	}
	
	public static void demo() {
		p(climb(4));
	}

	String[] m1 = {"1"};
	String[] m2 = {"1+1", "2"};
	public static void climb1() {
		d(1+" ");
	}
	
	static List<String> steps = new ArrayList<String>();
	
	public static void climb(int pos, int len) {
		if(pos == len) {
			
		} else {
			climb1();
		}
	}
	
	public static void main(String[] args) {
		demo();
	}

}
