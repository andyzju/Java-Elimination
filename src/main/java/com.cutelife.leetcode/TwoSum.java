package com.cutelife.leetcode;

import java.util.HashMap;

/**
 * Description:
 * User: tale@wacai.com
 *
 * @author: tale
 * Date: 2019-06-02
 * Time: 下午11:14
 * <p>
 * 回首向来萧瑟处，归去，也无风雨也无晴。
 * ----- 苏轼
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        int res[] = new int[2];

        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0;i<nums.length;i++){

            int p = target - nums[i];
            if(map.containsKey(p) && map.get(p)!=i){
                res[0] = map.get(p);
                res[1] = i;
                break;
            }

            map.put(nums[i],i);
        }

        return res;
    }
}
