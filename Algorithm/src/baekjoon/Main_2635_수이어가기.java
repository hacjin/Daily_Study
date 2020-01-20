package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_2635_수이어가기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N;
		N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> tmp;
		int i = N;
		int maxcnt = 0;
		List<Integer> max = new ArrayList<Integer>();
		list.add(N);
		while(i>=0) {
			tmp = new ArrayList<Integer>();
			tmp.addAll(list);
			tmp.add(i);
			while(true) {
				int pre = tmp.get(tmp.size()-2);
				int cur = tmp.get(tmp.size()-1);
				if(pre-cur <0) {
					if(maxcnt < tmp.size()) {
						maxcnt = tmp.size();
						max = tmp;
					}
					break; 
				}
				else tmp.add(pre-cur);
			}
			i--;
		}
		
			System.out.println(maxcnt);
			for (int j = 0; j < maxcnt; j++) {
				System.out.print(max.get(j)+" ");
			}
		
	}
}
