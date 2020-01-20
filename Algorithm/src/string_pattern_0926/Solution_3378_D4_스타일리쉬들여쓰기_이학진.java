package string_pattern_0926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_3378_D4_스타일리쉬들여쓰기_이학진 {
	static int a=0,b=0,c=0,d=0,e=0,f=0,ind=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int Rlen = Integer.parseInt(st.nextToken());
			int Wlen = Integer.parseInt(st.nextToken());

			int R[] = new int[Rlen];
			int C[] = new int[Rlen];
			int S[] = new int[Rlen];
			int indent[] = new int[Rlen];
			a=b=c=d=e=f=ind=0;
			for (int r = 0; r < Rlen; r++) {
				String Rarr = br.readLine();
				findRSC(r,Rarr);
				R[r] = a-b;
				C[r] = c-d;
				S[r] = e-f;
				indent[r]=ind;
			}
			
			List<int[]> list = new LinkedList<int[]>();
			for (int i = 1; i <= 20; i++) {
				for (int j = 1; j <= 20; j++) {
					for (int k = 1; k <= 20; k++) {
						int plus=0;
						for (int in = 0; in < Rlen-1; in++) {
							if(indent[in+1]==(i*R[in]+j*C[in]+k*S[in])) {
								plus++;
							}
						}
						if(plus==Rlen-1) {
							int rcs[] = new int[3];
							rcs[0]= i;
							rcs[1]= j;
							rcs[2]= k;
							list.add(rcs);
						}
					}
				}
			}
			System.out.print("#"+t+" "+"0 ");
			a=b=c=d=e=f=0;
			int in[] = new int[list.size()];
			for (int i = 0; i < Wlen; i++) {
				String Warr = br.readLine();
				if(i!=Wlen-1) {
					findRSC(i,Warr);
					for (int j = 0; j < list.size(); j++) {
						in[j] = list.get(j)[0]*(a-b)+list.get(j)[1]*(c-d)
								+ list.get(j)[2]*(e-f);
					}
					int inchk = 0;
					for (int j = 0; j < in.length-1; j++) {
						if(in[j]==in[j+1]) inchk++; 
					}
					if(inchk==in.length-1) System.out.print(in[0]+" ");
					else System.out.print("-1 ");
				}
			}
			System.out.println();
		}
	}

	private static void findRSC(int r,String Rarr) {
		ind=0;
		boolean chk = false;
		for (int i = 0; i < Rarr.length(); i++) {
			if(i==0 && Rarr.charAt(i)=='.') chk = true;   
			if(Rarr.charAt(i)=='(') a++;
			else if(Rarr.charAt(i)==')') b++; 
			else if(Rarr.charAt(i)=='{') c++;
			else if(Rarr.charAt(i)=='}') d++;
			else if(Rarr.charAt(i)=='[') e++;
			else if(Rarr.charAt(i)==']') f++;
			if(chk && Rarr.charAt(i)=='.') ind++;
			else if(chk && !(Rarr.charAt(i)=='.')) chk=false;
		}
	}
}	
