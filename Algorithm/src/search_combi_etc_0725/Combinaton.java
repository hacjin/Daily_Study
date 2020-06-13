package search_combi_etc_0725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * Combination!!!
 *	nCr n개 중에 r을 뽑는 경우의 수
 *	ex) A B C 3C2 일때	
 *			O	
 *		  O X
 *		O X O		A가 뽑혔을때는 2C1 나머지 2개중에 1를 뽑는 경우
 *          X
 *          O	 
 *	 	X O X		A가 뽑히지 않았을때 2C2 나머지 2개중에 2개를뽑는 경우
 *        X O
 *          X
 *  즉!! 3C2 = 2C2 + 2C1 꼴이 나온다
 *	    nCr = n-1Cr + n-1Cr-1;
 *		r=n 같고 r=0일때 1이 된다.
 */
public class Combinaton {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N= Integer.parseInt(st.nextToken());
		int R= Integer.parseInt(st.nextToken());
		
		System.out.println(combi(N,R));
	}
	public static int combi(int N, int R) {
		if( N == R || R == 0) {
			return 1;
		}
		else {
			return combi(N-1,R) + combi(N-1,R-1);
		}
	}
}
