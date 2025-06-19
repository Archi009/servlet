package method;

import api.StringUtil;

public class ArrayUtil {
	public int sum(int[] score ) {
		 int res = 0;
		 for(int i = 0; i <score.length;i++) {
			 res += score[i];
		 }
		return res;
	}
	
	public double avg(int a,int b,int c) {
		
		return(a+b+c)/3;
		
	}
}
