package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4261_빠른휴대전화키패드_이학진 {
	static String num[] = { "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	static String[] dic;
	static char[] input;
	static int N,result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			input = st.nextToken().toCharArray();
			N = Integer.parseInt(st.nextToken());
			result = 0;
			dic = new String[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				dic[i] = st.nextToken();
			}
			findword();
			System.out.println("#"+t+" "+result);
		}
	}
	private static void findword() {
		char chk;
		int idx, cnt;
		for (int i = 0; i < N; i++) {
			cnt = 0;
			for (int j = 0,k = 0; j < input.length; j++) {
				if(k==dic[i].length()) break;
				idx = input[j]-'0';
				chk = dic[i].charAt(k);
				if(contain(num[idx],chk)) {
					cnt++;
				}
				k++;
			}
			if(cnt==dic[i].length()) result++;
		}
	}
	private static boolean contain(String str, char chk) {
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i)==chk) return true;
		}
		return false;
	}
}
