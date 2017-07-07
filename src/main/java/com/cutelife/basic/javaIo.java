package com.cutelife.basic;

import java.util.Scanner;

public class javaIo {

	public static void main(String args[]) {
		/*
		 * String filename="D:"+File.separator; File file=new File(filename);
		 * String arr[]=file.list(); for(int i=0;i<arr.length;i++)
		 * System.out.println(arr[i]); System.out.println(
		 * "============================================================"); File
		 * files[]=file.listFiles(); for(File f:files) System.out.println(f);
		 */

		Scanner scanner = new Scanner(System.in);
		String ip = scanner.nextLine();
		String ips[]=new String[4];
		int cnt=0;
		int start=0;
		for(int i=0;i<ip.length();i++){
			if(ip.charAt(i)=='.')
			{
				ips[cnt++]= (String) ip.subSequence(start, i);
				start=i+1;
			}
		}
		ips[cnt]=(String) ip.subSequence(start, ip.length());
		//String ips[] = ip.split(".");
		Long ipLong = 0L;
		for (int i = 0; i < ips.length; i++) {

			Long temp=(long) (Integer.parseInt(ips[i])*Math.pow(2, 4*(3-i)));
			ipLong+=temp;
		}
		
		System.out.println(ipLong);

	}

}