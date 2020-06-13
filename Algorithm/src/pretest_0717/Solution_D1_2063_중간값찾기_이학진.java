package pretest_0717;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Solution_D1_2063_중간값찾기_이학진 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp;
        String P[] = null;
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N >= 9 && N <= 199) {
                String s = br.readLine();
                P = s.split(" ");
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < i; j++) {
                        if (Integer.parseInt(P[j]) > Integer.parseInt(P[i])) {
                            tmp = P[i];
                            P[i] = P[j];
                            P[j] = tmp;
                        }
                    }
                }
                System.out.println(P[(N)/2]);
                break;
            }
        }
    }
}