package com.cutelife.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 * User: tale@wacai.com
 *
 * @author: tale
 * Date: 2019-04-28
 * Time: 上午10:08
 * <p>
 * 回首向来萧瑟处，归去，也无风雨也无晴。
 * ----- 苏轼
 */
public class TripleSumZero {


    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length-2; ++i) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int target = -nums[i];
            int l = i+1, r = nums.length-1;
            while (l < r) {
                if (nums[l]+nums[r] > target) {
                    r--;
                }
                else if (nums[l] + nums[r] < target) {
                    l++;
                }
                else {
                    ret.add(Arrays.asList(nums[i], nums[l++], nums[r--]));
                    while (l < r && nums[l] == nums[l-1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r+1]) {
                        r--;
                    }
                }
            }
        }
        return ret;
    }

    public static void main(String args[]){

        System.out.println(new TripleSumZero().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }


}
