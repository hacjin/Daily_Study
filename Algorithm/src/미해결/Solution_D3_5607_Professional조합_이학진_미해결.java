package 미해결;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_5607_Professional조합_이학진_미해결 {
	static final int p = 1234567891;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
			long A=1;
			for (int i = 1; i <= N; i++) {		// N!
				A = (A*i)%p;
			}
			A %= p;
			long K=1;
			for (int i = 1; i <= R; i++) {		// K!
				K = (K*i)%p;
			}
			K %= p;
			long NK=1;
			for (int i = 1; i <= N-R; i++) {	// N-K!
				NK = (NK*i)%p;
			}
			NK %= p;
			
			int mod = p-2;
			long r=K;
			while(mod!=0) {
				if(mod%2>0) r = (r*K)%p;
				r *= r;
				r %= p;
				mod /= 2;
			}
			System.out.println("#"+t+" "+(A*(r%p))%p);
		}
	}
}
