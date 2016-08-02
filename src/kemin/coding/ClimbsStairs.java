package kemin.coding;

import static d.M.*;

import java.util.ArrayList;
import java.util.List;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top? 
 * ����������һ��¥�ݣ���¥����n�ף���������������ÿ����һ�׻������ס��������ж�������������¥�ݶ�����
 * ˼·1���ݹ�
 * ����һ����n��������;������n
 * һ����n-1������һ��¥�ݵ���n
 * ������n-2����������¥�ݵ���n
 * ���ϵ��͵ĵݹ�˼�롣
 * ������������n=1ʱ��ֻ��һ����������n=2ʱ������������2+0,1+1
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
