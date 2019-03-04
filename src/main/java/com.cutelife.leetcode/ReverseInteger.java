package com.cutelife.leetcode;

public class ReverseInteger {

    public int reverse(int x) {
        long result = 0;
        int tmp = Math.abs(x);
        while(tmp>0){
            result *= 10;
            result += tmp % 10;
            if(result > Integer.MAX_VALUE){
                return 0;
            }
            tmp /= 10;
        }
        return (int)(x>=0?result:-result);
    }

    public int reverse2(int x) {

        int reverseNum = 0;
        int xback = x;
        while(x!=0){
            reverseNum *=10;
            int n = x%10;

            reverseNum += n;

            if(reverseNum > Integer.MAX_VALUE || reverseNum < Integer.MIN_VALUE){
                return 0;
            }

            int m = x/10;
            x = m;
        }

        return reverseNum;

    }

    public static void main(String args[]){

        System.out.println(new ReverseInteger().reverse2(1234567894
        ));
        System.out.println(new ReverseInteger().reverse2(-123
        ));
    }
}
