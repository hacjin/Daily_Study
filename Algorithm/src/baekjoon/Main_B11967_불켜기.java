package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
참고 : 2020-08-12 13:14분
방문 고려 요소 
1. 현재방에서 인접한 방
2. 불이 켜져 있어야 한다.
인접한 방 을 위한 near
불을 위한 map
방문 여부를 위한 visit

로직
1,1을 시작
1. near를 이용하여 근접한 방을 체크
2. 현재방에서 불을 킬수 있는 방의 불을 키면서 near이면 que에 추가
3. 현재방에서 다시 근접한 불켜진 방을 que에 추가
 */
public class Main_B11967_불켜기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N + 1][N + 1];
        boolean[][] visit = new boolean[N+1][N+1];
        boolean[][] near = new boolean[N+1][N+1];
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 동 남 서 북
        ArrayList<Integer>[] arr = new ArrayList[(N + 1) * (N + 1)];
        for (int i = 0; i < (N+1)*(N+1); i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int index = x * (N + 1) + y;
            arr[index].add(a * (N + 1) + b);
        }
        Queue<int[]> que = new LinkedList<>();
        map[1][1] = 1;
        visit[1][1] = true;
        que.add(new int[]{1, 1});
        while (!que.isEmpty()) {
            int x = que.peek()[0];
            int y = que.peek()[1];
            que.poll();
            for (int i = 0; i < dir.length; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                if(nx>=1 && nx<N+1 && ny>=1 && ny<N+1) {
                    near[nx][ny] = true;
                }
            }
            for (int i = 0; i < arr[x * (N + 1) + y].size(); i++) {
                int tmp = arr[x * (N + 1) + y].get(i);
                int r = tmp / (N + 1);
                int c = tmp % (N + 1);
                map[r][c] = 1;
                if(near[r][c] && map[r][c]==1 && !visit[r][c]) {
                    visit[r][c] = true;
                    que.add(new int[]{r,c});
                }
            }
            for (int i = 0; i < dir.length; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                if(nx>=1 && nx<N+1 && ny>=1 && ny<N+1 && !visit[nx][ny] && map[nx][ny]==1 && near[nx][ny]) {
                    visit[nx][ny] = true;
                    que.add(new int[]{nx,ny});
                }
            }
        }
        int max = 0;
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (map[i][j] == 1) max++;
            }
        }
        System.out.println(max);
    }
}
