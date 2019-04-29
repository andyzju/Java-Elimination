package com.cutelife.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * User: tale@wacai.com
 *
 * @author: tale
 * Date: 2019-04-24
 * Time: 下午9:19
 * <p>
 * 回首向来萧瑟处，归去，也无风雨也无晴。
 * ----- 苏轼
 *
 */


public class MultiLog implements Runnable{


    private static List<String> logList;

    private static int num = 0;

    private String name;
    private String log;
    public MultiLog(){

    }


    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        }catch (Exception e){

        }

        String log = logList.get(num++);
        System.out.println(Thread.currentThread().getName() + "::print::"+ log);

    }

    public static void main(String args[]){


        List<String> logListT = new ArrayList <String>();
        for(int i = 0;i<20;i++){
            logListT.add("I am log no."+i);
        }


        MultiLog.logList = logListT;

            Thread a = new Thread(new MultiLog());
            Thread b = new Thread(new MultiLog());
            Thread c = new Thread(new MultiLog());
            Thread d = new Thread(new MultiLog());

            a.start();
            b.start();
            c.start();
            d.start();

    }
}
