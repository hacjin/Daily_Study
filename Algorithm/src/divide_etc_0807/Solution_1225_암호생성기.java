package divide_etc_0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1225_암호생성기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T,size;
		Queue<Integer> que;
		int minus;
		int tmp;
		
		
		for (int i = 1; i <= 10; i++) {
			que = new LinkedList<Integer>();
			T = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			size = st.countTokens();
			for (int j = 0; j < size; j++) {
				que.offer(Integer.parseInt(st.nextToken()));
			}
			minus = 1;
			while(true) {
				if(minus>5) {
					minus = 1;
				}
				tmp = que.poll()-minus++;
				if(tmp <= 0) {
					que.offer(0);
					break;
				}else {
					que.offer(tmp);	// 감소한 값을 다시 뒤로 넣어 준다.
				}
			}
			System.out.printf("#"+T+" ");
			for (Integer in : que) {
				System.out.printf("%d ",in);
			}
			System.out.println();
			
		}
	}
}
