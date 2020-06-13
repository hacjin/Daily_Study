package queue_linkedList_sort_etc_0808;

public class LinkedListTest {
	public static void main(String[] args) {
		LinkedList list = new SimpleLinkedList();
		list.addFirstNode("금요일");
		list.print();
		list.addLastNode("월요일");
		list.print();
		list.addLastNode("목요일");
		list.print();
		list.deleteLastNode();
		list.print();
		list.deleteFirstNode();
		list.print();
		list.deleteFirstNode();
		list.print();
	}
}
