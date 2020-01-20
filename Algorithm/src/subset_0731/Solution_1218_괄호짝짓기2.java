package subset_0731;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1218_괄호짝짓기2 {
	static int T = 0, res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int arr[] = new int[4]; // 0 : () 1 :[] 2: {} 3:<>

		char[] ch;
		String in;
		char tmp;
		for (int i = 1; i <= 10; i++) {
			T = Integer.parseInt(br.readLine());
			ch = new char[T];
			in = br.readLine();
			for (int j = 0; j < T; j++) {
				tmp = in.charAt(j);
				switch (tmp) {
				case '(':
					arr[0] = arr[0]+1;
					break;
				case '[':
					arr[1] = arr[1]+1;
					break;
				case '{':
					arr[2] = arr[2]+1;
					break;
				case '<':
					arr[3] = arr[3]+1;
					break;
				case ')':
						arr[0] = arr[0]-1;
					break;
				case ']':
						arr[1] = arr[1]-1;
					break;
				case '}':
						arr[2] = arr[2]-1;
					break;
				case '>':
						arr[3] = arr[3]-1;
					break;
				}
			}
			for (int j = 0; j < 4; j++) {
				if (arr[j] == 0) {
					res = 1;
				} else {
					res = 0;
					break;
				}
			}
			System.out.println("#"+i+" "+res);
		}

	}
}
