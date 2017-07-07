package com.cutelife.basic;

public class DaemonThread extends Thread{
	public DaemonThread(){};
	public void run(){
		for(int i=0;i<10;i++){
			try {
				sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("This is daemon thread::"+i);
		}
	}
	
	public static void main(String args[]){
		
		AThread athread=new AThread();
		DaemonThread dthread=new DaemonThread();
		athread.setDaemon(false);
		dthread.setDaemon(true);	
		
		athread.start();
		/*try {
			athread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		dthread.start();
	}

	static class AThread extends Thread{
		public AThread(){
			
		}
		public void run(){
			for(int i=0;i<10;i++){
				try {
					sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("This is AThread::"+i);
			}
		}
	}
}
