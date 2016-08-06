package leetcode.linkedlist;

public class Node<T> {

	public T value;
	public Node<T> next;
	
	public Node(T value) {
		this.value = value;
	}
	
	//ֵvalue��Ⱦ���Ϊ���
	public boolean equals(Object o) {
		Node<T> n = (Node<T>) o;
		if(this.value.equals(n.value))
			return true;
		return false;
	}
	
	//������ͬ����Ϊ��ͬ
	public boolean _equals(Object o) {
		return super.equals(o);
	}
	
	public String toString() {
		String v = value.toString();
		String n = null;
		if(next == null) {
			n = "null";
		} else {
			n = super.toString();
		}
		return String.format("value: %s, next: %s", v, n);
	}
	
	public static void demo() {
		Node<Integer> n1 = new Node<Integer>(1);
		Node<Integer> n2 = new Node<Integer>(1);
		n1.next = n2;
		System.out.println(n1.toString());
	}
	
	public static void main(String[] args) {
		demo();
	}

}
