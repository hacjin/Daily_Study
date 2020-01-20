package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_5672_올해의조련사_이학진 {
	static char ani[];
	static int N;
	static char result[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			ani = new char[N];
			result = new char[N];
			for (int i = 0; i < N; i++) {
				ani[i] = br.readLine().charAt(0);
			}
			int s = 0;
			int e = N-1;
			int index =0;
			char tmp;
			while(s<=e) {
				if(ani[s]>ani[e]) {
					tmp = ani[e];
					result[index] = tmp;
					e--;
				}else if(ani[s] < ani[e]) {
					tmp = ani[s];
					result[index] = tmp;
					s++;
				}else {
					int ts = s;
					int te = e;
					while(ani[ts]==ani[te]) {
						if(ts>te || ts==N-1 || te==0) break;
						ts++;
						te--;
					}
					if(ani[ts]>ani[te]) {
						tmp = ani[e];
						result[index] = tmp;
						e--;
					}else {
						tmp = ani[s];
						result[index] = tmp;
						s++;
					}
				}
				index++;
			}
			System.out.print("#"+t+" ");
			for (char cha : result) {
				System.out.print(cha);
			}
			System.out.println();
		}
	}
}
