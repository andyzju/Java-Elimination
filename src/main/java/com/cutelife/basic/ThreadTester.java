package com.cutelife.basic;


class ThreadTesterA implements Runnable {  
	  
    private int counter;  
  
    public void run() {  
        while (counter <= 10) {  
            System.out.print("Counter = " + counter + " ");  
            counter++;  
        }  
        System.out.println();  
    }  
}  
  
class ThreadTesterB implements Runnable {  
  
    private int i;  
  
    public void run() {  
        while (i <= 10) {  
            System.out.print("i = " + i + " ");  
            i++;  
        }  
        System.out.println();  
    }  
}  
  
public class ThreadTester {  
    public static void main(String[] args) throws InterruptedException {  
        Thread t1 = new Thread(new ThreadTesterA());  
        Thread t2 = new Thread(new ThreadTesterB());  
       /* t1.start();  
        t2.start();  
        t1.join(); // wait t1 to be finished  
        t2.join(); // in this program, this may be removed  
*/        
        // ������������̴߳���ִ�У���ô����
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        
    }  
}  