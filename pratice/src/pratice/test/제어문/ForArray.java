package pratice.test.제어문;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ForArray {
	public static void main(String[] args) throws FileNotFoundException {
		//파일 입력
				
				File file = new File("src/resources/engScore.txt");
				Scanner sc = new Scanner(file);  

				int score;
				int total = 0;
				
				int cnt = sc.nextInt(); //문서의 첫번째 숫자가 앞으로 들어올 수의 갯수이다
				int[] a = new int[cnt];
				
				for(int i = 0; i < cnt; i++) {
					score = sc.nextInt();
					a[i] = score;
					total += score;
					
				}
				

				//합계출력
				System.out.println(total);
	}
}
