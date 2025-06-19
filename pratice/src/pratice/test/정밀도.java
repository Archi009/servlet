package pratice.test;

public class 정밀도 {
	 public static void main(String[] args) {
		//double : 배정밀도 소수점을 더 정밀하게 
		 
		//float : 유효자리수 6자리 0.000001 => 1*10^-6   유효자리수 1 유효자리수를 넘으면 자동으로 반올림되어 표기
		 					//0.11111 => 11111*10*-5 유효자리수 5  		 
		 float f = 0.123456789123456789f;
		 double d = 0.123456789123456789;
		 System.out.println(f);
		 System.out.println(d);
	}
}
