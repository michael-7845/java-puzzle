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
		//0个元素时 first == null, 不处理返回n为null
		//只有1个元素时 first == last == 唯一的元素， 不用专门考虑last的处理啦		
		if(this.first != null){ 
			n = this.first;
			this.first = n.next;
		}
		return n;
	}
	
	public Node<T> element() {
		return this.first;
	}
	
	//元素倒序
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
	 * True: 长度相等， 且每个值相等
	 * False: 其他情况
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
			((cur != null)&&(cur2 == null))	) { //长度不等
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
