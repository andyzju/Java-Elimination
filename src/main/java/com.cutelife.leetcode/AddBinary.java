package com.cutelife.leetcode;

import java.util.Stack;

public class AddBinary {

	private String addStr(int len) {

		StringBuffer sb = new StringBuffer();
		while ((len--) != 0)
			sb.append("0");
		return sb.toString();
	}

	private String add(String a, String b, int maxLen) {
		StringBuffer sb = new StringBuffer();
        Stack<Integer> sumSta=new Stack<Integer>();
		int point = 0;
		for (int i = maxLen - 1; i >= 0; i--) {
			int add1 = a.charAt(i) - '0';
			int add2 = b.charAt(i) - '0';
			int sum=add1+add2+point;
			sumSta.push(sum%2);
			point=sum/2;
		}
 
		if(point==1)
			sumSta.push(point);
		
		while(!sumSta.empty()){
			sb.append(sumSta.pop());
		}
		return sb.toString();
	}

	private String addBinary(String a, String b) {

		int len1 = a.length();
		int len2 = b.length();
		int maxLen = len1 > len2 ? len1 : len2;
		if (len1 != maxLen) {
			a = addStr(maxLen - len1) + a;
		}

		if (len2 != maxLen) {
			b = addStr(maxLen - len2) + b;
		}

		System.out.println("a::" + a + " b::" + b);

		return add(a, b, maxLen);
	}

	public static void main(String args[]) {

		System.out.println(new AddBinary().addBinary("111", "1111111"));

	}

}
