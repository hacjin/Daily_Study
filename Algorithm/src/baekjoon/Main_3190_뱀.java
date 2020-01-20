package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 *
 *  뱀의 꼬리부분을 저장 하고 지우는과정 에서 오류 ... 수정 필요
 *
 */
public class Main_3190_뱀 {
	static int sr = 0, sc = 0, dis = 3; // 뱀 시작지점 // 시작 방향 우 : 3
	static int nr = sr, nc = sc; // 이동 지점이므로 시작점으로 초기화
	static int map[][]; // 사과 존재시 2// 이동 시 1
	static int dir[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상 :0 하 :1 좌 :2 우 :3
	static int snake[][] = {{0,0}};		// 뱀 꼬리 위치 0,0
	static int index;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N, K; // 보드 크기 N // 사과 갯수 K

		int cdir; // 방황 변환 횟수.
		int limitT[]; // 부여된 시간
		char d[]; // 부여된 방향

		N = Integer.parseInt(br.readLine()); // 크기 입력
		K = Integer.parseInt(br.readLine()); // 사과 갯수

		map = new int[N][N];
		map[0][0] = 1;
		
		for (int i = 0; i < K; i++) { // 입력 받은 사과 좌표에 2를 할당
			st = new StringTokenizer(br.readLine(), " ");
			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 2;
		}

		cdir = Integer.parseInt(br.readLine()); // 방향 변환 횟수
		limitT = new int[cdir]; // 횟수만큼의 시간 배열 생성
		d = new char[cdir]; // 횟수만큼의 방향 배열 생성
		int T = 0; // 뱀 길이 size

		boolean end = false;
		for (int i = 0; i < cdir; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			limitT[i] = Integer.parseInt(st.nextToken()); // 시간값 할당
			d[i] = st.nextToken().charAt(0); // 방향 문자 할당
		}
		
		int i = 0;
		while(true) {
			while (true) {
				T++;
				if (dis == 0) { // 방향 대로 뱀 이동 시키기
					nr = nr + dir[0][0];
					nc = nc + dir[0][1];
					if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
						end = true;
						break;
					} else {
						if (map[nr][nc] == 1) {
							end = true;
							break;
						}
						if (map[nr][nc] == 2) {
							map[nr][nc] = 1; // 이동 지점
							headInsert();
						} else { // 2가 아닌 경우 1일때 꼬리 지점이 따라가게 되는 오류 발생.
							map[nr][nc] = 1;
							headInsert();
							rearDel();
						}
					}
				} else if (dis == 1) {
					nr = nr + dir[1][0];
					nc = nc + dir[1][1];
					if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
						end = true;
						break;
					} else {
						if (map[nr][nc] == 1) {
							end = true;
							break;
						}
						if (map[nr][nc] == 2) {
							map[nr][nc] = 1; // 이동 지점
							headInsert();
						} else { // 2가 아닌 경우 1일때 꼬리 지점이 따라가게 되는 오류 발생.
							map[nr][nc] = 1;
							headInsert();
							rearDel();
						}
					}
				} else if (dis == 2) {
					nr = nr + dir[2][0];
					nc = nc + dir[2][1];
					if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
						end = true;
						break;
					} else {
						if (map[nr][nc] == 1) {
							end = true;
							break;
						}
						if (map[nr][nc] == 2) {
							map[nr][nc] = 1; // 이동 지점
							headInsert();
						} else { // 2가 아닌 경우 1일때 꼬리 지점이 따라가게 되는 오류 발생.
							map[nr][nc] = 1;
							headInsert();
							rearDel();
						}
					}
				} else if (dis == 3) {
					nr = nr + dir[3][0];
					nc = nc + dir[3][1];
					if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
						end = true;
						break;
					} else {
						if (map[nr][nc] == 1) {
							end = true;
							break;
						}
						if (map[nr][nc] == 2) {
							map[nr][nc] = 1; // 이동 지점
							headInsert();
						} else { // 2가 아닌 경우 1일때 꼬리 지점이 따라가게 되는 오류 발생.
							map[nr][nc] = 1;
							headInsert();
							rearDel();
						}
					}
				}

				if (T == limitT[i]) { // 시간이 같아질 경우 방향 전환
					if (dis == 0) {
						if (d[i] == 'D') {
							dis = 3;
						} else {
							dis = 2;
						}
					} else if (dis == 1) {
						if (d[i] == 'D') {
							dis = 2;
						} else {
							dis = 3;
						}
					} else if (dis == 2) {
						if (d[i] == 'D') {
							dis = 0;
						} else {
							dis = 1;
						}
					} else if (dis == 3) {
						if (d[i] == 'D') {
							dis = 1;
						} else {
							dis = 0;
						}
					}
					break;
				}
			}
			if (end) {
				break; }
			if(i<cdir-1) {i++;}
		}
		System.out.println(T);
	}
	public static void headInsert() {
		int tmp[] = new int[2];
		if(index+1>=snake.length) {
			snake = Arrays.copyOf(snake, snake.length+1);
		}
		index++;
		tmp[0] = nr; tmp[1] = nc;
		snake[index] = tmp;
	}
	public static void rearDel() {
		map[sr][sc] = 0;
		for (int i = 0; i < snake.length-1; i++) {
			snake[i][0] = snake[i+1][0];
			snake[i][1] = snake[i+1][1];
		}
		snake[index][0] = 0;
		snake[index][1] = 0;
		index--;
		sr = snake[0][0];
		sc = snake[0][1];
	}
}
