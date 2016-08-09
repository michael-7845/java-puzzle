package leetcode.linkedlist;

//���ڽ��⣬��ʵ��Ϊ���͡��������Ժ���û�Ҫ��д���ͣ����ⲻ���㰡
public class DoubleNode {
	
	public int key;
	public int value;
	public DoubleNode pre;
	public DoubleNode next;
	
	public DoubleNode(int value) {
		this.value = value;
	}
	
	//ֵvalue��Ⱦ���Ϊ���
	public boolean equals(Object o) {
		DoubleNode n = (DoubleNode) o;
		if(this.value == n.value)
			return true;
		return false;
	}
		
	//������ͬ����Ϊ��ͬ
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
