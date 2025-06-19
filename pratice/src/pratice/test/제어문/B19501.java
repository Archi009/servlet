package pratice.test.제어문;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class B19501 {
	public static void main(String[] args) throws FileNotFoundException {
		//파일 입력
		
				Scanner sc = new Scanner(System.in);  

				//갯수 입력
				int cnt = sc.nextInt();
				
				//반복문
				for(int i = 0; i < cnt; i++) {
					System.out.println(sc.nextInt() + sc.nextInt());
				}
				
	}
}
