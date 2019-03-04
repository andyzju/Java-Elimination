package com.cutelife.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by andyzju on 2017/8/27.
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums){

        Set<Integer> numSet = new HashSet<Integer>();

        if(nums.length == 0)
            return false;

        for(int i=0;i<nums.length;i++){

            if(numSet.contains(nums[i])){
                return true;

            }
            numSet.add(nums[i]);
        }
        return false;
    }
}
