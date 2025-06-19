package pratice.test;

public class 유니코드 {
	public static void main(String[] args) {
		char a = '가';
		System.out.println(a);
		System.out.println((int)a);
		System.out.println(Integer.toHexString(a));
		
		int b = 'a';
		System.out.println((char)(b-32));
		
	}
}
