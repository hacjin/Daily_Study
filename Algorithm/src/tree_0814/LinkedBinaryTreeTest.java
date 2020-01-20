package tree_0814;

import java.util.Scanner;

public class LinkedBinaryTreeTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int edgecnt = sc.nextInt()-1;
		LinkedBinaryTree tree = new LinkedBinaryTree();
		while(edgecnt-- > 0) {
			tree.add(sc.nextInt(), sc.nextInt());
		}
		tree.printTreeByPreOrder();
		tree.printTreeByInOrder();
		tree.printTreeByPostOrder();
		tree.printTreeByLevelOrder();
	}
}
