package com.cutelife.leetcode;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	
	/*private static WordBreak wb=new WordBreak();
	private boolean containSingleWord(String word,Set<String> dict){
		
		return dict.contains(word);
	}
	public boolean wordBreak(String s,Set<String> dict){
		if(s==null||dict.size()==0)
			return false;
		for(int i=0;i<s.length();i++){
			String temp=s.substring(0,i+1);
			if(containSingleWord(temp,dict))
			{
				if(i==(s.length()-1))
					return true;
				return wb.wordBreak(s.substring(i+1,s.length()),dict);
			}else{
				if(i==(s.length()-1))
					return false;
				continue;
			}
		}
		return false;
	}*/
	
	public boolean wordBreak(String s, Set<String> dict) {
		if (s == null || dict.size() == 0)
			return false;
		boolean dp[] = new boolean[s.length() + 1];
		
		
		dp[0]=true;
		
		for(int i=1;i<=s.length();i++){
			for(int k=0;k<i;k++){
				if(dp[k]&&dict.contains(s.substring(k, i)))
					dp[i]=true;
			}
		}

		for(int i=1;i<=s.length();i++)
			System.out.print(i+"-"+dp[i]);
		System.out.println();
		return dp[s.length()];
	}
     
	public static void main(String args[]){
		String s="catsanddog";
		Set<String> dict=new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("catsa");
		dict.add("and");
		dict.add("nd");
		dict.add("sand");
		dict.add("dog");
		System.out.print(new WordBreak().wordBreak(s,dict));
	}
}
