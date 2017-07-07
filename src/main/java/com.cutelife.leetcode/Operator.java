package com.cutelife.leetcode;
/*package com.leeCode;

import java.util.Stack;

*//**
 * equals and ==
 * make the same mistakes once again
 * @author Administrator
 *
 *//*
public class Operator {
	public int evalRPN(String[] tokens) {
		int result = 0;
		int num1 = 0;
		int num2 = 0;
		Stack<Integer> numSta = new Stack<Integer>();
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*")
					|| tokens[i].equals("/")) {

				if (!numSta.empty()) {
					num2 = (int) numSta.pop();
				} else {
					throw new IllegalArgumentException("Invalid Input");
				}
				if (!numSta.empty()) {
					num1 = (int) numSta.pop();
				} else {
					throw new IllegalArgumentException("Invalid Input");
				}
				
			switch (tokens[i]) {
				case "+":
					result = num1 + num2;
					numSta.add(result);
					break;
				case "-":
					result = num1 - num2;
					numSta.add(result);
					break;
				case "*":
					result = num1 * num2;
					numSta.add(result);
					break;
				case "/":
					result = num1 / num2;
					numSta.add(result);
					break;	
				default:
					throw new IllegalArgumentException("Invalid Input");
			}// switch

			}else if (!(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*")
					|| tokens[i].equals("/"))) {
				
				numSta.add(Integer.parseInt(tokens[i]));
			}
		}
		return  numSta.peek();
	}
	public static void main(String args[]){
		
		String s1[]={"2", "1", "+", "3", "*"};
		
		System.out.println(new Operator().evalRPN(s1));
		
		String s2[]={"4", "13", "5", "/", "+"};
		
		System.out.println(new Operator().evalRPN(s2));
		
		String s3[]={"0","3","/","4"};
		
		System.out.println(new Operator().evalRPN(s3));
		
	}

}
*/