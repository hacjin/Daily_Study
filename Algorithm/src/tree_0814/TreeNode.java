package tree_0814;

public class TreeNode {
	public Object data;
	public TreeNode left,right;
	
	public TreeNode(Object data) {
		super();
		this.data = data;
	}

	public TreeNode(TreeNode left, Object data, TreeNode right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
}
