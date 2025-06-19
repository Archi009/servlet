package pratice.test.제어문;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// 60미만
public class ForCount {
	public static void main(String[] args) throws FileNotFoundException {
		//파일 입력
		
		File file = new File("src/resources/engScore.txt");
		Scanner sc = new Scanner(file);  
		
		int cnt = sc.nextInt();
		int count = 0;
		
		for(int i = 0 ; i < cnt ; i++ ) {
			int score = sc.nextInt();
			if(score <= 60) {
				count ++;
				System.out.println(score);
			}
		}
		System.out.println("60미만인 점수의 갯수 : " + count);
		
	}
}
