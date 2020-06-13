package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2231_분해합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();
		

		int N = Integer.parseInt(num);
		int size=num.length();
		
		int tmp=N-1;
		int sum=0,min=1000000;
		while(true) {
			if(tmp==(N-size*9)) break;
			String str = Integer.toString(tmp);
			sum = tmp;
			for (int i = 0; i < str.length(); i++) {
				sum += str.charAt(i)-'0';
			}
			if(sum==N && min > tmp) min = tmp;
			tmp--;
		}
		
		System.out.println(min==1000000?0:min);
	}
}
