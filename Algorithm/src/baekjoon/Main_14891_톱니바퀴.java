package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14891_톱니바퀴 {
	static int RSIZE = 4,CSIZE=8,res=0; 
	static int ro[]; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String in;
		int wheel[][] = new int[RSIZE][CSIZE];
		int K,num,dir;
		
		for (int i = 0; i < RSIZE; i++) {
			in = br.readLine();
			for (int j = 0; j < CSIZE; j++) {
				wheel[i][j] = in.charAt(j)-'0';
			}
		}
		K = Integer.parseInt(br.readLine());
		
		for (int k = 0; k < K; k++) {
			ro = new int[RSIZE]; 
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken())-1;		// num-1 이 인덱스이기때문에
			dir = Integer.parseInt(st.nextToken());
			
			ro[num] = dir;
			
			for (int i = num; i < RSIZE-1; i++) {
				if(wheel[i][2]!=wheel[i+1][6]) {
					ro[i+1] = ro[i]*-1;
				}
			}
			for (int i = num; i > 0; i--) {
				if(wheel[i][6]!=wheel[i-1][2]) {
					ro[i-1] = ro[i]*-1;
				}
			}
			
			
			for (int i = 0; i < RSIZE; i++) {
				if(ro[i]==1) {
					right(wheel,i);
				}else if(ro[i]==-1){
					left(wheel,i);
				}
			}
		}
		
		for (int i = 0; i < RSIZE; i++) {
			if(wheel[i][0]==1) {
				res += (int)Math.pow(2, i);
			}
		}
		System.out.println(res);
	}
	private static void right(int [][]wheel,int i) {	// 시계 방향
		int tmp = wheel[i][CSIZE-1];
		for (int j = CSIZE-1; j > 0; j--) {
			wheel[i][j] = wheel[i][j-1];
		}
		wheel[i][0] = tmp;
		
	}
	private static void left(int [][]wheel,int i) {	// 반시계 방향
		int tmp = wheel[i][0];
		for (int j = 0; j < CSIZE-1; j++) {
			wheel[i][j] = wheel[i][j+1];
		}
		wheel[i][CSIZE-1] = tmp;
		
	}
}
