package com.cutelife.leetcode;

/**
 * Description:
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * User: tale@wacai.com
 *
 * @author: tale
 * Date: 2019-04-08
 * Time: 上午8:44
 * <p>
 * 回首向来萧瑟处，归去，也无风雨也无晴。
 * ----- 苏轼
 */
public class MultiArrayFind {

    public boolean Find(int target,int [][]array){

        if(array == null){
            return false;
        }
        int m = array.length;
        int n=array[0].length;

        int num = 0;
        for( int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                num ++;
                if(array[i][j]==target){
                    System.out.println(num);
                    return true;
                }else if(target < array[i][j]){
                    break;
                }
            }
        }

        return false;
    }

    public static void main(String args[]){

        int arr[][] = new int[5][5];

        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                arr[i][j] = i*j;
            }
        }

        for(int i=0;i<3;i++){
            for(int j=0;j<4;j++){
                System.out.println(arr[i][j] + " ");
            }
        }

        System.out.println(arr);
        System.out.println(arr.length);
        System.out.println(arr[0].length);

        new MultiArrayFind().Find(3,arr);
    }
}
