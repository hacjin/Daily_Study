package queue_linkedList_sort_etc_0808;

public class QueueTest {
	public static void main(String[] args) {
		Queue queue = new LinearQueue(3);
		queue.enQueue("icy");
		queue.enQueue("아이돌");
		queue.enQueue("안녕하세요");
		System.out.println(queue.isEmpty() + "//" + queue.isFull());
		System.out.println("peek : "+queue.peek());
		System.out.println("dequeue : "+queue.deQueue());
		System.out.println("dequeue : "+queue.deQueue());
		System.out.println("dequeue : "+queue.deQueue());
		System.out.println(queue.isEmpty()+"//"+queue.isFull());
	}
}
