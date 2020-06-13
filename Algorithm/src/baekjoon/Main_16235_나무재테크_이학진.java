package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_16235_나무재테크_이학진 {
	static int dir[][] = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};	// 번식을 위한 방향
	static int map[][], A[][];
	static List<Integer> tree[][];
	static List<int[]> food;
	static int N,M,K;
	public static void main(String[] args) throws IOException {
		BufferedReader	br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());	// 땅 크기
		map = new int[N+1][N+1];	// 땅에는 양분의 값 기본 5
		A = new int[N+1][N+1];		// 추가 양분 배열
		for(int[] anergy : map) {
			Arrays.fill(anergy, 5);
		}
		M = Integer.parseInt(st.nextToken());	// 나무 개수
		tree = new ArrayList[N+1][N+1];	// 나무 좌표값R[0] C[1]와, 나이 값[2] 
		K = Integer.parseInt(st.nextToken());	// 년도
		
		for (int i = 0; i < N+1; i++) {
			for (int j = 0; j < N+1; j++) {
				tree[i][j] = new ArrayList<Integer>();
			}
		}
		for (int i = 1; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int tmp[] = new int[3];
			tmp[0] = Integer.parseInt(st.nextToken());
			tmp[1] = Integer.parseInt(st.nextToken());
			tmp[2] = Integer.parseInt(st.nextToken());
			tree[tmp[0]][tmp[1]].add(tmp[2]);
		}
		
		for (int k = 0; k < K; k++) {
			grow();
		}
		int sum = 0;
		for (int i = 1; i <=N; i++) {
			for (int j = 1; j <=N; j++) {
				sum += tree[i][j].size();
			}
		}
		System.out.println(sum);	
	}
	private static void grow() {
		food = new ArrayList<int[]>();		// 죽은 나무에 해당하는 나무 인덱스에 양분값 저장
		//1. 봄
		for (int i = 1; i <=N; i++) {
			for (int j = 1; j <=N; j++) {
				int size = tree[i][j].size();
				for (int k = 0; k < size; k++) {
					int age = tree[i][j].get(k);
					if(map[i][j] >= age ) { 	// 나이만큼 양분을 먹고 나이가 +1 증가
						map[i][j] = map[i][j]-age;
						tree[i][j].set(k, age+1);
					}else {					// 양분이 나이보다 부족할 경우 나무 나이/2 값을 양분에 저장하고 죽은나무 = 나이0 처리
						food.add(new int[] {i,j,age/2});
						tree[i][j].remove(k);
						k--;
						size--;
					}
				}
			}
		}
		//2. 여름
		for (int j = 0; j < food.size(); j++) {
			int f[] = food.get(j);
			int r = f[0];
			int c = f[1];
			map[r][c] += f[2];
		}
		//3. 가을
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int size = tree[i][j].size();
				for (int k = 0; k < size; k++) {
					int age = tree[i][j].get(k);
					if(age%5==0)	{	// 나무의 나이가 5의 배수일 경우 번식처리
						for (int d = 0; d < dir.length; d++) {
							int nr = i + dir[d][0];
							int nc = j + dir[d][1];
							if(nr>=1 && nr<=N && nc>=1 && nc<=N) {
								tree[nr][nc].add(0,1);
							}
						}
					}
				}
				
			}
		}
		//4. 겨을
		for (int i = 1; i <= N; i++) {		// 양분을 추가해준다.
			for (int j = 1; j <= N; j++) {	
				map[i][j] += A[i][j];
			}
		}
	}
}
