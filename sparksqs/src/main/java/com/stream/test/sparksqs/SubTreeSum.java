package com.stream.test.sparksqs;

import java.util.HashMap;
import java.util.Map;

public class SubTreeSum {

	public static void main(String[] args) {
		// int[] array = new int[] { 7, 6, 5, 4, 3, 2, 1, 0, 8 };
		int[] array = new int[] { 5, 2, -5 };
		BNode tree = BTUtils.createBinaryTree(array, 0, null);
		BTUtils.printTree(tree);

	}

	static Map<Integer, Integer> cumSumMap = new HashMap<>();

	private static void subtreeSum(BNode tree) {
		if (isLeafNode(tree)) {
			cumsum(tree.value);
		}else {
			//wip
		}

	}

	private static boolean isLeafNode(BNode node) {
		return node.left == null && node.right == null;
	}

	private static void cumsum(int key) {
		Integer value = cumSumMap.putIfAbsent(key, 1);
		if (value != null) {
			cumSumMap.put(key, value + 1);
		}
	}
}
