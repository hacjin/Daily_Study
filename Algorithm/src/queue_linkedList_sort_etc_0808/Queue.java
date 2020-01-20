package queue_linkedList_sort_etc_0808;

public interface Queue {

	boolean isEmpty();

	boolean isFull();

	void enQueue(Object item);

	Object peek();

	Object deQueue();

}