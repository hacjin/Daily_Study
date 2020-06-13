package dp3_0925;

import java.util.Scanner;

public class Solution_D4_4366_정식이의은행업무_이학진 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			long res=0;
			String two = sc.next();
			char twoarr[] = two.toCharArray(); 
			String three = sc.next();
			char threearr[] = three.toCharArray();
			
			for (int i = 0; i < two.length(); i++) {
				if(twoarr[i]=='0') twoarr[i]='1';
				else twoarr[i]='0';
				for (int j = 0; j < three.length(); j++) {
					if(threearr[j]=='0') {
						threearr[j]='1';
						if(Long.parseLong(new String(twoarr),2) == Long.parseLong(new String(threearr),3)) {
							res = Long.parseLong(new String(twoarr),2);
							break;
						}
						threearr[j]='2';
						if(Long.parseLong(new String(twoarr),2) == Long.parseLong(new String(threearr),3)) {
							res = Long.parseLong(new String(twoarr),2);
							break;
						}
						threearr[j]='0';
					}
					else if(threearr[j]=='1') {
						threearr[j]='0';
						if(Long.parseLong(new String(twoarr),2) == Long.parseLong(new String(threearr),3)) {
							res = Long.parseLong(new String(twoarr),2);
							break;
						}
						threearr[j]='2';
						if(Long.parseLong(new String(twoarr),2) == Long.parseLong(new String(threearr),3)) {
							res = Long.parseLong(new String(twoarr),2);
							break;
						}
						threearr[j]='1';
					}else {
						threearr[j]='0';
						if(Long.parseLong(new String(twoarr),2) == Long.parseLong(new String(threearr),3)) {
							res = Long.parseLong(new String(twoarr),2);
							break;
						}
						threearr[j]='1';
						if(Long.parseLong(new String(twoarr),2) == Long.parseLong(new String(threearr),3)) {
							res = Long.parseLong(new String(twoarr),2);
							break;
						}
						threearr[j]='2';
					}
				}
				if(res!=0) break;
				if(twoarr[i]=='0') twoarr[i]='1';
				else twoarr[i]='0';
			}
			System.out.println("#"+t+" "+res);
		}
	}
}
