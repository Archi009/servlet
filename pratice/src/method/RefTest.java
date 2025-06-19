package method;
/*
 * 참조변수 참조객체
 * 불변(상수)
 * 기본형타입       : int, double ...
 * wrapper  클래스 : Integer ....
 * String
 */
public class RefTest {
	 public static void main(String[] args) {
		int a = 10;
		int b = a;
		b= 20;
		System.out.println(a);
		//=> a는 바뀌지 않음
		
		 String[] arr = new String[] {"hello","scott"}; // new 연산자를 통해 만든 instance를 담는 변수는 참조변수이다.(주소값만 가진다)
		 String[] dest = arr; // dest 에도 주소값을 가지는데 
		 dest[0] = "bye"; // 동일한 주소값을 가지는 변수의 원본값을 변경시켰기 때문에 arr도 dest도 변경된 원본값을 불러온다.
		 System.out.println(arr[0]);
		
		
		
		
		
	}
	 
}
