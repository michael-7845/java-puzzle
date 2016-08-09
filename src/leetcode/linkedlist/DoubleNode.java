package leetcode.linkedlist;

//用于解题，不实现为泛型——泛型以后调用还要多写类型，解题不方便啊
public class DoubleNode {
	
	public int key;
	public int value;
	public DoubleNode pre;
	public DoubleNode next;
	
	public DoubleNode(int value) {
		this.value = value;
	}
	
	//值value相等就认为相等
	public boolean equals(Object o) {
		DoubleNode n = (DoubleNode) o;
		if(this.value == n.value)
			return true;
		return false;
	}
		
	//引用相同则认为相同
	public boolean _equals(Object o) {
		return super.equals(o);
	}
		
	public String toString() {
		String n = "null";
		if(next != null) {
//			n = super.toString();
			n = Integer.toString(next.value);
		}
		
		String p = "null";
		if(pre != null) {
			p = Integer.toString(pre.value);
		}
		
		return String.format("key: %4d, value: %4d, pre.value: %4s, next.value: %4s", key, value, p, n);
	}
		
	public static void demo() {
		DoubleNode n1 = new DoubleNode(1);
		DoubleNode n2 = new DoubleNode(2);
		DoubleNode n3 = new DoubleNode(3);
		n2.next = n3;
		n2.pre = n1;
		System.out.println(n2.toString());
		n1.next = n2;
		System.out.println(n1.toString());
		n3.pre = n2;
		System.out.println(n3.toString());
	}

	public static void main(String[] args) {
		demo();
	}

}
