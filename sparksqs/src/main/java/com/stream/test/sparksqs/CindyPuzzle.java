package com.stream.test.sparksqs;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://www.cis.upenn.edu/~matuszek/cit596-2012/NewPages/backtracking.html
 * 
 * Assumption:
 * 
 * 1 represents black ball, 0 represents white ball, -1 represents blank space
 * 
 * not a dynamic soln,
 * 
 * and so, off course, we can generalize it but the idea remains the same
 * 
 * @author manoranjan.kumar
 */
public class CindyPuzzle {

	public static void main(String[] args) {

		int[] arr = new int[] { 1, 1, -1, 0, 0 };
		// int[] arr = new int[] { 0, 1, -1, 0, 1 };
		// int[] arr = new int[] { 0, 0, -1, 1, 1 };
		// int[] arr = new int[] { -1, 0, 1, 1, 0 };
		// int[] arr = new int[] { 0, -1, 1, 0, 1 };
		// System.out.println(isSolved(arr));
		// System.out.println(isSolvable(arr));
		solve(arr, new Stack<String>());
	}

	public static void solve(int[] arr, Stack<String> stack) {
		if (isSolved(arr)) {
			System.out.println(stack);
			return;
		}
		if (!isSolvable(arr)) {
			return;
		}
		int[] arr2 = moveBlack(arr, stack);
		if (!Arrays.equals(arr2, arr)) {
			solve(arr2, stack);
			if (!stack.isEmpty())
				stack.pop();
		}
		int[] arr3 = moveWhite(arr, stack);
		if (!Arrays.equals(arr3, arr)) {
			solve(arr3, stack);
			if (!stack.isEmpty())
				stack.pop();
		}
	}

	private static int[] moveBlack(int[] arr2, Stack<String> stack) {
		int[] arr = Arrays.copyOf(arr2, arr2.length);
		int temp = -2;
		for (int idx = 0; idx < arr.length; idx++) {
			if (arr[idx] == 1) {
				if (idx + 1 < arr.length && arr[idx + 1] == -1) {
					temp = arr[idx];
					arr[idx] = arr[idx + 1];
					arr[idx + 1] = temp;
					// capture the move
					stack.push("move black " + idx + " ahead");
					return arr;
				} else if (idx + 2 < arr.length && arr[idx + 1] == 0 && arr[idx + 2] == -1) {
					temp = arr[idx];
					arr[idx] = arr[idx + 2];
					arr[idx + 2] = temp;
					// capture the move
					stack.push("move black " + idx + " ahead");
					return arr;
				}
			}
		}
		return arr;
	}

	private static int[] moveWhite(int[] arr2, Stack<String> stack) {
		// this deep copy is super critical, o'wise at every step it will end up working
		// on the same object in the same memory space,which is not desirable
		int[] arr = Arrays.copyOf(arr2, arr2.length);

		int temp = -2;
		for (int idx = 0; idx < arr.length; idx++) {
			if (arr[idx] == 0) {
				if (idx - 1 >= 0 && arr[idx - 1] == -1) {
					temp = arr[idx];
					arr[idx] = arr[idx - 1];
					arr[idx - 1] = temp;
					// capture the move
					stack.push("move white " + idx + " ahead");
					return arr;
				} else if (idx - 2 >= 0 && arr[idx - 1] == 1 && arr[idx - 2] == -1) {
					temp = arr[idx];
					arr[idx] = arr[idx - 2];
					arr[idx - 2] = temp;
					// capture the move
					stack.push("move white " + idx + " ahead");
					return arr;
				}
			}
		}
		return arr;
	}

	static int[] temp = { 0, -1, 1 };

	/**
	 * This checks whether the given puzzle is solved or not
	 * 
	 * @param arr
	 * @return
	 */
	private static boolean isSolved(int[] arr) {
		int i = 0;
		for (int piece : arr) {
			if (piece == temp[i])
				continue;
			i++;
			if (i > 2)
				return false;
			if (!(piece == temp[i]))
				return false;
		}
		return true;
	}

	/**
	 * At every step, this checks whether the current puzzle is solvable or not
	 * 
	 * @param arr
	 * @return
	 */
	private static boolean isSolvable(int[] arr) {
		int prev1 = -2, prev2 = -2, next1 = -2, next2 = -2;
		for (int idx = 0; idx < arr.length; idx++) {
			int piece = arr[idx];
			switch (piece) {
			case 0: // white
				if (idx > 0)
					prev1 = arr[idx - 1];
				if (idx > 1)
					prev2 = arr[idx - 2];
				if ((prev1 == 1 && prev2 == -1) || prev1 == -1) {
					return true;
				}
				break;
			case 1: // black
				if (idx + 1 < arr.length)
					next1 = arr[idx + 1];
				if (idx + 2 < arr.length)
					next2 = arr[idx + 2];
				if ((next1 == 0 && next2 == -1) || next1 == -1) {
					return true;
				}
				break;
			case -1:
				continue;
			}
		}

		return false;
	}
}
