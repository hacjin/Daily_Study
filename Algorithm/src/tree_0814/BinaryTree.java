package tree_0814;

// 배열을 이용한 완전이진트리
public class BinaryTree {		
	
	private Object[] tree;
	private int lastIndex;
	private final int SIZE;				
	private final int MAX_LEVEL;		// 트리 레벨 == 간선의 깊이
	
	
	public BinaryTree(int size) {
		SIZE = size;
		tree = new Object[size+1];	// 0 은 사용되지 않아서
		// size가 3일 경우 log4 ==> 2 -1 ==> 1인 높이
		MAX_LEVEL = (int)Math.ceil(Math.log(size+1)/Math.log(2))-1;		// ceil은 올림처리
		
	}
	public void add(Object e) {
		if(lastIndex==SIZE) throw new RuntimeException("포화상태입니다.");
		tree[++lastIndex] = e;
	}
	
	public void printTreeByPreOrder() {
		printTreeByPreOrder(1);
		System.out.println();
	}
	private void printTreeByPreOrder(int i) {
		if(i>lastIndex) return;
		// VLR
		System.out.print(tree[i]+" ");	//V
		printTreeByPreOrder(i*2);		//L
		printTreeByPreOrder(i*2+1);		//R
	}
	public void printTreeByInOrder() {
		printTreeByInOrder(1);
		System.out.println();
	}
	private void printTreeByInOrder(int i) {
		if(i>lastIndex) return;
		// LVR
		printTreeByInOrder(i*2);		//L
		System.out.print(tree[i]+" ");	//V
		printTreeByInOrder(i*2+1);		//R
	}
	public void printTreeByPostOrder() {
		printTreeByPostOrder(1);
		System.out.println();
	}
	private void printTreeByPostOrder(int i) {
		if(i>lastIndex) return;
		// LRV
		printTreeByPostOrder(i*2);		//L
		printTreeByPostOrder(i*2+1);		//R
		System.out.print(tree[i]+" ");	//V
	}
	
	public void printTreeByLevelOrder() {
		for (int i = 0; i <= MAX_LEVEL; i++) {
			int start = (int)Math.pow(2, i);
			int end = (int)(Math.pow(2, i+1)-1);
			for (int j = start; j<=lastIndex && j <= end; j++) {
				System.out.print(tree[j]+" ");
			}
			System.out.println();
		}
	}
}
