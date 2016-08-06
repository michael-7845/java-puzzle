package leetcode.linkedlist;

import static d.M.*;

/*
 * �жϵ������Ƿ���ڻ�������ڵ�
 * 
 * ������ 
 * 1. �жϵ������Ƿ���ڻ�
 * �������������⣬ �ѵ㲻�ڱ��ʵ�֣��������㷨֤��
 * ����Ľ�������� ����ָ�룬 ��ָ��ÿ��2������ָ��ÿ��1��
 * ֻҪ���ڻ�·����ָ��ÿ��׷�Ͽ�ָ��1�ľ��룬����һ����׷���ϣ�����ֻ�ᳬ1Ȧ�����ϣ���Ϊÿ��׷��1�ľ��룩
 * ��������ڻ�·����ô����ָ��ľ���ֻ����Խ��ԽԶ����Զ��������
 * 
 * 2. �󻷵���ڵ�
 * ֤���� ����ʱ���ָ���߹�2s(fast = 2*slow), ��ָ���߹�s(slow)�� ���ڻ���r
 * �й�ʽ 2s = s + n*r (���ﳬȦ) =>��s = nr
 * ���б�ʼ������ڵ��λ��d1
 * �ӻ���ڵ㵽������ľ���d2
 * �б���l
 * s = d1 + d2
 * r = l - d1
 * �滻�õ� (d1+d2) = (n-1)r + (l-d1) => d1 = (n-1)r + (l-d1-d2)
 * �����ʽ�������˼�ǣ� ���б�ʼ����ڵ��λ�� = �����㵽��ڵ��λ��
 * (���ͣ� l-d1-d2=l-sΪ��ǰ�������λ�õ��б�β�ľ��룬�б�β�������ѭ�������б�ͷ)
 */

public class CycleInList {
	
	//������������
	public static Queue<Integer> queueWithCycle() {
		Queue<Integer> q = new Queue<Integer>(1,2,3,4,5,6,7,8,9);
		//�����һ��node.nextָ��3, ������Ŀ��Ҫ�����ݽṹ
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
			} catch(NullPointerException e) { //���û�л�����ֿ�ָ���쳣
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
			} catch(NullPointerException e) { //���û�л�����ֿ�ָ���쳣
				return result; //��ʱΪnull
			}
		} while(!slow.equals(fast));
		
		fast = q.first;
		do {
			try {
				slow = slow.next;
				fast = fast.next;
			} catch(NullPointerException e) { //��������ָ�������Ѿ��϶����ڻ����������һ�����������
				return result; //��ʱΪnull
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
