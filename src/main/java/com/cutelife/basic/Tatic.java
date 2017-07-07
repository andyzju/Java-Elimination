package com.cutelife.basic;

import java.io.File;

public class Tatic {

	static int a = 1;
	static {
		a = 2;
		System.out.println("this is the static block of Main");

	}
	{
		System.out.println("this is the non static block of Main");
	}
	public Tatic(){
		System.out.println("this is the constructor of Main");
	}

	public static void main(String args[]) {
		
		//Tatic t=new Tatic();
		Sub s=new Sub();
		Sub s1=new Sub();
		System.out.println("main::main");
		
		System.out.println(File.separator);
		System.out.println(File.pathSeparator);
		String fileName="E:"+File.separator+"Hello";
		File f=new File(fileName);
		if(!f.exists())
			f.mkdir();

	}

}

class Sub {
	static {
		System.out.println("this is the static block of sub");
	}
	{
		System.out.println("this is the non static block of sub");
	}

	public Sub() {
		System.out.println("this is the constructor of sub");
	}
}