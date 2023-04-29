package com.algo.batch;

import java.util.Arrays;
import java.util.List;

public class Test {
	

	public Integer getSum(Integer...sum) {
		 int sumno =0;
		 List<Integer> listno = Arrays.asList(sum);
		
	     listno.forEach(p -> { 
			System.out.println(p);
	
		});
		//System.out.println(sum);
		return null;
		
	}
	
	public static void main(String[] args) {		
		Test util = new Test();
		Integer s = util.getSum();
		Integer a=30;
		Integer b=30;
		Integer c=40;
		Integer d=50;
		util.getSum(a,b,c,d);
		//System.out.println(util.generatePassword("accetmca"));
		
	}

}
