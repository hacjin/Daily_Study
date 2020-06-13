package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1244_최대상금_완전탐색 {
	static String str;
	static char[] arr;
	static int answer;
	static int N,size;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			answer=0;
			st = new StringTokenizer(br.readLine());
			str = st.nextToken();
			arr = str.toCharArray();
			size = str.length();
			N = Integer.parseInt(st.nextToken());
			find(0,0);
			System.out.println("#"+t+" "+answer);

		}
	}

	private static void find(int n, int index) {
		if(n==N) {
			answer = Math.max(answer, Integer.parseInt(str));
			return;
		}
		for (int i = index; i < size; i++) {
			for (int j = i+1; j < size; j++) {
				if(str.charAt(i)<=str.charAt(j)) {
					swap(i,j);
					find(n+1,i);
					swap(j,i);
				}
			}
		}
	}

	private static void swap(int i, int j) {
		StringBuilder change = new StringBuilder(str);
		char charA = str.charAt(i);
		char charB = str.charAt(i);
		change.setCharAt(i, charB);
		change.setCharAt(j, charA);
		str = change.toString();
		
	}
}

