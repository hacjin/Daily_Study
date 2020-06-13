package tree_0814;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedBinaryTree {
	private TreeNode root;
	private int size;
	
	public TreeNode getNode(TreeNode current, Object data) {
		if(current == null) return null;
		if(current.data.equals(data)) return current;
		
		TreeNode node = getNode(current.left, data);
		if(node == null) {
			node = getNode(current.right, data);
		}
		return node;
	}
	
	public void add(Object pdata, Object data) {
		TreeNode pNode = getNode(root,pdata);
		if(pNode==null && size==0) {
			root = pNode = new TreeNode(pdata);
			size++;
		}else if(pNode == null) { throw new RuntimeException("해당 데이터를 갖는 부모노드가 존재하지 않습니다."); }
		
		TreeNode newNode = new TreeNode(data);
		if(pNode.left==null) {
			pNode.left = newNode;
		}else if(pNode.right==null) {
			pNode.right = newNode;
		}else {
			throw new RuntimeException("부모노드에 자식노드가 꽉 차있습니다.");
		}
		size++;
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
		printTreeByInOrder(current.left);		//L
		System.out.print(current.data+" ");	//V
		printTreeByInOrder(current.right);		//R
	}
	public void printTreeByPostOrder() {
		printTreeByPostOrder(root);
		System.out.println();
	}
	private void printTreeByPostOrder(TreeNode current) {
		if(current==null) return;
		// LRV
		printTreeByPostOrder(current.left);		//L
		printTreeByPostOrder(current.right);		//R
		System.out.print(current.data+" ");	//V
	}
	
/*	public void printTreeByLevelOrder() {
		String sb[] = new String[(int)(Math.log(size+1)/Math.log(2))];
		for (int i = 0; i < sb.length; i++) {
			sb[i]="";
		}
		printTreeByLevelOrder(root,0,sb);
		for (int i = 0; i < sb.length; i++) {
			System.out.println(sb[i].toString());
		}
	}
	private void printTreeByLevelOrder(TreeNode current,int level,String sb[]) {
		if(current==null) return;
		
		sb[level] = sb[level]+current.data+" ";
		printTreeByLevelOrder(current.left,level+1,sb);
		printTreeByLevelOrder(current.right,level+1,sb);
		
	}*/
	
	public void printTreeByLevelOrder() {
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		que.offer(root);
		
		while(!que.isEmpty()) {
			int size = que.size();
			while(size-- > 0) {
				TreeNode current = que.poll();
				System.out.print(current.data+" ");
				if(current.left != null) que.offer(current.left);
				if(current.right != null) que.offer(current.right);
			}
			System.out.println();
		}
	}
}
