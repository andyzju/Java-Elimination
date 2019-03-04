package com.cutelife.leetcode;

/**
 * Created by andyzju on 2017/7/26.
 */
public class MaxSumSubArray {

    public  int getMaxSum(int arr[]){

        int tempSum = 0;
        int maxSum = 0;
        for(int ele: arr){
            tempSum += ele;
            if(tempSum < 0){
                tempSum = 0;
            }

            if(tempSum > maxSum){
                maxSum = tempSum;

            }
        }
        return maxSum;
    }
    public static void main(String args[]){

        int a[] = new int[]{1, -2, 3, 10, -4, 7, 2, -5};

        System.out.println(new MaxSumSubArray().getMaxSum(a));
    }
}
