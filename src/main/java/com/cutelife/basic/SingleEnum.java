package com.cutelife.basic;

public enum SingleEnum {
	SINGLE("Singleton");
	private String name=null;
	private SingleEnum(String name){
		this.name=name;
	};
	public void say(){
		System.out.println("I am::"+this);
	}
	
	public static void main(String args[]){
		SingleEnum.SINGLE.say();
		SingleEnum.SINGLE.say();
	}
	

}
