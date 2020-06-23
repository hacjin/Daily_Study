package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_18428_감시피하기 {
	public static class Teacher {
		int r;
		int c;

		Teacher(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N;
	static char[][] map;
	static List<Teacher> T;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상, 하, 좌, 우
	static String answer = "NO";

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		T = new ArrayList<Teacher>();
		// 1. 선생님의 위치를 List에 저장
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if (map[i][j] == 'T')
					T.add(new Teacher(i, j));
			}
		}
		// 0,0에서 시작하여 가림막 0개부터 시작
		count(0, 0);
		System.out.println(answer);
	}

	private static void count(int r, int cnt) {
		
		// 3번의 가림막이 설치되고 나서 선생님을 기준으로 학생들이 보이는 지 확인
		if(cnt == 3) {
			boolean chk = true;
		rotate: for (int i = 0; i < T.size(); i++) {
				Teacher curT = T.get(i);
				for (int d = 0; d < dir.length; d++) {
					int cr = curT.r + dir[d][0];
					int cc = curT.c + dir[d][1];
					while(cr>= 0 && cc >=0 && cr < N && cc <N) {
						if(map[cr][cc]=='S') { chk = false; break rotate;}
						else if(map[cr][cc]=='O' && chk) { break; }
						cr += dir[d][0];
						cc += dir[d][1];
					}
				}
			}
			if(chk) answer = "YES";
			return;
		}
		// N-1 에서 발견 되고 N으로 넘어오는 범위에서 cnt==3인경우 체크 후 리턴해줘야한다.
		if( answer.equals("YES")) return;
		
		// 6 x 6 맥스 36C3 경우의 수 이므로 가능
		for (int i = r; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 'X') {
					// X인 지역을 가림막 O로 지정하여 체크
					map[i][j] = 'O';
					count(i,cnt+1);
					map[i][j] = 'X';
				}
			}
		}
	}
}
