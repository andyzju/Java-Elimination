package com.cutelife.leetcode;

/**
 * Description: https://leetcode.com/problems/string-to-integer-atoi/
 * User: tale@wacai.com
 *
 * @author: tale
 * Date: 2019-05-08
 * Time: 下午6:46
 * <p>
 * 回首向来萧瑟处，归去，也无风雨也无晴。
 * ----- 苏轼
 */
public class AtoiInteger {

    public int myAtoi(String str) {

        long res = 0;

        int flag = 1;

        for(int i=0;i<str.length();i++){
            if(' ' == str.charAt(i)){
                continue;
            }

            if('-' == str.charAt(i) || '+' == str.charAt(i)){
                if('-' == str.charAt(i)){
                    flag = -1;
                }
                continue;
            }

            if('0' <=  str.charAt(i) && str.charAt(i) <= '9'){
                res = res * 10 + (str.charAt(i) - '0');
            }

            System.out.println(res);
            // 非数字字符
            if(!('0' <=  str.charAt(i) && str.charAt(i) <= '9')){
                if(res!=0){
                    break;
                }else{
                    return 0;
                }
            }

            if(res * flag > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }

            if(res * flag < Integer.MIN_VALUE){

                return Integer.MIN_VALUE;
            }

        }

        return (int)(res * flag);
    }


    public static void main(String args[]){
        System.out.println(new AtoiInteger().myAtoi("  -91283472332"));
    }
}
