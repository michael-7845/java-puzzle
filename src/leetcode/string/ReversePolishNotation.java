package leetcode.string;

import java.util.Stack;

import static d.M.*;

/*
 Evaluate the value of an arithmetic expression in Reverse Polish Notation. 
 Valid operators are +, -, *, /. 
 Each operand may be an integer or another expression. For example:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */

public class ReversePolishNotation {
	
	public static int evaluate(String[] notation) {
		String op = "+-*/";
		Stack<String> stack = new Stack();
		
		for(String s: notation) {
			if(!op.contains(s)) { //number
				stack.push(s);
			} else { //operation
				int aVal = Integer.valueOf(stack.pop());
				int bVal = Integer.valueOf(stack.pop());
				int result = 0;
				switch(s) {
				case "+":
					result = bVal + aVal;
					break;
				case "-":
					result = bVal - aVal;
					break;
				case "*":
					result = bVal * aVal;
					break;
				case "/":
					result = bVal / aVal;
					break;
				}
				stack.push(String.valueOf(result));
			}
		}
		return Integer.valueOf(stack.pop());
	}
	
	public static void demo() {
		String[] notation = {"2", "1", "+", "3", "*"};
		p(evaluate(notation));
		String[] notation2 = {"4", "13", "5", "/", "+"};
		p(evaluate(notation2));
	}

	public static void main(String[] args) {
		demo();
	}

}
