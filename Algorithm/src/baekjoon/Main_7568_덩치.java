package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Man{
	int w;
	int h;
	int k;
	public Man(int w, int h) {
		this.w = w;
		this.h = h;
		this.k = 0;
	}
} 
public class Main_7568_덩치 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Man man[] = new Man[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			man[i] = new Man(w,h);
		}
		
		for (int i = 0; i < N-1; i++) {
			for (int j = i+1; j < N; j++) {
				if(man[i].w < man[j].w && man[i].h < man[j].h) {
					man[i].k++;
				}else if(man[i].w > man[j].w && man[i].h > man[j].h) {
					man[j].k++;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			System.out.print(man[i].k+1+" ");
		}
	}
}
