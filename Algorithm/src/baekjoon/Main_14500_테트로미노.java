package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14500_테트로미노 {
	static int tet[][][] = { {	{0,0},{0,1},{0,2},{0,3} },	//		0 : 긴 막대  
			{ {0,0},{0,1}					//		1 : 네모
		   	 ,{1,0},{1,1} },				
			  { {0,0},
				{1,0},
				{2,0},{2,1} },				//		2 : ㄴ 자
			  { {0,0},
				{1,0},{1,1},
				      {2,1} },				//		3 : 번개 자
			{ {0,0},{0,1},{0,2},			//		4 : ㅜ
					{1,1}	}
	};	
	static int N,M;		// N : 행	M : 열
	static int data[][];
	static int max = 0;
	static int Mhap=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;		
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new int[N][M];
//		tet[] 0~4 모양 [] 폴리오미노 갯수 [] 좌표
//		0 : 긴 막대  1 : 네모  2 : ㄴ  3 : 번개  4: ㅜ
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ud = 2;		// 상하 반전 index
		int ro = 4; 	// 90 반전 index
		for (int i = 0; i < ud; i++) {
			for (int j = 0; j < ro; j++) {
				equal();
				rotate();
			}
			updown();
		}
		
		System.out.println(max);
	}
	// 90도 로테시
	public static void rotate() {
		int tmp;
		for (int i = 0; i < 5; i++) {
			for (int r = 0; r < 4; r++) {
					tmp = tet[i][r][0];
					tet[i][r][0] = tet[i][r][1];
					tet[i][r][1] = tmp*-1;
			}
		}
	}
	public static void updown() {
		int tmp;
		for (int i = 0; i < 5; i++) {
			for (int r = 0; r < 4; r++) {
					tmp = tet[i][r][0];
					tet[i][r][0] = tet[i][r][1];
					tet[i][r][1] = tmp;
			}
			
		}
	}
	public static void equal() {
		int nr, nc;
		
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < M; y++) {
				for (int i = 0; i < 5; i++) {
					Mhap = 0;
					nr = 0;
					nc = 0;
					for (int r = 0; r < 4; r++) {
						nr = x + tet[i][r][0];
						nc = y + tet[i][r][1];
						if(nr>=0 && nr < N && nc>=0 && nc<M) {
							Mhap = Mhap  + data[nr][nc];
							if(Mhap>max) {
								max = Mhap;
							}
						}
						else {
							break;
						}
					}
				}
			}
		}
	}
}
