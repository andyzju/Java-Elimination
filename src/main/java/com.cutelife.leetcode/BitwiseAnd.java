package com.cutelife.leetcode;

/**
 * Created by andyzju on 2017/7/16.
 */
public class BitwiseAnd {

    int rangeBitwiseAnd(int m, int n) {
        int i = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            ++i;
        }
        return (m << i);
    }

    public static void main(String args[]){

        System.out.println(new BitwiseAnd().rangeBitwiseAnd(5,8));
    }
}
