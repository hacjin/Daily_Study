package pretest_0717;

import java.util.Scanner;

public class Solution_D2_1204_최빈수구하기_이학진 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T; // 테스트 케이스
        int N[]; // 점수
        int count[];
        int Max_Size = 1000; // 학생 최대 수
        int Max_Num = 101;
        int tmp,index=0, T_count=0;
        N = new int[Max_Size];
        
        T = scan.nextInt();
        System.out.println(T);
        while (T_count <= T) {
            T_count = scan.nextInt();
            count = new int[Max_Num];
            for (int i = 0; i < Max_Size; i++) {
                N[i] = scan.nextInt();
                count[N[i]]++;
            }
            tmp = count[0];
            for (int i = 0; i < Max_Num -1; i++) {
                    if(count[i+1] >= tmp) {
                        tmp = count[i+1];
                        index = (i+1);
                    }
            }
            
            System.out.println("#" + T_count + " " + index);
            T_count++;
        }
    }
}