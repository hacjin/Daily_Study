package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1244_최대상금_이학진 {
	static String num;
	static char[] res;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T,size;
		char max;
		int cnt;
		int xidx;
		int last=0;	// 동일 최대값 존재시 마지막 인덱스
		int mcnt,tmp;	// 동일 최대값 존재시 갯수
		boolean chk;
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			num = st.nextToken();
			size = num.length();
			res = num.toCharArray();
			cnt = Integer.parseInt(st.nextToken());
			mcnt = -1;
			tmp = -1;
			chk = false; // 동일 최대값이 존재하고 그 이후 에 더 큰 존재값이 존재하는지 여부
			int j = 0;
			for (int c = 0; c < cnt; c++) {
				if(size==2) {
					swap(0,1);
				}else {
					while(j<size) {
						max = res[j];
						xidx = j;
						for (int i = j+1; i < size; i++) {
							if(max <= res[i]) {
								if(max==res[i] && !chk) {
									mcnt++;
									xidx = i;
									last = xidx;
								}else {
									max = res[i];
									xidx = i;
									if(mcnt>=0) {
										mcnt = -1;
										chk = true;
									}
								}
							}
						}
						if(res[xidx]==res[j]) { 
							
							if(j == size-1) {	// 위치 마다 더이상 뒤에 큰수가 없을때 
								if(mcnt>0) {
									swap(last,last-1);	// 연속된 수이후에 작은수가 올경우 연속된 수끼리 스왑
								}else {
									swap(j,j-1);	// 마지막과 그전 수와 스왑
								}
							}
							if(xidx==j) {j++; continue;}
							else {
								swap(xidx,j);
								j++;
								break;
							}
						}
						else {
							swap(xidx,j);	// 최저수 와 최고수 위치를 스왑
							j++;
							if(!chk) tmp = mcnt;
							break;
						}
					}
				}
			}
			if(tmp>=cnt-1) {
				for (int i = last-cnt+1; i < size; i++) {
					max = res[i];
					xidx = i;
					for (int k = i+1 ; k < size; k++) {
						if( max < res[k]) {
							max = res[k];
							xidx = k;
						}
					}
					swap(xidx,i);
				}
			}
			System.out.printf("#"+t+" ");
			for (char ch : res) {
				System.out.print(ch);
			}
			System.out.println();
		}
	}
	public static void swap( int i, int j) {
		int tmp;
		tmp = res[i]-'0';
		res[i] = res[j];
		res[j] = Character.forDigit(tmp, 10);
	}
}

