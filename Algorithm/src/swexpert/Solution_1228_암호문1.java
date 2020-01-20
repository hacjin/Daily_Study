package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1228_암호문1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st,st2;
		String[] tmp;
		int N,idx,count;
		ArrayList<Integer> secret;
		
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());
			secret = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {		// N개 만큼의 암호문을 삽입
				secret.add(Integer.parseInt(st.nextToken()));
			}
			
			N = Integer.parseInt(br.readLine());	// 여기서 N은 명령어 개수
			st = new StringTokenizer(br.readLine(),"I");	// I기준으로 나눔
			tmp = new String[N];
			for (int i = 0; i < N; i++) {
				tmp[i] = st.nextToken().trim();
				st2 = new StringTokenizer(tmp[i]);
				idx = Integer.parseInt(st2.nextToken().trim());
				count = Integer.parseInt(st2.nextToken());
				for (int j = 0; j < count; j++) {
					secret.add(idx++,Integer.parseInt(st2.nextToken()));
				}
				
			}
			
			System.out.printf("#"+t+" ");
			for (int i = 0; i < 10; i++) {
				System.out.printf(secret.get(i)+" ");
			}
			System.out.println();
		}
		
	}
}
