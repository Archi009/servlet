package method;

public class StringUtilTest {
	public static void main(String[] args) {
		StringUtil su = new StringUtil();
		
		String a = "hello";
		String b = su.upper(a);
		System.out.println(a);
		System.out.println("b  : " + b);
		System.out.println("==========================================================");
		
		
		String[] arr = new String[] {"hello","scott"};
		su.upper(arr);
		System.out.println(arr[0]);
	}
}
