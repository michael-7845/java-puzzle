package leetcode.linkedlist;

/*
Given a linked list and a value x, partition it 
such that all nodes less than x come before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.
For example, 
given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
 */
public class PartitionList {
	
	public static void partition(Queue<Integer> queue, Integer x) {
		Node<Integer> header1 = new Node<Integer>(Integer.MIN_VALUE), 
				cur1 = header1,
				header2 = new Node<Integer>(Integer.MAX_VALUE), 
				cur2 = header2, 
				cur = queue.first;
		//�õ�2����������
		while(cur!=null) {
			if(cur.value<x) {
				cur1.next = cur;
				cur1 = cur1.next;
			} else {
				cur2.next = cur;
				cur2 = cur2.next;
			}
			cur = cur.next;
		}
		//��֤cur2���һ��Ԫ��Ϊ��ĩβ��nextָ��null��
		cur2 = header2.next;
		while((cur2!=null) && (cur2.next!=null) && (cur2.next.value>=x)) {
			cur2 = cur2.next;
		}
		cur2.next = null;
		//������������
		cur1 = header1.next;
		while((cur1!=null) && (cur1.next!=null)) {
			cur1 = cur1.next;
		}
		cur1.next = header2.next;
		
		queue.first = header1.next; //Ϊ�˴�ӡ��ʾ��û���ٸ���last��ֻ��Ϊ�����⣬��Ӧ��queue��last���µ�
	}
	
	public static void partition2(Queue<Integer> queue, Integer x) {
		Node<Integer> header1 = new Node<Integer>(Integer.MIN_VALUE), 
				pre = header1,
				header2 = new Node<Integer>(Integer.MAX_VALUE), 
				cur2 = header2, 
				cur = queue.first;
		header1.next = cur;
		
		while(cur!=null) {
			if(cur.value<x) {
				pre = cur;
				cur = cur.next;
			} else {
				cur2.next = cur;
				cur2 = cur2.next;
				
				pre.next = cur.next;
				cur = cur.next;
			}
		}
		cur2.next = null;
		pre.next = header2.next;
	}
	
	public static void demo() {
		Queue<Integer> queue = new Queue<Integer>(1,4,3,2,5,2);
		queue.show();
		partition2(queue, 3);
		queue.show();
	}

	public static void main(String[] args) {
		demo();
	}

}
