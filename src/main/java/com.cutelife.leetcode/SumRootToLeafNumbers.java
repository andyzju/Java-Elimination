package com.cutelife.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class SumRootToLeafNumbers {
	public int sumNumbers(TreeNode root) {
		int sum = 0;
		if (root == null)
			return sum;
		Stack<TreeNode> sta = new Stack<TreeNode>();
		// sta.push(root);
		TreeNode p = root;
		while (p != null || !sta.empty()) {

			while (p != null) {
				sta.push(p);
				p = p.left;
			}
			if (!sta.empty()) {
				p = sta.pop();
				p=p.right;
				if(p==null) {
					
					int temp = 0;
					TreeNode t;
					for(TreeNode node:sta){
						temp=temp*10+node.val;
					}

					sum += temp;
					// read stack and
					//sta.pop(); // stack pop()

				}

			}
		}
		return sum;
	}

	public Stack<TreeNode> getReverseStackCopy(Stack<TreeNode> sta) {

		Stack<TreeNode> staCopy = new Stack<TreeNode>();
		
		for(TreeNode node:sta){
			
		}
		
		return staCopy;
	}

	public static void main(String args[]) {
		TreeNode p1 = new TreeNode(1);
		TreeNode p2 = new TreeNode(2);
		TreeNode p3 = new TreeNode(3);
		p1.left = p2;
		p1.right = p3;
		p2.left = p2.right = null;
		p3.left = p3.right = null;

		System.out.println(new SumRootToLeafNumbers().sumNumbers(p1));
		
		/*Stack<Integer> s=new Stack<Integer>();
		s.push(1);
		s.push(2);
		s.push(3);
		for(Integer x:s){
			System.out.println(x);
		}*/

	}
}
