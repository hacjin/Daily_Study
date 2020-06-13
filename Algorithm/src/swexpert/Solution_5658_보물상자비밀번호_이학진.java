package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_5658_보물상자비밀번호_이학진 {
	static int N;
	static char pass[];
	static List<Integer> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int K;
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			pass = new char[N];
			String str = br.readLine();
			pass = str.toCharArray();
			list = new ArrayList<Integer>();
			
			for (int i = 0; i < N; i++) {
				int count=0;
				int j = i;
				String tmp="";
				while(count!=N) {
					if(j==N) j=0;
					if((j-i)!=0 && (j-i)%(N/4)==0) {
						int tmint = Integer.parseInt(tmp,16);
						if(!list.contains(tmint)) list.add(tmint);
						tmp="";
					}
					tmp += pass[j];
					j++;
					count++;
				}
			}
			Collections.sort(list, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2-o1;
				}
			});
			System.out.println("#"+t+" "+list.get(K-1));
		}
	}
}