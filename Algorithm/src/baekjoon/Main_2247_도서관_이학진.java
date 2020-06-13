package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2247_도서관_이학진 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		List<int[]> list = new LinkedList<int[]>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int arr[] = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
			list.add(arr);
		}

		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
			}
		});

		int se = list.get(0)[0];
		int pe = list.get(0)[1];
		int imax = pe - se;
		int omax = 0; 
		for (int i = 1; i < N; i++) {
			int as = list.get(i)[0];
			int ae = list.get(i)[1];
			if (as <= pe) {
				if(ae>pe) pe = ae;
				if(imax < pe - se) imax = pe - se;
			}else {
				if(omax < as-pe) omax = as-pe;
				se = as;
				pe = ae;
			}
		}
		System.out.println(imax+" "+omax);
	}
}
