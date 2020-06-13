package divide_etc_0807;

import java.util.LinkedList;
import java.util.Queue;

public class MyJJu {
	static int total = 20;
	static int my[] = new int[20];
	static Queue<Integer> que = new LinkedList<Integer>();
	public static void main(String[] args) {
		System.out.println("범인은?!!! : "+queue(1));
	}
	
	public static int queue(int start) {
		int tmp=0;
		while(true) {
			if(que.isEmpty()) {
				que.offer(start);
			} else {
				que.offer(tmp = que.poll());
				que.offer(start);
			}
			if(tmp!=0) {
				my[tmp]++;
				total = total - my[tmp];
			}
			if(total <=0 ) {
				return tmp;
			}
			start++;
		}
	}
	/*	public static int queue(int start) {
			int tmp=0;
			
			if(que.isEmpty()) {
				que.offer(start);
			} else {
				que.offer(tmp = que.poll());
				que.offer(start);
			}
			if(tmp!=0) {
				my[tmp]++;
				total = total - my[tmp];
			}
			if(total <=0 ) {return tmp;}
			
			return queue(start+1);
		} */
}
