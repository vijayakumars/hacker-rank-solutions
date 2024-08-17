package com.hacker.rank.solutions;

import java.util.Scanner;

class TreePostorderTraversalNode {
	TreePostorderTraversalNode left;
	TreePostorderTraversalNode right;
	int data;

	TreePostorderTraversalNode(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class TreePostorderTraversal {

	/*
	 * you only have to complete the function given below. Node is defined as
	 * 
	 * class Node { int data; Node left; Node right; }
	 * 
	 */

	public static void postOrder(TreePostorderTraversalNode root) {
		if (root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}

	public static TreePostorderTraversalNode insert(
			TreePostorderTraversalNode root, int data) {
		if (root == null) {
			return new TreePostorderTraversalNode(data);
		} else {
			TreePostorderTraversalNode cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		TreePostorderTraversalNode root = null;
		while (t-- > 0) {
			int data = scan.nextInt();
			root = insert(root, data);
		}
		scan.close();
		postOrder(root);
	}
}
