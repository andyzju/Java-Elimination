package com.cutelife.leetcode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 * User: tale@wacai.com
 *
 * @author: tale
 * Date: 2019-05-30
 * Time: 上午11:38
 * <p>
 * 回首向来萧瑟处，归去，也无风雨也无晴。
 * ----- 苏轼
 */


public class SequencePrint {

    private Lock lock = new ReentrantLock();// 通过JDK5中的锁来保证线程的访问的互斥
    private Condition condition = lock.newCondition();// 线程协作

    public static void main(String args[]){

        SequencePrint sp = new SequencePrint();

        PrintThread a = sp.new PrintThread("a",true);
        PrintThread b = sp.new PrintThread("b",false);
        PrintThread c = sp.new PrintThread("c",false);

        a.setNextThread(b);
        b.setNextThread(c);
        c.setNextThread(a);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for(int i=0;i<10;i++){

            executorService.execute(a);
            executorService.execute(b);
            executorService.execute(c);
        }
    }


    class PrintThread extends Thread{

        private  ThreadLocal<Integer> num = new ThreadLocal <Integer>();


        private String name;
        private Boolean execute;
        private PrintThread nextThread;

        public PrintThread(String name,Boolean execute){
            this.name = name;
            this.execute = execute;
        }

        public void setExecute(Boolean execute){
            this.execute = execute;
        }

        public Boolean getExecute() {
            return this.execute;
        }

        public void setNextThread(PrintThread nextThread) {
            this.nextThread = nextThread;
        }

        private PrintThread getNextThread(){
            return this.nextThread;
        }

        private void print(){
            System.out.println("Thread" + this.getName() + " is print");
        }
        @Override
        public void run() {

            lock.lock();
            try{

                while (true){

                    if(execute){
                        this.print();
                        this.getNextThread().setExecute(true);

                        break;
                    }

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }catch (Exception e){

            }finally {
                lock.unlock();
            }


        }
    }
}
