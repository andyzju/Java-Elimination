package com.cutelife.leetcode;

/**
 * Created by andyzju on 2017/7/18.
 * https://leetcode.com/problems/minimum-size-subarray-sum/#/description
 */
public class SubarraySum {

    public int minSubArrayLen(int s, int[] nums) {

        if (nums.length == 0 && s != 0)
            return 0;
        if (s == 0)
            return 0;

        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int idx = i;
            int tempSum = 0;
            for (int j = idx; j < nums.length; j++) {

                tempSum += nums[j];
                int len = 0;
                if (tempSum >= s) {
                    len = (j - idx + 1);
                    if (len <= minLen) {
                        minLen = len;

                        System.out.println(len + "-" +idx + "-" + j);
                    }
                    break;
                }

            }

        }
        return minLen == Integer.MAX_VALUE ? 0: minLen;
    }

    public static void main(String args[]){

        int a[] = new int[]{2,3,1,2,3};

        System.out.println(new SubarraySum().minSubArrayLen(7, a));

    }

}

