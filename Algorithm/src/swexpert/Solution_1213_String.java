package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1213_String {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T,cnt;
		String in,s;
		
		for (int t = 1; t <= 10; t++) {
			T = Integer.parseInt(br.readLine());
			cnt=0;
			s = br.readLine();
			in = br.readLine();
			int tsize = s.length();
			int size = in.length();
			for (int i = 0; i < size; i++) {
					if(i+tsize > size) {
						break;
					} else {
						if(s.equals(in.substring(i, i+tsize))) {
							cnt++;
						}
					}
			}
			System.out.println("#"+t+" "+cnt);
		}
	}
}
