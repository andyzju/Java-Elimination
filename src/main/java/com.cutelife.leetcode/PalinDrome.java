package com.cutelife.leetcode;

public class PalinDrome {

	public boolean isPalindrome(String s) {
		if (s == null)
			return true;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
					|| (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
					|| (s.charAt(i) >= '0'&& s.charAt(i) <= '9')) {
				sb.append((s.charAt(i)+"").toLowerCase());
			}
		}

		String sbFilter=sb.toString();
		for(int i=0;i<sbFilter.length()/2;i++){
			if(sb.charAt(i)!=sb.charAt(sbFilter.length()-1-i))
				return false;
		}
		return true;
	}
	
	public static void main(String args[]){
		
		String s="A man, a plan, a canal: Panama";
		System.out.println(new PalinDrome().isPalindrome(s));
		
		String s1="A man, a plan, a canal: Panama11";
		System.out.println(new PalinDrome().isPalindrome(s1));
	}

}
