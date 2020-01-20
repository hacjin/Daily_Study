package permu_combi_bitOper_etc_0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bitexample {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String in = null;
		st = new StringTokenizer(br.readLine());
		int size = st.countTokens();
		for (int i = 0; i < size; i++) {
			if(in == null) {
				in = st.nextToken();
			}else {
			in += st.nextToken();
			}
		}
		String num;
		int res=0;
		for (int i = 0; i < in.length(); i+=7) {
			res= 0;
			num = in.substring(i, i+7);
			for (int j = 0; j < 7; j++) {
				res += (num.charAt(j)-'0') * (int)Math.pow(2, 6-j);
			}
			System.out.println(" 숫자 : "+res);
			
		}
	}

}
