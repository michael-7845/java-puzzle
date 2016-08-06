package leetcode.linkedlist;

import static d.M.*;

/**
 * ����б���Ŀ���õĹ���
 * ��Ϊ�ǽ���Ĺ����࣬�ڲ����ݱ�¶����������Щ��Ŀ����
 * ���������ݷ�װ��
 * û������ֱ�ӷ���null���������쳣
 */
public class Stack<T> {
	
	public Node<T> top;
	
	public Stack() {
		this.top = null;
	}
	
	public Stack(T... values) {
		this();
		for(T v: values) {
			this.push(new Node<T>(v));
		}
	}
	
	/**
	 * @param s
	 * @return
	 * True: ������ȣ� ��ÿ��ֵ���
	 * False: �������
	 */
	@Override
	public boolean equals(Object s) {
		Node<T> cur = this.top;
		Node<T> cur2 = (Node<T>) ((Stack<T>)s).top;
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
		Node<T> cur = this.top;
		StringBuilder sb = new StringBuilder();
		while(cur!=null) {
			sb.append(String.valueOf(cur.value)).append("->");
			cur = cur.next;
		}
		return sb.toString();
	}
	
	public void push(Node<T> n) {
		n.next = this.top;
		this.top = n;
	}
	
	public void pushValue(T val) {
		this.push(new Node<T>(val));
	}
	
	public Node<T> pop() {
		Node<T> n = this.top;
		if(n != null) {
			this.top = n.next;
		}
		return n;
	}
	
	public Node<T> peek() {
		return this.top;
	}
	
	public static void demo() {
		Stack<Integer> s = new Stack<Integer>(1, 2);
		p(s);
		Stack<Integer> s2 = new Stack<Integer>(1, 2, 3);
		p(s2);
		p(s.equals(s2));
	}

	public static void main(String[] args) {
		demo();
	}

}
