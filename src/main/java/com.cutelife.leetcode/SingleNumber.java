package com.cutelife.leetcode;

public class SingleNumber {
	
	public int SingleNumber(int []A){
		int num=0;
		for(int i=0;i<A.length;i++)
			num^=A[i];
		return num;
	}

}
