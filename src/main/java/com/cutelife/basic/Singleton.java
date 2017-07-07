package com.cutelife.basic;

public class Singleton {

	private Singleton() {
	};
	
	public void say() {
		System.out.println("My object is::" + this);
	}
	
	/*
	 * ����ģʽ
	 */
	/*private static Singleton single = new Singleton();
	public static Singleton getSingleton() {
		return single;
	}
*/
	
	/*
	 * ����ģʽ
	 */
	
/*	private static Singleton single=null;
	public static Singleton getSingleton(){
		if(single==null)
			single=new Singleton();
		return single;	
	}
	*/

	/*
	 * ������̬�ڲ���
	 */
	
	/*private static class SingletonHolder{
		private final static Singleton single=new Singleton();
	}
	public static Singleton getSingleton(){
		return SingletonHolder.single;
	}*/
	
	/*
	 * double check ,�����ڶ��߳����
	 */
	private static Singleton single=null;
	public static Singleton getSingleton(){
		if(single==null){
			synchronized(Singleton.class){
				if(single==null){
					single=new Singleton();
				}
			}
		}
		return single;
	}
	
	public static void main(String aa[]) {
		Singleton single1 = Singleton.getSingleton();
		Singleton single2 = Singleton.getSingleton();
		
		single1.say();
		single2.say();
	}

}
