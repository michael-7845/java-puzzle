package leetcode.linkedlist;

import static d.M.*;

/*
Given a sorted linked list, delete all duplicates such that each element appear only once.
For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesFromSortedList {
	public static void deduplicate(Queue<Integer> queue) {
		if(queue.first==null) return;
		Node<Integer> cur = queue.first,
				pre = cur;
		while(cur!=null) {
			if(cur.value != pre.value) {
				pre.next = cur;
				pre = cur;
			}
			cur = cur.next;
		}
		if(pre.next!=null)
			pre.next = null;
	}
	
	public static void deduplicate2(Queue<Integer> queue) {
		if((queue.first==null) || (queue.first.next==null)) return;
		Node<Integer> pre = queue.first, cur = pre.next;
		while(cur!=null) {
			if(pre.value==cur.value) {
				pre.next = cur.next;
				cur = cur.next;
			} else {
				pre = cur;
				cur = cur.next;
			}
		}
	}
	
	public static void deduplicate3(Queue<Integer> queue) {
		if(queue.first==null) return;
		Node<Integer> cur = queue.first;
		while((cur!=null)&&(cur.next!=null)) {
			if(cur.value == cur.next.value) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}
	}
	
	public static void demo() {
		Queue<Integer> q = new Queue<Integer>(1,1,2);
		p("1 ========");
		q.show();
		deduplicate3(q);
		q.show();
		
		q = new Queue<Integer>(1,1,2,3,3);
		p("2 ========");
		q.show();
		deduplicate3(q);
		q.show();
	}

	public static void main(String[] args) {
		demo();
	}

}
