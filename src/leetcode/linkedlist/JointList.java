package leetcode.linkedlist;

import static d.M.*;

import java.util.ArrayList;
import java.util.List;

/**
 * ����ж����������ཻ���ҵ��ཻ��
 * 
 * ������
 * 1. �ж����������ཻ
 * ����ܼ򵥣�������������ཻ����Ȼ��ĳ���ڵ����һ���ģ����һ������ཻ��ô�����ж������������ཻ��
 * 
 * 2. �ҵ��ཻ��
 * �������򣬴Ӻ���ǰ�������һ����ȵĽ��
 */

public class JointList {
	
	//������������
	public static List<Queue<Integer>> getJointList() {
		Queue<Integer> q = new Queue<Integer>(100,101,102);
		//�����һ��node.nextָ��3, ������Ŀ��Ҫ�����ݽṹ
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
//		if(q1.last._equals(q2.last)) //�ж����õ�ַ�Ƿ���ȣ������������Ƿ����
		if(q1.last.equals(q2.last)) //�ж������Ƿ���ȣ����������õ�ַ�Ƿ����
			return true;
		return false;
	}
	
	//�������ȫ��ͬ�����õ��򣬵������ƻ�����ṹ
	//����ֵ�������ʾ�ཻ
	//�������ȫ��ͬ�����ã�������Ҫ����˼·
	public static Node<Integer> locateJoint(Queue<Integer> q1, Queue<Integer> q2) {
		if(isJointed(q1, q2)) {
			q1.reverse();
			q2.reverse();
			p(q1); p(q2);
			
			Node<Integer> first1 = q1.first, first2 = q2.first, pre1 = null, pre2 = null;
//			while(first1._equals(first2)) { //�ж����õ�ַ�Ƿ���ȣ������������Ƿ����
			while(first1.equals(first2)) { //�ж������Ƿ���ȣ����������õ�ַ�Ƿ����
				pre1 = first1; pre2 = first2;
				first1 = first1.next; first2 = first2.next;
			}
			return pre1;
		}
		return null; //���ཻ����null
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
