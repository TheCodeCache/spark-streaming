package com.stream.test.sparksqs;

import java.util.Stack;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		App app = new App();
		System.out.println(app.substring("abcd", 'a'));
		app.permute("abcd");
		Stack<Character> stack = new Stack<>();
		// stack.push('a');
		// stack.push('b');
		// stack.push('c');
		// stack.push('d');
		// System.out.println(stack.toString());
	}

	// P(abcd) = aP(bcd) + bP(acd) + cP(abd) + dP(abc)
	// P(bcd) = bP(cd) + cP(bd) + dP(bc)
	// P(cd) = cP(d) + dP(c)
	// cd + dc
	// bcd + bdc
	// abcd + abdc

	public void permute(String string) {
		Stack<Character> stack = new Stack<>();
		permute(string, stack);
	}

	/**
	 * Backtracking
	 * 
	 * this works in all 3 possible approaches:
	 * 
	 * 1. if with no return but else
	 * 
	 * 2. if with return but no else
	 * 
	 * 3. neither return nor else but only if
	 * 
	 * @param string
	 * @param stack
	 */
	private void permute(String string, Stack<Character> stack) {

		if (string.length() == 1) {
			stack.push(string.charAt(0));
			System.out.println(stack.toString());
			stack.pop();
			// return;
		} else {
			for (char ch : string.toCharArray()) {
				stack.push(ch); // PUSH 'c'
				// permute with 'd', this 'd' will be pushed and immediately be popped in the
				// base case condition
				permute(substring(string, ch), stack);
				stack.pop(); // POP 'c', only then we'd be able to push 'd' and permute with 'c'
			}
		}
	}

	private String substring(String string, char ch) {
		StringBuilder builder = new StringBuilder();
		for (char che : string.toCharArray()) {
			if (che == ch)
				continue;
			builder.append(che);
		}
		return builder.toString();
	}
}
