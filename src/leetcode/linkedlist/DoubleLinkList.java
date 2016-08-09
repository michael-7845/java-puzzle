package leetcode.linkedlist;

import static d.M.*;

//一个双向链表的简单实现
public class DoubleLinkList {
	
	public DoubleNode header;
	
	public DoubleLinkList() {
		this.header = new DoubleNode(-1);
		this.header.next = this.header;
		this.header.pre = this.header;
	}
	
	public DoubleLinkList(int... values) {
		this();
		int n = -1;
		try {
			for(int i: values) {
				this.insert(n, new DoubleNode(i));
				n++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//插入
	public void insert(int n, DoubleNode dn) throws Exception {
		try {
			DoubleNode cur = getData(n);
			dn.next = cur.next;
			dn.pre = cur;
			cur.next.pre = dn;
			cur.next = dn;
		} catch(Exception e) {
			throw e;
		}
	}      

	//删除
    public DoubleNode delete(int n) throws Exception {
    	try {
			DoubleNode cur = getData(n);
			cur.pre.next = cur.next;
			cur.next.pre = cur.pre;
			return cur;
		} catch(Exception e) {
			throw e;
		}
    }

    //获取i元素: -1 表头; 元素从0开始技术
    public DoubleNode getData(int n) throws Exception {
    	if(n<0) return this.header;
    	DoubleNode cur = this.header.next;
		int i = 0;
		while((cur != this.header) && (i<n)) {
			cur = cur.next;
			i++;
		}
		if(i == n) { //有第n个元素(从0开始数)
			return cur;
		} else {
			throw new Exception(); //no nth element
		}
    }

    //表数据总数
    public int size() {
    	DoubleNode cur = this.header.next;
		int i = 0;
		while(cur != this.header) {
			cur = cur.next;
			i++;
		}
		return i;
    }

    //是否为空
    public boolean isEmpty() {
    	return (header==header.next);
    }
    
    public void show() {
    	DoubleNode cur = this.header.next;
		while(cur != this.header) {
			p(cur);
			cur = cur.next;
		}
    }
    
    public static void demo() throws Exception {
    	DoubleLinkList dll = new DoubleLinkList();
    	p(dll.isEmpty());
    	p(dll.size());
    	dll.insert(-1, new DoubleNode(1));
    	p(dll.isEmpty());
//    	p(dll.getData(0));
    	dll.insert(0, new DoubleNode(2));
//    	p(dll.getData(0));
//    	p(dll.getData(1));
    	dll.insert(1, new DoubleNode(3));
//    	p(dll.getData(0));
//    	p(dll.getData(1));
//    	p(dll.getData(2));
    	dll.show();
    	p(dll.size());
    	dll.delete(1);
    	dll.show();
    	p(dll.getData(0));
    	p(dll.getData(1));
    	
    	p("");
    	dll = new DoubleLinkList(1,2,3);
    	p(dll.getData(0));
    	p(dll.getData(1));
    	p(dll.getData(2));
    	dll.show();
    }

	public static void main(String[] args) throws Exception {
		demo();
	}

}
