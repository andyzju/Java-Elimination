package com.cutelife.leetcode;

import java.util.ArrayList;

/**
 * Not easy
 * @author Administrator
 *
 */
public class LetterCombinations {
	
	String number[]={"","","abc","def","ghi","jkl","mno","qprs","tuv","wxyz"};
	
	private void letterCombinationConstruct(String path,ArrayList<String> coms,int step,String digits){
		int n=digits.length();
		if(step==n){
			coms.add(path);
			return;
		}
		
		int num= digits.charAt(step)-'0';
		for(int i=0;i<number[num].length();i++){
			path+=number[digits.charAt(step)-'0'].charAt(i);
			letterCombinationConstruct(path,coms,step+1,digits);
			path=path.substring(0, path.length()-1);
		}
		
	}
	public ArrayList<String> letterCombinations(String digits){
		String path="";
		ArrayList<String> coms=new ArrayList<String>();
		int step=0;
		letterCombinationConstruct(path,coms,step,digits);
		
		return coms;
	}
   
	public static void main(String args[]){
		String path="abcd";
		path=path.substring(0,path.length()-1);
		System.out.println(new LetterCombinations().letterCombinations("23"));
	}
}
