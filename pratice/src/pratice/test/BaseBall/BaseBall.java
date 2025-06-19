package pratice.test.BaseBall;

import java.util.Scanner;

public class BaseBall {
	public  Scanner sc = new Scanner(System.in);
	
	public  int[] numbers = new int[3];
	
	public  void playBall() {	
		for(int i = 0; i <3; i++){
			numbers[0] = (int) (Math.random()*10);
		};
		
		System.out.println("플레이 타임을 설정해 주세요>>>>");
		int count = sc.nextInt();
		
		for(int i = 0; i<count;i++) {
			int[] pNum  = new int[3];
			for(int j = 0;i<pNum.length;i++) {
				pNum[i] = sc.nextInt();
			}
			int b = 0;
			int s = 0;
			for(int k = 0 ; i<3; i++) {
				for(int h = 0 ; h<3 ;i++) {
					if(numbers[k]==pNum[h]&& k==h) {
						s++;
					}else if(numbers[k] == pNum[h] && k!=h){
						b++;
					}
				}
			}
			System.out.println(s+"   스트라이크   "+ b+ "   볼  ");
			if(s == 3) {
				System.out.println("승리했습니다.");
				break;
			}else {
				System.out.println("패배했습니다.");
			}
			
			
		}
		
		
	}
	
	
}
