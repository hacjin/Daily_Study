package programmers;

import java.io.*;

public class Solution_10059_유효기간 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        char input[];
        for (int t = 1; t <= T; t++) {
            bw.append("#"+t+" ");
            input = br.readLine().toCharArray();
            boolean[] month = new boolean[2];
            if((input[0]==0+'0' && input[1] > 0+'0') || (input[0]==1+'0' && input[1]<=2+'0')) month[0] = true;
            if((input[2]==0+'0' && input[3] > 0+'0') || (input[2]==1+'0' && input[3]<=2+'0')) month[1] = true;

            if(month[0] && month[1]) bw.append("AMBIGUOUS\n");
            else if(month[0] && !month[1]) bw.append("MMYY\n");
            else if(!month[0] && month[1]) bw.append("YYMM\n");
            else bw.append("NA\n");
            bw.flush();
        }
        bw.close();
    }
}
