package com.cutelife.leetcode;

import java.util.HashMap;

/**
 * Description:
 * User: tale@wacai.com
 *
 * @author: tale
 * Date: 2019-04-24
 * Time: 下午9:13
 * <p>
 * 回首向来萧瑟处，归去，也无风雨也无晴。
 * ----- 苏轼
 */
public class Find {

    public int[] getLoc(int nums[],int target){

        HashMap<Integer,Integer> locMap = new HashMap<Integer,Integer>();

        //初始化
        // 构造桶,值和位置的关系
//        for(int i=0;i<nums.length;i++){
//            //lst[nums[i]] = nums[i];
//            locMap.put(nums[i],i);
//        }

        int res[] = new int[2];
        boolean flag = false;
        for(int i=0;i<nums.length;i++){

            int a = nums[i];
            int b = target -a ;

            if(locMap.containsKey(b) && locMap.get(b)!=i){

                res[0] = locMap.get(b);
                res[1] = i ;

                System.out.print(i +" "+locMap.get(b) );
                flag = true;
                break;
            }

            locMap.put(nums[i],i);
        }

        if(!flag){
            return null;
        }
        return res;
    }


    public static void main(String args[]){

        System.out.println(new Find().getLoc(new int[]{2, 7, 11, 15},9));

        System.out.println(new Find().getLoc(new int[]{2, 7, 11, 15},13));

        //System.out.println(new Find().getLoc(new int[]{2, 7, 11, 15},14));
    }

}



