package leetcode.linkedlist;

import static d.M.*;

public class Queue<T> {
	
	public Node<T> first, last;
	
	public Queue() {
		this.first = this.last = null;
	}
	
	public Queue(T... values) {
		this();
		for(T v: values) {
			this.add(new Node<T>(v));
		}
	}
	
	public void add(Node<T> n) {
		if(this.first == null) {
			this.first = this.last = n;
		} else {
			this.last.next = n;
			this.last = n;
		}
	}
	
	public void addValue(T val) {
		this.add(new Node<T>(val));
	}
	
	public Node<T> remove() {
		Node<T> n = null;
		//0��Ԫ��ʱ first == null, ��������nΪnull
		//ֻ��1��Ԫ��ʱ first == last == Ψһ��Ԫ�أ� ����ר�ſ���last�Ĵ�����		
		if(this.first != null){ 
			n = this.first;
			this.first = n.next;
		}
		return n;
	}
	
	public Node<T> element() {
		return this.first;
	}
	
	//Ԫ�ص���
	public void reverse() {
		if(this.first == null) return;
		
		Node<T> pre = this.first, cur = null;
		if(pre.next == null) {
			return;
		} else {
			cur = pre.next;
			pre.next = null;
		}
		
		while(cur != null) {
			Node<T> temp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = temp;
		}
		
		this.first = pre;
	}

	/**
	 * @param s
	 * @return
	 * True: ������ȣ� ��ÿ��ֵ���
	 * False: �������
	 */
	@Override
	public boolean equals(Object q) {
		Node<T> cur = this.first;
		Node<T> cur2 = (Node<T>) ((Queue<T>)q).first;
		while((cur != null) && (cur2 != null)) {
			if(cur.value == cur2.value) {
				cur = cur.next;
				cur2 = cur2.next;
			} else {
				return false;
			}
		}
		if( ((cur == null)&&(cur2 != null)) ||
			((cur != null)&&(cur2 == null))	) { //���Ȳ���
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		Node<T> cur = this.first;
		StringBuilder sb = new StringBuilder();
		while(cur!=null) {
			sb.append(String.valueOf(cur.value)).append("->");
			cur = cur.next;
		}
		return sb.toString();
	}
	
	public static void demo() {
		Queue<Integer> q = new Queue<Integer>(1, 2, 3);
		p(q);
		q.reverse();
		p(q);
	}
	
	public static void main(String[] args) {
		demo();
	}

}
