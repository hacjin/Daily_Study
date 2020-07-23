package baekjoon;

import java.io.*;
import java.util.*;
public class Main_B10814_나이순정렬 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Human> arr=  new ArrayList<Human>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			arr.add(new Human(age,name));
		}
		Collections.sort(arr,new Comparator<Human>() {
			@Override
			public int compare(Human o1, Human o2) {
				return o1.age-o2.age;
			}
		});
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.size(); i++) {
			Human cur = arr.get(i);
			sb.append(cur.age + " "+ cur.name+"\n");
		}
		System.out.println(sb.toString());
	}
	public static class Human {
		int age;
		String name;
		public Human(int age, String name) {
			this.age = age;
			this.name = name;
		}
	}
}
