package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B3187_양치기꿍 {
    static int total_v, total_k;
    static int R,C;
    static boolean[][] visit;
    static char[][] map;
    static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visit = new boolean[R][C];
        total_k = 0;
        total_v = 0;
        ArrayList<Pos> wolf = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if(map[i][j]=='v') {
                    wolf.add(new Pos(i,j));
                    total_v++;
                }else if(map[i][j]=='k') {
                    total_k++;
                }
            }
        }

        for (int i = 0; i < wolf.size(); i++) {
            Pos cur = wolf.get(i);
            if(!visit[cur.x][cur.y]) {
                find(cur.x,cur.y);
            }
        }
        System.out.println(total_k+" "+total_v);
    }

    private static void find(int x, int y) {
        int cntV = 1;
        int cntK = 0;
        Queue<Pos> que = new LinkedList<>();
        visit[x][y] = true;
        que.add(new Pos(x,y));
        while(!que.isEmpty()) {
            int r = que.peek().x;
            int c = que.peek().y;
            que.poll();
            for (int i = 0; i < dir.length; i++) {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
                if(nr >= 0 && nr < R && nc>=0 &&nc <C && !visit[nr][nc] && map[nr][nc]!='#') {
                    visit[nr][nc] = true;
                    if(map[nr][nc]=='v') cntV++;
                    else if(map[nr][nc]=='k') cntK++;
                    que.add(new Pos(nr,nc));
                }
            }
        }
        if(cntV >= cntK) total_k -= cntK;
        else total_v -= cntV;
    }
}
class Pos{
    int x;
    int y;
    public Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}