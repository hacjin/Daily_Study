package disjointSet_0828;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_D4_3124_최소스패닝트리_이학진 {
	static int parents[];
	static List<Integer[]> list;
	static Integer[] map;
	static long res;
	static int V,E;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			parents = new int[V+1];
			list = new ArrayList<Integer[]>();
			res=0;
			make();
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				map = new Integer[3];
				map[0]= Integer.parseInt(st.nextToken());
				map[1]= Integer.parseInt(st.nextToken());
				map[2]= Integer.parseInt(st.nextToken());
				list.add(map);
			}
			sort();
			int index=0;
			for (int i = 0; i < E; i++) {
				if(index == V-1) break;
				Integer[] tmp = list.get(i);
				if(union(tmp[0],tmp[1]))  { index++; res+=tmp[2]; }
			}
			System.out.println("#"+t+" "+res);
		}
	}
	private static void sort() {
		Collections.sort(list, new Comparator<Integer[]>() {
			public int compare(Integer[] o1, Integer[] o2) {
				int a = o1[2];
				int b = o2[2];
				return a-b;
			}
		} );
	}
	
	private static boolean union(int a, int b) {
		int ta = find(a);
		int tb = find(b);
		if(ta==tb) {
			return false;
		}
		parents[tb] = ta;
		return true;
	}
	private static int find(int a) {
		if(parents[a]<0) return a;
		return parents[a] = find(parents[a]);
	}
	private static void make() {
		Arrays.fill(parents, -1);
	}
}
