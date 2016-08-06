package leetcode.linkedlist;

import static d.M.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * A linked list is given such that each node contains an additional random pointer, 
 * which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 */
public class CopyListWithRandomPointer {
	public static RandomList copy1(RandomList rl) {
		//复制每个节点并插入在原节点后
		RandomListNode cur = rl.first;
		while(cur != null) {
			RandomListNode aCopy = new RandomListNode(cur.value);
			aCopy.next = cur.next;
			cur.next = aCopy;
			cur = aCopy.next;
		}
		//更新新插入节点的random
		cur = rl.first;
		while(cur != null) {
			RandomListNode aCopy = cur.next;
			aCopy.random = cur.random.next;
			cur = aCopy.next;
		}
		//把新节点从链表中分离出来形成新的链表，这个就是我们希望的深拷贝
		RandomList rlCopy = new RandomList();
		cur = rl.first;
		while(cur!=null) {
			RandomListNode aCopy = cur.next;
			cur.next = aCopy.next;
			rlCopy.add(aCopy);
			cur = cur.next;
		}
		rl.last.next = null;
		rlCopy.last.next = null;
		return rlCopy;
	}
	
	public static void demo() {
		RandomList rl = new RandomList(1,2,3,4,5,6,7,8,9);
		RandomList rlCopy = copy1(rl);
		p("rl");
		rl.show();
		p("rlCopy");
		rlCopy.show();
	}
	
	public static RandomList copy2(RandomList rl) {
		Map<RandomListNode, RandomListNode> m = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode cur = rl.first;
		while(cur!=null) {
			RandomListNode aCopy = new RandomListNode(cur.value);
			m.put(cur, aCopy);
			cur = cur.next;
		}
		
		RandomList rlCopy = new RandomList();
		cur = rl.first;
		while(cur!=null) {
			RandomListNode aCopy = m.get(cur);
			aCopy.random = m.get(cur.random);
			rlCopy.add(aCopy);
			cur = cur.next;
		}
		
		return rlCopy;
	}
	
	public static void demo2() {
		RandomList rl = new RandomList(1,2,3,4,5,6,7,8,9,10);
		RandomList rlCopy = copy2(rl);
		p("rl");
		rl.show();
		p("rlCopy");
		rlCopy.show();
	}

	public static void main(String[] args) {
		demo();
	}
}

class RandomListNode {
	int value;
	RandomListNode next;
	RandomListNode random;
	public RandomListNode(int value) {
		this.value = value;
		this.next = this.random = null;
	}
	public String toString() {
		int me = this.hashCode(), next = 0, random = 0;
		
		if(this.next != null)
			next = this.next.hashCode();
		
		if(this.random != null) 
//			random = this.random.hashCode();
			random = this.random.value;
		
		return String.format("value: %2d, hash: %10d, next: %10d, random: %10d", this.value, me, next, random);
	}
}

class RandomList {
	RandomListNode first, last;
	int length;
	
	public RandomList() {
		this.first = this.last = null;
	}
	
	public RandomList(int... values) {
		this();
		for(int v: values) {
			this.add(new RandomListNode(v));
		}
		this.updateRandom();
	}
	
	public void add(RandomListNode n) {
		if(this.first == null) {
			this.first = this.last = n;
		} else {
			this.last.next = n;
			this.last = n;
		}
		this.length++;
	}
	
	public void addValue(int val) {
		this.add(new RandomListNode(val));
	}
	
	public RandomListNode remove() {
		RandomListNode n = null;
		//0个元素时 first == null, 不处理返回n为null
		//只有1个元素时 first == last == 唯一的元素， 不用专门考虑last的处理啦		
		if(this.first != null){ 
			n = this.first;
			this.first = n.next;
			this.length--;
		}
		return n;
	}
	
	public RandomListNode element() {
		return this.first;
	}
	
	private RandomListNode getNode(int n) {
		RandomListNode cur = this.first;
		if(n >= this.length) return null;
		for(int i=0; i<n; i++) {
			cur = cur.next;
		}
		return cur;
	}
	
	public void updateRandom() {
		Random r = new Random();
		RandomListNode cur = this.first;
		while(cur!=null) {
			cur.random = getNode(r.nextInt(this.length));
			cur = cur.next;
		}
	}
	
	//为了方便调试，我先把random改成有规律的
//	public void updateRandom() {
//		Random r = new Random();
//		RandomListNode cur = this.first;
//		int i= 0;
//		while(cur!=null) {
//			cur.random = getNode((i+2)%this.length);
//			cur = cur.next;
//			i++;
//		}
//	}
	
	public void show() {
		RandomListNode cur = this.first;
		while(cur!=null) {
			p(cur);
			cur = cur.next;
		}
	}
}