package com.stream.test.sparksqs;

import java.util.Stack;

public class SubsetSumK {

	public static void main(String[] args) {
		SubsetSumK ssk = new SubsetSumK();
		int[] arr = new int[] { 5, -1, 8, 2, 7, 0 };
		int k = 7;
		ssk.subsetsum(arr, k);
		// Stack<Integer> stack = new Stack<>();
		// System.out.println(ssk.total(stack));
		// System.out.println(stack);
	}

	// subsetsum(arr, k) = counter = arr[0]; subsetsum(arr[1-N], k - counter)

	public void subsetsum(int[] arr, int k) {
		Stack<Integer> stack = new Stack<>();
		subsetsum(arr, 0, arr.length, k, stack);
	}

	int counter = 0;

	/**
	 * 
	 * Time-Complexity: O(2^N) i.e. Exponential
	 * 
	 * @param arr
	 * @param start
	 * @param end
	 * @param k
	 * @param stack
	 */
	private void subsetsum(int[] arr, int start, int end, int k, Stack<Integer> stack) {

		if (k == 0) {
			System.out.println(stack.toString());
			System.out.println(this.counter);
		}
		for (int idx = start; idx < end; idx++) {
			stack.push(arr[idx]);
			this.counter++;
			subsetsum(arr, idx + 1, end, k - arr[idx], stack);
			stack.pop();
		}

	}

	// private int total(Stack<Integer> stack) {
	// int sum = 0;
	// for (Integer integer : stack) {
	// sum += integer;
	// }
	// return sum;
	// }
}
