package baekjoon;

import java.io.*;
import java.util.*;

public class Main_B1181_단어정렬 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length()==o2.length()?o1.compareTo(o2):o1.length()-o2.length();
			}
		});
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			if(!pq.contains(input))	pq.add(input);
		}
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			sb.append(pq.poll()+"\n");
		}
		System.out.println(sb.toString());
	}
}
