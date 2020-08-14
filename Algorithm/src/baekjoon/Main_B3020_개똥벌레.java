package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
참고 : 2020-08-14
높이별 석순과 종유석이 겹치는 부분을 판단하고 최소가 되는 값을 찾고
최소값이 같은 경우 갯수를 증가하는 문제

 */
public class Main_B3020_개똥벌레 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[] bot = new int[H+1]; // 석순
        int[] top = new int[H+1]; // 종유석

        for (int i = 0; i < N/2; i++) {
            bot[Integer.parseInt(br.readLine())]++;
            top[Integer.parseInt(br.readLine())]++;
        }
        int[] bot_sum = new int[H+1]; // 석순의 부분합
        int[] top_sum = new int[H+1]; // 종유석의 부분합

        for (int i = 1; i <= H; i++) {
            bot_sum[i] = bot_sum[i-1] + bot[i];
            top_sum[i] = top_sum[i-1] + top[i];
        }
        int min = N;
        int cnt = 0;

        for (int i = 1 ; i <= H; i++) {
            int crush = 0;
            crush += top_sum[H] - top_sum[i-1]; // 높이가 2인 종유석과 겹치는 석순은 반대인 높이가 3인
            crush += bot_sum[H] - bot_sum[H-i]; // 즉, H-i 인 2를 빼야 3인 석순을 구한다.
            if(crush < min) {
                min = crush;
                cnt=1;
            }else if(crush == min) {
                cnt++;
            }
        }
        System.out.println(min + " "+ cnt);
    }
}
