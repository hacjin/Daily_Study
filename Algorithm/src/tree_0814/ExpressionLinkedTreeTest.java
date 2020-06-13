package tree_0814;

public class ExpressionLinkedTreeTest {
	public static void main(String[] args) {
		ExpressionLinkedTree tree = new ExpressionLinkedTree("12*34-+");
		tree.printTreeByPreOrder();
		tree.printTreeByInOrder();
		tree.printTreeByPostOrder();
		
	}
}
