package com.cutelife.basic;

/**
 * Three points
 * join()   
 * volatile
 * synchronized
 * @author Administrator
 *
 */
public class MultiThread extends Thread {

	public static  volatile int n = 0;

	private  static synchronized void inc() {
		try{
			Thread.sleep(1);
		}catch(InterruptedException e){
			
		}
		n++;
	}

	

	public static void main(String args[]) throws InterruptedException {

		Thread threads[]=new Thread[1000];
		for(int i=0;i<1000;i++){
			threads[i]=new Thread(new Runnable(){
				public void run(){
					MultiThread.inc();
				}
			});

		}
		
		for(int i=0;i<1000;i++)
			threads[i].start();
		
		for(int i=0;i<1000;i++)
			threads[i].join();
		
		System.out.println("The final value is:"+MultiThread.n);
	}

}
