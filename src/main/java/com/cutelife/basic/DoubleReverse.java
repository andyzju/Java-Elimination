package com.cutelife.basic;

/**
 * used to double reverse the String with special string
 * e.g.   I love you China.  ---> China. you love I
 * @author Administrator
 *
 */

public class DoubleReverse {
	
	public String swapStr(String str){
		StringBuffer sbuffer=new StringBuffer(str);
		sbuffer.reverse();
		return sbuffer.toString();
	}
	public String getStr(String in,String seq){
		String result=null;
		if(!in.contains(seq)){
			throw new IllegalArgumentException("Illegal String.");
		}
		
		String [] strArr=in.split(seq);
		
		StringBuffer sb=new StringBuffer();
		
		for(int i=0;i<strArr.length-1;i++){
			sb.append(swapStr(strArr[i]));
			sb.append(seq);
		}
		sb.append(swapStr(strArr[strArr.length-1]));
		
		result=swapStr(sb.toString());
		return result;
	}

	public static void main(String args[]){
		String str="I love you China.";
		System.out.println(new DoubleReverse().getStr(str, " "));
		
		String str2="I#love##you###China.";
		System.out.println(new DoubleReverse().getStr(str2, "#"));
		
		String str3="I#love#you#China.";
		System.out.println(new DoubleReverse().getStr(str3, "#"));
		
	}
}
