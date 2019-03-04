package com.cutelife.leetcode;

import sun.security.util.Length;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by andyzju on 2017/8/27.
 */
public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Set<Integer> appearedNum = new HashSet<Integer>();
        int start = 0, end = 0;
        for(int i = 0; i < nums.length; i++){
            if(!appearedNum.contains(nums[i])){
                appearedNum.add(nums[i]);
                end++;
            } else {
                return true;
            }
            if(end - start  > k) {  //如果超越了k，还没重复，那么可以移除start了，说明k范围无值
                appearedNum.remove(nums[start]);
                start++;
            }
        }
        return false;

    }

    public static void main(String args[]){
        int nums[] = new int[]{1,2,4,1};

        System.out.println(new ContainsDuplicateII().containsNearbyDuplicate(nums, 3));
    }
}
