package permu_combi_bitOper_etc_0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bitexampl2 {
	public static void main(String[] args) throws IOException {
		String[] bit = {"001101","010011","111011","110001"
						,"100011","110111","001011","111101","011001","101111"};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String in = br.readLine();
		int size = in.length();
		String cal[] = new String[size];
		String st = "",tmp;
		for (int i = 0; i < size; i++) {
			cal[i] = Character.toString(in.charAt(i));
//			st += Integer.toBinaryString(Integer.parseInt(cal[i], 16));
			st += String.format("%4s", Integer.toBinaryString(Integer.parseInt(cal[i],16))).replace(' ', '0');;
		}
		int len=0,i=0;
		while(i<st.length()) {
			if(st.charAt(i) != '0') {
				for (int j = 0; j < bit.length; j++) {
					len = Integer.toString(Integer.parseInt(bit[j])).length();
					if(i+len>st.length()) break;
					tmp = st.substring(i, i+len);
					if(tmp.equals(Integer.toString(Integer.parseInt(bit[j])))) {
						System.out.print(j+" ");
						i += len;
					}
				}
			}else {
				i++;
			}
		}
		
		
	}
}
