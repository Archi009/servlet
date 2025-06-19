package pratice.test.제어문;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// 평균을 계산하고 평균 미달 성적만 출력
// 총점 계산 -> 평균 계산 -> 평균 미달 성적 출력
public class ForArrayOrigin {
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
				int count = 0;

				//합계출력
				System.out.println("총 점" + total);
				double avg = total/cnt;
				System.out.println("평균" + avg);
				for(int i = 0; i < cnt; i++) {
					if(a[i]<avg) {
						count ++;
						System.out.println(a[i]);
					}
				}
				System.out.println("총 건수"+cnt +"평균미달건수"+count);
	}
}
