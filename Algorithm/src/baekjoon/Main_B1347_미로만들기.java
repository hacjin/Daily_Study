package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
참고 : 2020-08-12 10:59분
배열의 범위가 없는 경우 최대 최소로 주어진 조건을 보고
범위를 정해가는 풀이법을 생각해볼것.
 */
public class Main_B1347_미로만들기 {
    public static void main(String[] args) throws IOException {
        int[][] dir = {{1,0},{0,-1},{-1,0},{0,1}}; // 남, 서, 북, 동
        int d = 0; // 현재 남쪽을 보고있다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        int x = 50, y = 50;
        int maxX = 50, maxY = 50, minX = 50, minY = 50;
        char[][] map = new char[101][101];
        for (int i = 0; i < map.length; i++) {
            Arrays.fill(map[i],'#');
        }
        map[x][y] = '.';
        for (int i = 0; i < N; i++) {
            char input = arr[i];
            switch (input){
                case 'R':
                    d = (d+1)%4;
                    break;
                case 'L':
                    d = ((d-1)+4)%4;
                    break;
                case 'F':
                    x += dir[d][0];
                    y += dir[d][1];
                    break;
            }
            map[x][y] = '.';
            if(x > maxX) maxX = x;
            if(x < minX) minX = x;
            if(y > maxY) maxY = y;
            if(y < minY) minY = y;
        }
        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY ; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
