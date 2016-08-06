package leetcode.linkedlist;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class NodeTest {

	@Test
	public void testEqualsObject() {
		Node<Integer> n1 = new Node<Integer>(1);
		Node<Integer> n2 = new Node<Integer>(1);
		Node<Integer> n3 = new Node<Integer>(1);
		Node<Integer> n4 = new Node<Integer>(2);
		
		//自反性,传递性,对称性
		assertTrue(n1.equals(n1));
		assertTrue(n1.equals(n2));
		assertTrue(n2.equals(n1));
		assertTrue(n2.equals(n3));
		assertTrue(n1.equals(n3));
		assertFalse(n1.equals(n4));
	}

	@Test
	public void testToString() {
		Node<Integer> n1 = new Node<Integer>(1);
		assertThat(n1.toString(), is("value: 1, next: null"));
		Node<Integer> n2 = new Node<Integer>(1);
		n1.next = n2;
		assertThat(n1.toString(), 
				containsString("value: 1, next: leetcode.linkedlist.Node@"));
		
	}

}
