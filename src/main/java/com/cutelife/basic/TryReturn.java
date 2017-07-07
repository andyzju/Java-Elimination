package com.cutelife.basic;

public class TryReturn {
	
	public int test(){
		int x=1;
		try{
			return x;
		}finally{
			++x;
			return x;
		}
	}
	public static void main(String args[]){
		System.out.println(new TryReturn().test());
	}

}
