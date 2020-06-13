package permu_combi_bitOper_etc_0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Bitexample_강사님 {
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		char[] chr = line.toCharArray();
		int i =0, count = 7, size = chr.length;
		while(i<size) {
			int number = 0;
			for (int j = 0; j < count; j++) {
				if(chr[i+j]=='0') continue;
				number += (1<<(count-1-j));	// 1비트이면 1<<6, 1<<5 이런식으로 1<<0
			}
			System.out.println(number);
			i += count;
		}
		
		
		System.out.println("=========================================");
		for (int j = 0; j < size; j+=7) {
			System.out.println(Integer.parseInt(line.substring(j,j+7),2));
		}
	}

}
