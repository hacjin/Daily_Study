package pretest_0717;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// delimiter(구분자) 가 될수 있는 공백(스페이스,탭,엔터)을 사용
//		System.out.println(sc.nextInt());	
//		System.out.println(sc.nextInt());
//		System.out.println(sc.nextInt());
		
		/**
		 * next() 와 nextXXX()의 차이
		 * 
		 * 1. next()
		 * 10\n	hello\n	20 의 입력이 있을경우
		 * nextInt 는 개행문자\n 전까지 가져옴 => 10
		 * next는 개행문자\n부터hello까지 가져옴 
		 * 그중에 전에 있는 개행문자 \n 을 제거 => hello
		 * nextInt는 개행문자\n부터20까지 가져옴 
		 * 그중에 전에 있는 개행문자 \n 을 제거 => 20
		 * 
		 * 2. nextLin()
		 * 10\n	hello\n 20의 입력이 있을경우
		 * nextInt 는 개행문자\n 전까지 가져옴 => 10
		 * nextLine 은 개행문자까지 받기 때문에 \n 을 가져옴
		 * nextInt 는 hello를 받아 pasing 후 출력
		 * 그후 남은 20은 에러를 불러옴 
		 * 
		 *  nextLine ( 개행을 만날때까지 읽어옴 ) : 문장
		 *  next, nextInt, next... ( 구분자 직전까지 읽어옴 ) : 단어
		 *  => stream에 개행문자가 포함 되어있음 => 이런 성질로 인해 그전에 포함된 개행문자를 제거하고 읽음. 
		 */
		
		System.out.println(sc.nextInt());
		sc.nextLine();
		System.out.println(sc.nextLine());		
		System.out.println(sc.nextInt());
		
		/**
		 *  stream은 단방향  입력 or 출력
		 *  JVM 실행시 3개의 stream이 생김
		 *  1. system.in 2. system.out 3.system.err
		 *  node stream / filter stream 2개로 나뉨
		 */
	}

}
