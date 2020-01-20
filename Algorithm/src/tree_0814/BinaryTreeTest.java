package tree_0814;

public class BinaryTreeTest {
	public static void main(String[] args) {
		int size = 10;
		BinaryTree tree = new BinaryTree(size);
		for (int i = 0; i < 10; i++) {
			tree.add((char)(65+i));
		}
		tree.printTreeByPreOrder();
		tree.printTreeByInOrder();
		tree.printTreeByPostOrder();
		tree.printTreeByLevelOrder();
	}
}
