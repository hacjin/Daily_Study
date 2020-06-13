package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 1. 사분할 영역에서 하수구 or 다른 타일 영역 찾기
 * 2. 해당영역을 제외한 나머지 영역을 걸치는 타일을 중심위치 기반으로 채우기
 * 3. 4영역 모두 타일을 채우는 함수를 호출 ( 인자로 하수구 or 다른 타일 위치 전달 ) <= 타일을 놓으면 안되는 위치 정보
 *  
 */
public class Main_2543_타일채우기_이학진_미해결 {
	static int tile[][][] = {
								{{-1,0},{0,-1},{0 ,0}},
								{{-1,0},{0 ,0},{0 ,1}},
								{{0,-1},{0 ,0},{1 ,0}},
								{{0 ,0},{0 ,1},{1 ,0}}	  
							   };
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int map[][] = new int[N][N];
		Arrays.fill(map, -1);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		map[R][C] = 0;
		
	}
}
