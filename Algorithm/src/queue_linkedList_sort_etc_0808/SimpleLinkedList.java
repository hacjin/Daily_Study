package queue_linkedList_sort_etc_0808;

public class SimpleLinkedList implements LinkedList {
	
	private class Node {
		Object data;
		Node link;
		public Node(Object data) {
			super();
			this.data = data;
		}
		public Node(Object data,Node link) {
			this(data);
			this.link = link;
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
			while(current.link != null) {
				current = current.link;
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
			lastNode.link = newNode;
		}
	}
	public void addFirstNode(Object data) {
		Node newNode = new Node(data,head);
		head = newNode;
	}
	
	public void deleteFirstNode() {
		if(head == null) {throw new RuntimeException("공백 리스트여서 삭제가 불가능합니다.");}
		Node delNode = head;
		head = delNode.link;
		delNode.link = null;
		
	}
	
	private Node getPreviousNode(Node target) {
		Node current = head;
		if(current != null) {
			// current.link == null 인 경우는 1개짜리 노드
			while(current.link != null && current.link != target) {
				current = current.link;
			}
			if(current.link != null) {
				return current;
			}
		}
		return null;
	}
	
	public void deleteLastNode() {
		if(head == null) {throw new RuntimeException("공백 리스트여서 삭제가 불가능합니다.");}
		Node delNode = getLastNode();
		Node preNode = getPreviousNode(delNode);
		if(preNode != null) {
			preNode.link = null;
		}else {
			head = null;
		}
	}
	
	public void print() { 
		Node current = head;
		System.out.printf("L[ ");
		while(current != null) {
			System.out.printf(current.data+" ");
			current = current.link;
		}
		System.out.printf("]\n");
		
	}
}
