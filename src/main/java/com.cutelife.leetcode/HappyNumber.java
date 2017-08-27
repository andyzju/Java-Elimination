package com.cutelife.leetcode;

/**
 * Created by andyzju on 2017/7/26.
 */
public class HappyNumber {

    public int getSquareSum(int n){
        int sum = 0;
        // n = 123

        while(n/10 != 0){
            int x = n%10;
            System.out.println(x);
            sum += x * x;
            n = n /10;
        }

        sum += n*n;

        return sum;
    }

    public boolean isHappy(int n){

        if(n==0 || n==4 )
            return false;
        if(n==1)
            return true;

        int squareSum = getSquareSum(n);

        return isHappy(squareSum);

    }

    public static void main(String args[]){

        System.out.println(new HappyNumber().isHappy(2));
    }
}
