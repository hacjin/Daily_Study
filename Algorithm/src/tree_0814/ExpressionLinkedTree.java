package tree_0814;

import java.util.Stack;

public class ExpressionLinkedTree {
	private TreeNode root;
	
	public ExpressionLinkedTree(String postExpression) {
		makeTree(postExpression);
	}
	public void makeTree(String postExpression) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		int length = postExpression.length();
		for (int i = 0; i < length; i++) {
			char c = postExpression.charAt(i);
			TreeNode node = new TreeNode(c);
			switch(c) {
			case '+':case '-':case '*':case '/':
				node.right = stack.pop();
				node.left = stack.pop();
				break;
			}
			stack.push(node);
		}
		root = stack.pop();
	}
	
	public void printTreeByPreOrder() {
		printTreeByPreOrder(root);
		System.out.println();
	}
	private void printTreeByPreOrder(TreeNode current) {
		if(current==null) return;
		// VLR
		System.out.print(current.data+" ");	//V
		printTreeByPreOrder(current.left);		//L
		printTreeByPreOrder(current.right);		//R
	}
	public void printTreeByInOrder() {
		printTreeByInOrder(root);
		System.out.println();
	}
	private void printTreeByInOrder(TreeNode current) {
		if(current==null) return;
		// LVR
		printTreeByPreOrder(current.left);		//L
		System.out.print(current.data+" ");	//V
		printTreeByPreOrder(current.right);		//R
	}
	public void printTreeByPostOrder() {
		printTreeByPostOrder(root);
		System.out.println();
	}
	private void printTreeByPostOrder(TreeNode current) {
		if(current==null) return;
		// LRV
		printTreeByPreOrder(current.left);		//L
		printTreeByPreOrder(current.right);		//R
		System.out.print(current.data+" ");	//V
	}
}
