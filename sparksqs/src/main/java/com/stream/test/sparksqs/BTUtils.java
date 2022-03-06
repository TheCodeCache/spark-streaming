package com.stream.test.sparksqs;

public class BTUtils {

	public static BNode createBinaryTree(int[] array, int index, BNode bnode) {

		if (index < array.length) {
			bnode = new BNode(array[index]);
			/*
			 * bnode.left = new BNode(array[index]); index += 1; bnode.right = new
			 * BNode(array[index]);
			 */

			BNode left = createBinaryTree(array, 2 * index + 1, bnode.left);
			BNode right = createBinaryTree(array, 2 * index + 2, bnode.right);

			bnode.left = left;
			bnode.right = right;
		}

		return bnode;
	}

	/*
	 * if (index < array.length) { BNode temp = new BNode(array[index]); bnode =
	 * temp;
	 * 
	 * bnode.left = createBinaryTree(array, 2 * index + 1, bnode.left); bnode.right
	 * = createBinaryTree(array, 2 * index + 2, bnode.right); }
	 * 
	 * return bnode;
	 */

	private static void printBT(BNode bnode, int level, boolean left, int height, int count, int index) {

		if (bnode == null) {
			System.out.print("  ");
			return;
		}
		if (level == 1) {
			System.out.print(bnode.value);
			if (left) {
				int num = pow(2, height - count - 1) - 1;
				System.out.print(spaces(num, ""));
			}
			if (!left) {
				if (index < count) {
					int num = pow(2, height - count - 1) - 1;
					System.out.print(spaces(num, ""));
				}
			}
		} else {
			// System.out.print(line + "::");
			count += 1;
			printBT(bnode.left, level - 1, true, height, count, index);
			// System.out.print(line + "::");
			printBT(bnode.right, level - 1, false, height, count, index + 1);
		}
	}

	public static String spaces(int level, String single) {
		StringBuilder builder = new StringBuilder();
		String tab = " ";
		for (int i = 0; i < level; i++) {
			builder.append(tab);
		}
		builder.append(single);
		return builder.toString();
	}

	public static void main(String[] args) {

		int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
				0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4,
				5, 6, 7, 8 };

		// int[] array = new int[] { 7, 6, 5, 4, 3, 2, 1, 0, 8 };
		BNode bnode = null;
		BNode tree = createBinaryTree(array, 0, bnode);
		printTree(tree);
		System.out.println("total nodes: " + count(tree));

	}

	public static void printTree(BNode tree) {

		/*
		 * Use this formula and calculate the log base 2 :
		 * 
		 * log(a) b = log(10) b / log(10) a
		 */
		int height = (int) Math.ceil(Math.log10(count(tree)) / Math.log10(2)) + 1;

		for (int level = 1; level < height; level++) {
			int num = pow(2, height - 1 - level) - 1;
			System.out.print(spaces(num, ""));
			printBT(tree, level, false, height + 1, 1, 1);
			System.out.print(spaces(num, ""));
			System.out.println();
		}
	}

	public static int pow(int base, int index) {
		int sum = 1;
		for (int i = 1; i <= index; i++) {
			sum *= base;
		}
		return sum;
	}

	public static int count(BNode tree) {
		if (tree == null)
			return 0;
		return 1 + count(tree.left) + count(tree.right);
	}
}
