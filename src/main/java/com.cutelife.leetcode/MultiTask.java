package com.cutelife.leetcode;

import com.cutelife.basic.MultiThread;

/**
 * Description:
 * User: tale@wacai.com
 *
 * @author: tale
 * Date: 2019-04-25
 * Time: 下午5:23
 * <p>
 * 回首向来萧瑟处，归去，也无风雨也无晴。
 * ----- 苏轼
 */
public class MultiTask{

    private Object o = new Object();


    public void run() {


        synchronized (o){

            while(true){

                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread() + " is running, at" +System.currentTimeMillis());
            }
        }

    }



    public static void main(String args[]){

        MultiTask t=new MultiTask();



    }


}
