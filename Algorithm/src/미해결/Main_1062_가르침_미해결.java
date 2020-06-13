package 미해결;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_1062_가르침_미해결 {
	static char arr[],already[];
	static boolean visit[];
	static Map<Character, Integer> alpha;
	static int N,K;
	public static void main(String[] args) throws IOException {
		arr= new char[] {'a','b','c','d','e','f','g','h','i','j'
					   ,'k','l','m','n','o','p','q','r'
					   ,'s','t','u','v','w','x','y','z'};
		already = new char[] {'a','c','i','n','t'};
		visit = new boolean[26];
		alpha = new HashMap<Character,Integer>();
		for (int i = 0; i < arr.length; i++) {
			alpha.put(arr[i], i);
			for (int j = 0; j < already.length; j++) {
				if(arr[i]==already[j]) visit[i] = true;
			}
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int max = 0;
		if(K>4) {
			for (int i = 1; i <= N; i++) {
				int cnt = 0;
				char[] in = br.readLine().toCharArray();
				for (int j = 0; j < 26; j++) {
					if(!visit[j]) {
						visit[j] = true;
						check(j,1,in);
						visit[j] = false;
					}
				}
				if(cnt==K) max++;
			}
		}
		System.out.println(max);
	}
	private static void check(int i, int cnt, char in[]) {
		if(cnt==K-5) {
			for (int j = 0; j < in.length; j++) {
				int index = alpha.get(in[j]);
				if(!visit[index]) break;
			}
		}
		
	}
}
