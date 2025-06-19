package method;

import java.util.function.IntPredicate;

public class ArrayUtilTest {
	public static void main(String[] args) {
		ArrayUtil au = new ArrayUtil();
		int[] score = new int[] {100,90,80};
		int result = au.sum(score);
		System.out.println(result);
		
		
		int kor = 10,eng=20,mat=30;
		
		double res = au.avg(kor, eng, mat);
		System.out.println(res);
		
		
		
	}
}
