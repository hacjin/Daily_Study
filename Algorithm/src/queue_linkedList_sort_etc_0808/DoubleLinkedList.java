package queue_linkedList_sort_etc_0808;

public class DoubleLinkedList implements LinkedList {
	
	private class Node {
		Object data;
		Node l_link;
		Node r_link;
		
		public Node(Object data) {
			super();
			this.data = data;
		}
		public Node(Object data,Node l_link,Node r_link) {
			this(data);
			this.l_link = l_link;
			this.r_link = r_link;
		}
		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}
	}	// end class Node
	
	private Node head;	// 시작 노드
	
	private Node getLastNode() {
		Node current = head;
		if(current != null) {
			while(current.r_link != null) {
				current = current.r_link;
			}
		}
		return current;
	}
	public void addLastNode(Object data) {
		Node newNode = new Node(data);
		if(head == null) {		// 공백리스트
			head = newNode;
		} else {
			Node lastNode = getLastNode();
			lastNode.r_link = newNode;
			newNode.l_link = lastNode;
		}
	}
	public void addFirstNode(Object data) {
		Node newNode = new Node(data,null,head);
		if(head != null) {
			head.l_link = newNode;
		}
		head = newNode;
	}
	
	public void deleteFirstNode() {
		if(head == null) {throw new RuntimeException("공백 리스트여서 삭제가 불가능합니다.");}
		Node delNode = head;
		head = delNode.r_link;
		if(head!=null) {
			head.l_link = null;	// 2개에서 1개를 지우고 1개인 노드구성일 경우
		}
		delNode.r_link = null;
		
	}
	
	private Node getPreviousNode(Node target) {
		return target.l_link;
	}
	
	public void deleteLastNode() {
		if(head == null) {throw new RuntimeException("공백 리스트여서 삭제가 불가능합니다.");}
		Node delNode = getLastNode();
		Node preNode = getPreviousNode(delNode);
		if(preNode != null) {
			preNode.r_link = null;
		}else {
			head = null;
		}
		clearNode(delNode);
	}
	private void clearNode(Node node) {
		node.l_link = null;
		node.r_link = null;
	}
	
	public void print() { 
		Node current = head;
		System.out.printf("L[ ");
		while(current != null) {
			System.out.printf(" current data : "+current.data);
			current = current.r_link;
		}
		System.out.printf("]\n");
		
	}
}
