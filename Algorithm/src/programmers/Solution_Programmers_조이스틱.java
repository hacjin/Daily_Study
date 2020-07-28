package programmers;

import java.util.Arrays;

public class Solution_Programmers_조이스틱 {
    public static void main(String[] args) {
        System.out.println(solution("AAABAAA"));
        System.out.println(solution("AABAAAAAAABBB"));
        System.out.println(solution("JAAEAAAAAAAAAAAAATAAW"));
    }

    public static int solution(String name) {
        int size = name.length();
        char[] input = name.toCharArray();
        char[] init = new char[name.length()];
        Arrays.fill(init, 'A');
        int answer = size*('Z'-'A') + size;
        int sum = Math.min(input[0]-init[0],'Z'+ 1 - input[0]);
        init[0] = input[0];
        // 오른쪽 돌 때
        for (int i = 1; i < size; i++) {
            if (Arrays.equals(init,input)) {
                break;
            }
            sum += 1;
            // 위로 돌릴 때와 아래로 돌릴 때 비교
            int min = Math.min(input[i]-init[i],'Z'+ 1 - input[i]);
            sum += min;
            init[i] = input[i];
        }
        if(sum < answer) answer = sum;
        // 왼쪽 돌 때
        Arrays.fill(init, 'A');
        sum = Math.min(input[0]-init[0],'Z'+ 1 - input[0]);
        init[0] = input[0];
        for (int i = size-1; i > 0 ; i--) {
            if(Arrays.equals(init,input)) {
                break;
            }
            sum += 1;
            int min = Math.min(input[i]-init[i],'Z'+ 1 - input[i]);
            sum += min;
            init[i] = input[i];
        }
        if(sum < answer) answer = sum;
        return answer;
    }
}
