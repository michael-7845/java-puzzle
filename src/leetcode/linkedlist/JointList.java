package leetcode.linkedlist;

import static d.M.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 如何判断两个链表相交及找到相交点
 * 
 * 分析：
 * 1. 判断两个链表相交
 * 这个很简单，如果两个链表相交，必然在某个节点后是一样的，最后一个结点相交那么可以判断两个链表是相交的
 * 
 * 2. 找到相交点
 * 将链表倒序，从后往前查找最后一个相等的结点
 */

public class JointList {
	
	//创建测试数据
	public static List<Queue<Integer>> getJointList() {
		Queue<Integer> q = new Queue<Integer>(100,101,102);
		//把最后一个node.next指向3, 创建题目需要的数据结构
		Node<Integer> n3 = q.first.next.next;
		
		Queue<Integer> q1 = new Queue<Integer>(1,2,3);
		q1.last.next = q.first;
		q1.last = q.last;	
				
		Queue<Integer> q2 = new Queue<Integer>(4,5,6,7);
		q2.last.next = q.first;
		q2.last = q.last;	
		
		List<Queue<Integer>> result = new ArrayList<Queue<Integer>>();
		result.add(q1);
		result.add(q2);
		return result;
	}	
	
	public static boolean isJointed(Queue<Integer> q1, Queue<Integer> q2) {
//		if(q1.last._equals(q2.last)) //判断引用地址是否相等，而不是内容是否相等
		if(q1.last.equals(q2.last)) //判断内容是否相等，而不是引用地址是否相等
			return true;
		return false;
	}
	
	//如果是完全相同的引用倒序，倒序后会破坏链表结构
	//先用值相等来表示相交
	//如果是完全相同的引用，可能需要换个思路
	public static Node<Integer> locateJoint(Queue<Integer> q1, Queue<Integer> q2) {
		if(isJointed(q1, q2)) {
			q1.reverse();
			q2.reverse();
			p(q1); p(q2);
			
			Node<Integer> first1 = q1.first, first2 = q2.first, pre1 = null, pre2 = null;
//			while(first1._equals(first2)) { //判断引用地址是否相等，而不是内容是否相等
			while(first1.equals(first2)) { //判断内容是否相等，而不是引用地址是否相等
				pre1 = first1; pre2 = first2;
				first1 = first1.next; first2 = first2.next;
			}
			return pre1;
		}
		return null; //不相交返回null
	}
	
	public static void demo() {
		List<Queue<Integer>> l = getJointList();
		p(isJointed(l.get(0), l.get(1)));
		p(isJointed(new Queue<Integer>(1,2,3), new Queue<Integer>(1,2,3)));
		
//		p(locateJoint(l.get(0), l.get(1)));
		p(locateJoint(new Queue<Integer>(1,2,3,4,5,6), new Queue<Integer>(7,8,9,3,4,5,6)));
	}

	public static void main(String[] args) {
		demo();
	}

}
