package leetcode.linkedlist;

import static d.M.*;

/*
 * 判断单链表是否存在环及求环入口点
 * 
 * 分析： 
 * 1. 判断单链表是否存在环
 * 著名的链表谜题， 难点不在编程实现，而在于算法证明
 * 经典的解决方法： 快慢指针， 快指针每次2步，慢指针每次1步
 * 只要存在环路，快指针每次追赶快指针1的距离，所以一定会追赶上，并且只会超1圈就碰上（因为每次追赶1的距离）
 * 如果不存在环路，那么两个指针的距离只可能越来越远，永远不会碰上
 * 
 * 2. 求环的入口点
 * 证明： 相遇时候快指针走过2s(fast = 2*slow), 满指针走过s(slow)， 存在环长r
 * 有公式 2s = s + n*r (俗语超圈) =>　s = nr
 * 从列表开始到环入口点的位置d1
 * 从环入口点到相遇点的距离d2
 * 列表长出l
 * s = d1 + d2
 * r = l - d1
 * 替换得到 (d1+d2) = (n-1)r + (l-d1) => d1 = (n-1)r + (l-d1-d2)
 * 这个公式代表的意思是： 从列表开始到入口点的位置 = 相遇点到入口点的位置
 * (解释： l-d1-d2=l-s为当前相遇点的位置到列表尾的距离，列表尾如果存在循环就是列表头)
 */

public class CycleInList {
	
	//创建测试数据
	public static Queue<Integer> queueWithCycle() {
		Queue<Integer> q = new Queue<Integer>(1,2,3,4,5,6,7,8,9);
		//把最后一个node.next指向3, 创建题目需要的数据结构
		Node<Integer> n = q.first.next.next;
		q.last.next = n;
		return q;
	}
	
	public static boolean isCycled(Queue<Integer> q) {
		Node<Integer> slow = q.first, fast = q.first;
		do {
			try {
				slow = slow.next;
				fast = fast.next.next;
			} catch(NullPointerException e) { //如果没有环会出现空指针异常
				return false;
			}
		} while(!slow.equals(fast));
		return true;
	}
	
	public static Node<Integer> locateCycleEntry(Queue<Integer> q) {
		Node<Integer> result = null;
		
		Node<Integer> slow = q.first, fast = q.first;
		do {
			try {
				slow = slow.next;
				fast = fast.next.next;
			} catch(NullPointerException e) { //如果没有环会出现空指针异常
				return result; //此时为null
			}
		} while(!slow.equals(fast));
		
		fast = q.first;
		do {
			try {
				slow = slow.next;
				fast = fast.next;
			} catch(NullPointerException e) { //经过快慢指针现在已经肯定存在环，但代码我还是留在这里
				return result; //此时为null
			}
		} while(!slow.equals(fast));
		
		return slow;
	}
	
	public static void demo() {
		Queue<Integer> q = queueWithCycle();
		p(isCycled(q));
		p(locateCycleEntry(q));
	}

	public static void main(String[] args) {
		demo();
	}

}
