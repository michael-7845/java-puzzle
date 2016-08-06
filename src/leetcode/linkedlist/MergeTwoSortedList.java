package leetcode.linkedlist;

import static d.M.*;

/*
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedList {
	
	public static Queue<Integer> merge(Queue<Integer> q1, Queue<Integer> q2) {
		Queue<Integer> result = new Queue<Integer>();
		Node<Integer> cur1 = q1.first, cur2 = q2.first;
		while((cur1!=null)||(cur2!=null)) {
			if((cur1!=null)&&(cur2!=null)) {
				if(cur1.value<cur2.value) {
					result.add(cur1);
					cur1 = cur1.next;
				} else {
					result.add(cur2);
					cur2 = cur2.next;
				}
			} else if(cur1==null) {
				result.last.next = cur2;
				result.last = q2.last;
				break;
			} else if(cur2==null) {
				result.last.next = cur1;
				result.last = q1.last;
				break;
			}
		}
		return result;
	}
	
	public static void demo() {
		p(merge(new Queue<Integer>(1,3,5,7,9,11), new Queue<Integer>(2,4,8)));
	}

	public static void main(String[] args) {
		demo();
	}

}
