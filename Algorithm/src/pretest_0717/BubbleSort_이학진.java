package pretest_0717;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BubbleSort_이학진 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();		// N개의 숫자 입력
		String[] s = N.split(" ");
		int size=s.length;
		
		String tmp;
		for (int i = size-1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if(Integer.parseInt(s[j]) > Integer.parseInt(s[j+1])) {
					tmp = s[j+1];
					s[j+1] = s[j];
					s[j] = tmp;
				}
			}
		}
		
		for (int i = 0; i < s.length; i++) {
			System.out.printf("%s ",s[i]);			
		}
		System.out.println();
		
		
		
	}

}
