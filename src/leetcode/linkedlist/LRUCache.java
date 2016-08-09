package leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

import static d.M.*;

public class LRUCache {
	
	int capacity;
	int size;
	Map<Integer, LRUNode> m;
	LRUNode first, last;
	
	public LRUCache(int capacity) {
		this.size = 0;
		this.capacity = capacity;
		this.m = new HashMap<Integer, LRUNode>();
		this.first = this.last = null;
	}
	
	public void setHead(LRUNode n) {
		n.next = first;
		n.pre = null;
		
		if(first != null) {
			first.pre = n;
		}
		first = n;
		
		if(last == null) {
			last = first;
		}
	}
	
	public void remove(LRUNode n) {
		if(n.pre != null) {
			n.pre.next = n.next;
		} else {
			first = n.next;
		}
		if(n.next != null) {
			n.next.pre = n.pre;
		} else {
			last = n.pre;
		}
	}
	
	public void set(int key, int value) {
		LRUNode n = null;
		if(m.containsKey(key)) {
			n = m.get(key);
			n.value = value;
			remove(n);
			setHead(n);
		} else {
			n = new LRUNode(key, value);
			if(m.size()>=capacity) {
				m.remove(last.key);
				remove(last);
				setHead(n);
			} else {
				setHead(n);
			}
			m.put(key, n);
		}
	}
	
	public LRUNode get(int key) {
		LRUNode n = null;
		if(m.containsKey(key)) {
			n = m.get(key);
			remove(n);
			setHead(n);
		}
		return n;
	}
	
	public void show() {
		LRUNode cur = first;
		while(cur != null) {
			p(cur);
			cur = cur.next;
		}
		d("map: "); p(m);
	}
	
	public static void demo() {
		LRUCache cache = new LRUCache(3);
		cache.set(0, 10);
		cache.set(1, 11);
		cache.set(2, 12);
		p("1 ======");
		cache.show();
		
		cache.set(3,  13);
		p("2 ======");
		cache.show();
		
		cache.get(2);
		p("3 ======");
		cache.show();
		
		cache.set(4, 14);
		cache.set(5, 15);
		p("4 ======");
		cache.show();
		
		cache.get(1);
		p("5 ======");
		cache.show();
	}

	public static void main(String[] args) {
		demo();
	}

}

class LRUNode {
	int key;
	int value;
	LRUNode pre;
	LRUNode next;
	public LRUNode(int key, int value) {
		this.key = key;
		this.value = value;
		this.pre = this.next = null;
	}
	public String toString() {
		int preKey = -1, nextKey = -1;
		if(pre!=null) preKey = pre.key;
		if(next!=null) nextKey = next.key;
		return String.format("key:%d, value:%d, pre.key:%d, next.key: %d",
				key, value, preKey, nextKey);
	}
}

