package com.cutelife.leetcode;

/**
 * Description: 求最大子序列
 * 前提条件，没有负数，如果都是负数，则是求最小值
 * User: tale@wacai.com
 *
 * @author: tale
 * Date: 2019-04-24
 * Time: 下午8:13
 * <p>
 * 回首向来萧瑟处，归去，也无风雨也无晴。
 * ----- 苏轼
 */
public class MaxSubString {


    /**
     * 求最大负数
     * @param nums
     * @return
     */
    private int maxNum(int nums[]) {

        int max = Integer.MIN_VALUE;
        for (int e : nums) {

            if (e >= max) {
                max = e;
            }
        }

        return max;
    }

    /**
     * 判断是否所有数值为负数
     * @param nums
     * @return
     */
    private boolean allNegative(int nums[]) {

        boolean flag = false;

        for (int e : nums) {
            if (e >= 0) {
                flag = true;
            }
        }

        return !flag;

    }

    /**
     *
     * @param nums
     * @return
     */
    public Integer maxSum(int nums[]) {


        if (this.allNegative(nums)) {
            return this.maxNum(nums);
        }
        // 下列为不是所有都是负数情况
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum < 0) {
                sum = 0;
            }

            if (sum >= maxSum) {
                maxSum = sum;
            }
        }

        return maxSum;

    }

    public static void main(String args[]) {


        System.out.println(new MaxSubString().maxSum(new int[]{-1, 2, 3, 4, -9, 10, 12, 23, -10}));

        System.out.println(new MaxSubString().maxSum(new int[]{-11, -1, -3, -4, -9, -10, -12, -23, -10}));
    }
}
