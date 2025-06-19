package pratice.test;

public class 문자열형변환 {
	public static void main(String[] args) {
		String str1 = "12.56";
		double d = Double.parseDouble(str1);

		String str2 = "3000";
		int i =  Integer.parseInt(str2);

		str2 = String.valueOf(i);
		str1 = String.valueOf(d);
		System.out.println(str2.equals(d));
	}
}
