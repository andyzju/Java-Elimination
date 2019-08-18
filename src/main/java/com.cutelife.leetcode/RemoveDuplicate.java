package com.cutelife.leetcode;

/**
 * Description:
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * User: tale@wacai.com
 *
 * @author: tale
 * Date: 2019-06-02
 * Time: 下午10:40
 * <p>
 * 回首向来萧瑟处，归去，也无风雨也无晴。
 * ----- 苏轼
 */
public class RemoveDuplicate {

    public int removeDuplicates(int nums[]){

        if(nums==null || nums.length==0){
            return 0;
        }

        if(nums.length==1){
            return 1;
        }

        int p=0;

        for(int i=1;i<nums.length;i++){

            if(nums[i]!=nums[p]){
                nums[p+1]=nums[i];
                p++;
            }else{
                continue;
            }
        }

        return p+1;

    }

    public static void main(String args[]){

        System.out.println(new RemoveDuplicate().removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }
}
