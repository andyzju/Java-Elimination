package com.cutelife.basic;

import java.util.Vector;

/**
 * Created by andyzju on 2017/7/18.
 */

class Consumer implements Runnable{
    private Vector obj;
    public Consumer(Vector v){
        this.obj = v;

    }

    /**
     *  1. wait 方法的调用主体是vector，也就是对象，不同于sleep() - Thread;
     *  2. wait 在 while循环体中;
     *  3. wait 执行后，通常会释放获取到的锁;
     *  4.
     */

    public void run(){

        synchronized (obj){
            // 获取了vector对象的锁
            // 思考该段代码，如果后续的 obj.wait()没有释放obj锁，
            // 那么由于一直在wait，会导致produce 一直无法进入逻辑，导致没有goods产生，
            // 陷入死循环，正是由于wait执行之后释放了obj的锁，produce才可以进入逻辑

            while(true){
                try {
                    if(obj.size() ==0){
                        System.out.println("vector size is "+ obj.size() +", consumer waiting for goods.");
                        obj.wait(); // 需要非常清晰的明白wait操作含义以及所做的事情
                    }

                    System.out.println("consumer goods, and vector size is "+ obj.size());

                    obj.remove(obj.size()-1);
                    obj.notify(); //通知produce 可以生成了
                }catch (Exception e){
                    e.printStackTrace();
                }

            }

        }

    }
}

class Produce implements Runnable{
    private Vector obj;
    public Produce(Vector v){
        this.obj = v;

    }

    public void run(){
        synchronized (obj){

            while(true) {
                try {

                    if (obj.size() == 10) { // 10个代表满了，那么此时需要等待
                        obj.wait();
                        System.out.println("vector size is " + obj.size() + ", produce waiting for space.");

                    }
                    System.out.println("vector size is " + obj.size() + ", produce start to produce goods.");

                    obj.add(new String("content"));
                    obj.notify();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
public class WatiNotify {

    public static void main(String args[]){

        Vector obj = new Vector();
        Thread consumere = new Thread(new Consumer(obj));
        Thread producer = new Thread(new Produce(obj));

        consumere.start();
        producer.start();

    }
}
