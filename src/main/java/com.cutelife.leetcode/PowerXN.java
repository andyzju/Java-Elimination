package com.cutelife.leetcode;

/**
 * Description:
 * User: tale@wacai.com
 *
 * @author: tale
 * Date: 2019-05-08
 * Time: 上午10:52
 * <p>
 * 回首向来萧瑟处，归去，也无风雨也无晴。
 * ----- 苏轼
 */
public class PowerXN {


    private double power(double x, int n){

        double res =1.0;
        for(int i=0;i<n;i++){
            res *= x;
        }
        return res;
    }
    public double myPow(double x, int n) {

        if(x == 0){
            return 0;
        }
        if(n==0){
            return 1;
        }

        if(n>0){
            return this.power(x,n);
        }
        if(n<0){
            return this.power(1.0/x,Math.abs(n));
        }

        return 1;
    }

    public static void main(String args[]){


        System.out.println(new PowerXN().myPow(2.1,3));
        System.out.println(new PowerXN().myPow(2,-4));

        System.out.println(new PowerXN().myPow(2,10));

        System.out.println(new PowerXN().myPow(2,0));

        System.out.println(new PowerXN().myPow(0,0));

        System.out.println(new PowerXN().myPow(0,10));

    }

}
