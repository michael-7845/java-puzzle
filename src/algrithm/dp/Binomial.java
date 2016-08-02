package algrithm.dp;

import static d.M.*;
import static t.A.*;


/*
动态规划算法的几个关键点：
1）怎么描述问题，要把问题描述为交叠的子问题
2）交叠子问题的初始条件（边界条件）
3）动态规划在形式上往往表现为填矩阵的形式（在后面会看到，有的可以优化空间复杂度，开一个数组即可，优化也是根据递推式的依赖形式的，后面有篇文章详细说明）
4）填矩阵的方式（或者说顺序）表明了什么？--它表明了这个动态规划从小到大产生的过程，专业点的说就是递推式的依赖形式决定了填矩阵的顺序。
 */

/*
 * 数据求组合公式
 * c(n,k) = c(n-1,k-1)+c(n-1,k)
 */

public class Binomial {
	
	public static Integer[][] bTable(int num) {
		Integer[][] t = new Integer[num+1][num+1];
		for(int i=0; i<num+1; i++) {
			t[i][0] = 1;
			t[i][i] = 1;
		}
		
		for(int n=2; n<num+1; n++) {
			for(int k=1; k<n; k++) {
				t[n][k] = t[n-1][k-1] + t[n-1][k];
			}
		}
		
		return t;
	}
	
	public static Integer[][] bTable2(int num) {
		Integer[][] t = new Integer[num+1][num+1];
		for(int n=0; n<=num; n++) {
			for(int k=0; k<=n; k++) {
				if ((k==0) || (n==k)) {
					t[n][k] = 1;
				} else {
					t[n][k] = t[n-1][k-1] + t[n-1][k];
				}
			}
		}
		return t;
	}
	
	public static Integer[][] bTable3(int num, int sel) {
		Integer[][] t = new Integer[num+1][sel+1]; //如果我们只求解c(num,sel)， 那么只需要求解[num+1][sel+1]就够
		for(int n=0; n<=num; n++) {
			for(int k=0; k<=(sel<n?sel:n); k++) { //如果我们只求解c(num,sel)， 那么只需要求解min(n, sel)就够
				if ((k==0) || (n==k)) {
					t[n][k] = 1;
				} else {
					t[n][k] = t[n-1][k-1] + t[n-1][k];
				}
			}
		}
		return t;
	}
	
	// 传统的动态规划求解
	// btable(), btable2(), btable3(), 进化改进
	public static int c(int n, int k) {
		Integer[][] table = bTable3(n, k);
		return table[n][k];
	}
	
	// 递归解法
	public static int c2(int n, int k) {
		if(n==k) return 1;
		if(k==0) return 1;
		return c2(n-1, k-1) + c2(n-1, k);
	}
	
	// 对传统的动态规划求解进行空间优化，使用一维数组进行求解
	// 对一维数组从右到左进行填充: 根据公式填充上一次结果的 i-i和i的和， 注意不要把有用的值覆盖就可以
	public static int c3(int n, int k) {
		int[] t = new int[k+1];
		for(int i=0; i<=n; i++) {
			for(int j=(i>k?k:i); j>=0; j--) { //从右往左填充
				if(j==0 || j==i) {
					t[j] = 1;
				} else {
					t[j] = t[j] + t[j-1];
				}
			}
		}
		return t[k];
	}
	
	public static void demo() {
//		Integer[][] table = (Integer[][])bTable3(5, 2);
//		print2dArray(table);
		int n = 8;
		int k = 3;
		p(c(n,k));
		p(c2(n,k));
		p(c3(n,k));
	}

	public static void main(String[] args) {
		demo();
	}

}
