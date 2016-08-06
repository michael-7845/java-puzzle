package leetcode.linkedlist;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueTest {
	
	@Test
	public void testEqualsObject() {
		Queue<Integer> q1 = new Queue<Integer>(1, 2, 3);
		Queue<Integer> q2 = new Queue<Integer>(1, 2, 3);
		Queue<Integer> q3 = new Queue<Integer>(1, 2, 3);
		Queue<Integer> q4 = new Queue<Integer>(1, 2);
		Queue<Integer> q5 = new Queue<Integer>(1, 3);
		
		//自反性,传递性,对称性
		assertTrue(q1.equals(q1));
		assertTrue(q1.equals(q2));
		assertTrue(q2.equals(q1));
		assertTrue(q2.equals(q3));
		assertTrue(q1.equals(q3));
		
		assertFalse(q1.equals(q4));
		assertFalse(q1.equals(q5));
		assertFalse(q4.equals(q5));
	}

	@Test
	public void testToString() {
		Queue<Integer> q = new Queue<Integer>(1, 2, 3);
		assertEquals("1->2->3->", q.toString());
	}

	@Test
	public void testAdd() {
		Queue<Integer> q = new Queue<Integer>(1, 2, 3);
		q.add(new Node<Integer>(4));
		assertEquals(new Queue<Integer>(1,2,3,4), q);
		q.addValue(5);
		assertEquals(new Queue<Integer>(1,2,3,4,5), q);
	}

	@Test
	public void testRemove() {
		Queue<Integer> q = new Queue<Integer>(1, 2, 3);
		Node<Integer> value = q.remove();
		assertEquals(new Node<Integer>(1), value);
		assertEquals(new Queue<Integer>(2,3), q);
	}

	@Test
	public void testElement() {
		Queue<Integer> q = new Queue<Integer>(1, 2, 3);
		Node<Integer> value = q.element();
		assertEquals(new Node<Integer>(1), value);
		assertEquals(new Queue<Integer>(1,2,3), q);
	}
	
	@Test
	public void testReverse() {
		Queue<Integer> q = new Queue<Integer>(1, 2, 3);
		q.reverse();
		assertEquals(new Queue<Integer>(3,2,1), q);
	}

}
