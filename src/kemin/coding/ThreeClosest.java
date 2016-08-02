package kemin.coding;

import static d.M.p;

import java.util.Arrays;

/**
 * 给定整数的一个数组，找出这样3个数a,b,c，满足a+b+c最接近一个给定的target,
 * 返回这个3个数。可以假设每一次输入都只求一个解决方案。
 * 
 * @author Kemin Yu
 *
 */

public class ThreeClosest {
	
	int[] array = {12, -19, -18, 15, -15, -11, -9, -7, -5, -4, -3, -2, -1, 0, 2, 3, 4, 5, 8, 9,};
	int target = 0;
	
	public ThreeClosest(int target) {
		this.target = target;
	}
	
	class Result {
		int i, j, k;
		int xVal, yVal, zVal;
		int sum, delta;
		public String toString() {
			return String.format("[%d] - %d, [%d] - %d, [%d] - %d, sum: %d, delta: %d", 
					i, xVal, j, yVal, k, zVal, sum, delta);
		}
	}
	
	public void method() {
		Arrays.sort(this.array);
		int min = Integer.MAX_VALUE;
		Result r = new Result();
		
		for(int i=0;i<array.length-2;i++) {
			int start=i+1, end=this.array.length-1;
			while(start<end) {
				int sum = array[i]+array[start]+array[end];
				int sub = target-sum;
				int delta = Math.abs(sub);
				if(delta<min) {
					min = delta;
					r.i=i; r.j=start; r.k=end;
					r.xVal=array[i]; r.yVal=array[start]; r.zVal=array[end];
					r.sum = sum; r.delta = delta;
					p(r.toString());
				}
				if(sub>0) {
					start++;
				}else if(sub<0) {
					end--;
				}else{
					break;
				}
			}
		}
		
		p(r.toString());
	}
	
	public static void demo() {
		ThreeClosest tc = new ThreeClosest(20);
		tc.method();
	}

	public static void main(String[] args) {
		demo();
	}

}
