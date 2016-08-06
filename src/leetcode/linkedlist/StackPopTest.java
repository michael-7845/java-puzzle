package leetcode.linkedlist;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StackPopTest {
	
	Stack<Integer> input;
	Stack<Integer> expected;
	
	@Parameters
	public static Collection stacks() {
		return Arrays.asList(new Object[][] {
			{new Stack<Integer>(1, 2, 3), new Stack<Integer>(1, 2)},
			{new Stack<Integer>(1), new Stack<Integer>()},
			{new Stack<Integer>(1, 2, 3), new Stack<Integer>(1, 2, 3)},
		});
	}
	
	public StackPopTest(Stack<Integer> input, Stack<Integer> expected) {
		super();
		this.input = input;
		this.expected = expected;
	}

	@Test
	public void testPop() {
		input.pop();
		assertEquals(expected, input);
	}

	public static void main(String... args) { 
		Result result = JUnitCore.runClasses(StackPopTest.class);  
		for (Failure failure : result.getFailures()) {  
			System.out.println(failure.toString());  
		}  
		System.out.println(result.wasSuccessful());  
	}
}
