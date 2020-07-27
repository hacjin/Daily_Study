package programmers;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1206_View {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			int width = Integer.parseInt(br.readLine());
			int height[] = new int[width];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < width; j++) {
				height[j] = Integer.parseInt(st.nextToken());
			}
			int preMax = 0;
			int sum = 0;
			for (int j = 2; j < width-2; j++) {
				int cur = height[j];
				if(height[j-1] < cur && height[j-2] < cur && height[j+1] < cur && height[j+2] < cur) {
					preMax = Math.max(Math.max(height[j-1], height[j-2]), Math.max(height[j+1], height[j+2]));
					sum += (cur - preMax);
				}
			}
			System.out.println("#"+(i+1)+" "+sum);
		}
	}
}
