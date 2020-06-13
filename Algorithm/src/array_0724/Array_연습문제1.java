package array_0724;


/**
 *
 * 5x5 2차 배열에 무작위 25개 숫자 초기화 25개의 각 요소에 대해서 그 요소와 이웃한 요소와의 차의 절대값을 구하시오
 *
 */
public class Array_연습문제1 {
	static int dir[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상 하 좌 우
	static int size = 5;

	public static void main(String[] args) {
		int arr[][] = new int[size][size];

		insert(arr);
		System.out.println("모든 요소들의 총합 : " + absolute(arr));

	}

	private static int absolute(int[][] arr) {
		int nr, nc;
		int diff = 0, result = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < 4; k++) {
					nr = i + dir[k][0];
					nc = j + dir[k][1];
					if (nr >= 0 && nr < size && nc >= 0 && nc < size) {
						diff = arr[i][j] - arr[nr][nc];
						if (diff < 0)
							diff = diff * -1;
						result += diff;
					}
				}
			}
		}
		return result;
	}

	private static void insert(int[][] arr) {
		int num=1;
		/** 
		 * Random r = new Random();
		 * r.nextInt(100) +1; 로도 사용 가능
		 */
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
//				num= (int)(Math.random()*25)+1;
//				arr[i][j] = num;
				arr[i][j] = num++;
			}
		}
	}

}
