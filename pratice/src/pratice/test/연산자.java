package pratice.test;

public class 연산자 {
	public static void main(String[] args) {
		//암호화/복호화
		int a = 10;
		int key = 'a';
		System.out.println("원문:"+ a);

		int b = a ^ key;
		System.out.println("암호화:"+ b);

		int c = b ^ key;
		System.out.println("복호화:"+ c);
	}
}
