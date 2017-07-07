package com.cutelife.leetcode;

/**
 * consider the exception
 * null +  multi blanks betweem words
 * @author Administrator
 *
 */
public class Solution {
    public String reverseWords(String s) {
        
    	if(s==null)
    		throw new IllegalArgumentException("The string is null");
        String strArr[]=s.trim().split(" ");
        StringBuffer sb=new StringBuffer();
        for(int i=strArr.length-1;i>=1;i--){
        	if(strArr[i]!=""&&!strArr[i].equals(""))
        		sb.append(strArr[i]+" ");
        }
        
        if(strArr.length>0)
        	sb.append(strArr[0]);
        
        return sb.toString();
        
    }
    
    public static void main(String args[]){
    	/*String s="the sky is blue";
    	System.out.println(new Solution().reverseWords(s));
    	
    	String s1="I love China yes";
    	System.out.println(new Solution().reverseWords(s1));*/
    	
    	String s2="   a   b ";
    	System.out.println(new Solution().reverseWords(s2));
    }
}