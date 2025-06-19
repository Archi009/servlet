package pratice.test;

public class 형변환 {
	public static void main(String[] args) {
		int a = 5 / 2;
		System.out.println("int               :"   +a);
		double b = 5 / 2;
		System.out.println("double              :"   +b);
//		int c = 5 / (double) 2; 
		double c = 5 / (double) 2; 

		short s = a; //<4byte인 int를 2byte인 short에 넣으려니까 오류남
		double d3 = a;

		System.out.println(a);
		System.out.println(b);
	}
}
