package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9205_맥주마시면서걸어가기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T,C;
		int cr[],cc[];
		int res=0;
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			C = Integer.parseInt(br.readLine());
			cr = new int[C+2];
			cc = new int[C+2];
			res=0;
			
			for (int i = 0; i < C+2; i++) {
				st = new StringTokenizer(br.readLine());
				cr[i] = Integer.parseInt(st.nextToken());
				cc[i] = Integer.parseInt(st.nextToken());
			}
			int dr=cr[0],dc=cc[0];
			for (int i = 1; i < C+2; i++) {
				dr = cr[i] - dr;
				dc = cc[i] - dc;
				if((dr+dc)/50 >20) {
					res++;
				}
				dr = cr[i];
				dc = cc[i];
			}
			
			if(res>0) {
				System.out.println("sad");
			}else {
				System.out.println("happy");
			}
		}
	}
}
