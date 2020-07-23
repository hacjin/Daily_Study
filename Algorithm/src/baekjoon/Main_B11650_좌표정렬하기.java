package baekjoon;

import java.io.*;
import java.util.*;

public class Main_B11650_좌표정렬하기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0];
			}
		});
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			pq.add(new int[] {x,y});
		}
		while(!pq.isEmpty()) {
			int temp[] = pq.poll();
			System.out.println(temp[0]+" "+temp[1]);
		}
	}
}
