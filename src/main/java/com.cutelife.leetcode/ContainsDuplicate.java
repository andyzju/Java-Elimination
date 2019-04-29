package com.cutelife.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by andyzju on 2017/8/27.
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums){


        HashSet<Integer> hs = new HashSet <Integer>();

        for(int i=0;i<nums.length;i++){
            hs.add(nums[i]);
        }

        return hs.size() != nums.length;
    }

    public static void main(String args[]){

        System.out.print(new ContainsDuplicate().containsDuplicate(new int[]{1,2,3,4,5,6}));
    }


}
