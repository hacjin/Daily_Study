package queue_linkedList_sort_etc_0808;

public class Stack_LinkedList implements Stack {
	private class Node {
		int data;
		Node link;
		public Node(int data) {
			this.data = data;
		}
		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}
	}
	
	private Node top;
	
	public void push(int data) {
		Node newNode = new Node(data);
		if(top!=null) {
			Node lastNode = peek();
			lastNode.link = newNode;
		} else {
			top = newNode;
		}
	}
	
	public void pop() {
		Node delNode = peek();
		Node current = top;
		if(current != null) {
			while(current.link != null && current.link != delNode ) {
				current = current.link;
			}
			current.link = null;
			if(delNode==top) {
				top = null;
			}
		} else {
			current = null;
		}
	}
	
	private Node peek() {
		if(isEmpty()) {
			throw new RuntimeException("스택이 공백 상태입니다.");
		}
		Node current = top;
		if(current != null) {
			while(current.link !=null) {
				current = current.link;
			}
		}
		return current;
	}
	
	public boolean isEmpty() {
		return peek()==null;
	}
	
	public void print() {
		Node current = top;
		System.out.printf("L[ ");
		while(current != null ) {
			System.out.print(current.data+" ");
			current = current.link;
		}
		System.out.println("]\n");
	}
}
