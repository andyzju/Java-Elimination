package com.cutelife.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 * User: tale@wacai.com
 *
 * @author: tale
 * Date: 2019-04-25
 * Time: 下午7:32
 * <p>
 * 回首向来萧瑟处，归去，也无风雨也无晴。
 * ----- 苏轼
 */
public class ABCDemo {

    // 通过JDK5中的锁来保证线程的访问的互斥

    private Lock lock = new ReentrantLock();

    // 线程协作

    private Condition condition = lock.newCondition();


    public static void main(String[] args) {
        ABCDemo abc = new ABCDemo();

        // 使用循环可以不局限于只有3个线程 交替, 任意多个都可以.
        PrintThread a = abc.new PrintThread("A", true);
        PrintThread b = abc.new PrintThread("B", false);
        PrintThread c = abc.new PrintThread("C", false);
        PrintThread d = abc.new PrintThread("D", false);

        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(a);

        // 通过线程池执行

        ExecutorService executor = Executors.newFixedThreadPool(4);

        List <String> logLst = new ArrayList <String>();
        for (int i = 1; i <= 20; i++) {
            logLst.add("I am log NO." + i);
        }


        for (int i = 0; i < 5; i++) {
            a.setLog(logLst.get(4 * i + 0));
            System.out.println(a.log);
            executor.execute(a);

            b.setLog(logLst.get(4 * i + 1));
            System.out.println(b.log);
            executor.execute(b);

            c.setLog(logLst.get(4 * i + 2));
            System.out.println(c.log);
            executor.execute(c);

            d.setLog(logLst.get(4 * i + 3));
            System.out.println(d.log);
            executor.execute(d);
        }

        executor.shutdown();//关闭线程池
    }

    class PrintThread implements Runnable {
        private String name;

        private PrintThread next;

        private boolean execute;

        private String log;

        public PrintThread(String name, boolean execute) {
            this.name = name;
            this.execute = execute;
        }

        public PrintThread(String name, PrintThread next, boolean execute) {
            this.name = name;
            this.next = next;
            this.execute = execute;
        }

        public void run() {
            lock.lock();
            try {
                while (true) {

                    if (execute) {
                        // 执行当前业务
                        print();
                        // 当前任务执行完成后 改变执行状态为false
                        execute = false;
                        // 将下一个相邻任务状态设置为true
                        next.setExecute(true);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        // 通知其它任务.
                        condition.signalAll();
                        break;
                    } else {
                        try {
                            // 若非执行状态 即等待.
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } finally {
                lock.unlock();
            }
        }

        public void print() {
            System.out.println(name + " log is " + this.log);
        }

        public void setExecute(boolean execute) {
            this.execute = execute;
        }

        public void setNext(PrintThread next) {
            this.next = next;
        }

        public void setLog(String log){
            this.log = log;
        }

    }

}