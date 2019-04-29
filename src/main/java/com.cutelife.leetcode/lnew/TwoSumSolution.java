package com.cutelife.leetcode.lnew;


import java.util.HashMap;

/**
 * Description:
 * User: tale@wacai.com
 *
 * @author: tale
 * Date: 2019-04-17
 * Time: 下午12:02
 * <p>
 * 回首向来萧瑟处，归去，也无风雨也无晴。
 * ----- 苏轼
 */
public class TwoSumSolution {

    public int[] twoSum(int[] nums, int target) {

        int res[] = new int[2];

        HashMap<Integer,Integer> map = new HashMap <Integer, Integer>();

        for(int i=0; i<nums.length;i++){
            map.put(nums[i],i);
        }

        for(int i = 0;i<nums.length;i++){

            int p = target - nums[i];
            if(map.containsKey(p) && map.get(p)!=i){
                res[0] = i;
                res[1] = map.get(p);
                break;
            }
        }

        return res;
    }

    public static void main(String args[]){

        System.out.println(new TwoSumSolution().twoSum(new int[]{2,7,11,15,18,27},26));

    }
}
