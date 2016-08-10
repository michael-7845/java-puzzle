package leetcode.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

import static d.M.*;

/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */

public class MergeKSortedList {
	
	public static KNode merge(KNode[] lists) {
		if((lists==null) && (lists.length==0))
			return null;
		if(lists.length==1)
			return lists[0];
		
		PriorityQueue<KNode> queue = new PriorityQueue<KNode>(new Comparator<KNode>() {
			@Override
			public int compare(KNode x, KNode y) {
				return x.value-y.value;
			}
		});
		
		KNode header = new KNode(Integer.MIN_VALUE), result = header;
		for(KNode l: lists) {
			if(l!=null)
				queue.add(l);
		}
		
		while(!queue.isEmpty()) {
			result.next = queue.remove();
			result = result.next;
			if(result.next != null)
				queue.add(result.next);
		}
		
		return header.next;
	}
	
	public static void demo1() {
		KNode list1 = new KNode(1) {{
			add(new KNode(2)).add(new KNode(3)).add(new KNode(4));
		}};
		list1.showList();
		KNode list2 = new KNode(11) {{
			add(new KNode(12)).add(new KNode(13)).add(new KNode(14));
		}};
		list2.showList();
		KNode list3 = new KNode(21) {{
			add(new KNode(22)).add(new KNode(23)).add(new KNode(24));
		}};
		list3.showList();
		
		KNode result = merge(new KNode[]{list1, list2, list3});
		result.showList();
	}
	
	public static void demo2() {
		KNode list1 = new KNode(1) {{
			add(new KNode(5)).add(new KNode(11)).add(new KNode(17));
		}};
		list1.showList();
		KNode list2 = new KNode(3) {{
			add(new KNode(4)).add(new KNode(8)).add(new KNode(14)).add(new KNode(23));
		}};
		list2.showList();
		KNode list3 = new KNode(2) {{
			add(new KNode(12)).add(new KNode(13)).add(new KNode(19));
		}};
		list3.showList();
		
		KNode result = merge(new KNode[]{list1, list2, list3});
		result.showList();
	}

	public static void main(String[] args) {
		demo2();
	}

}

class KNode {
	int value;
	KNode next;
	KNode(int value) {
		this.value = value;
		this.next = null;
	}
	public String toString() {
		int nextValue = Integer.MIN_VALUE;
		if(next!=null)
			nextValue = next.value;
		return String.format("value: %d, next.value: %d", value, nextValue);
	}
	
	public KNode add(KNode next) {
		this.next = next;
		return this.next;
	}
	
	public void showList() {
		KNode cur = this;
		while(cur!=null) {
			p(cur);
			cur = cur.next;
		}
	}
}