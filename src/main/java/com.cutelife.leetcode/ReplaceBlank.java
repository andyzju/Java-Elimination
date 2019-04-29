package com.cutelife.leetcode;

/**
 * Description:
 * User: tale@wacai.com
 *
 * @author: tale
 * Date: 2019-04-12
 * Time: 上午10:34
 * <p>
 * 回首向来萧瑟处，归去，也无风雨也无晴。
 * ----- 苏轼
 */
public class ReplaceBlank {

    public String replaceSpace(StringBuffer str){

        String res = str.toString().replace(" ","%20");

        return res;

    }

    public static void main(String args[]){

        String str = "We  Are   Happy.";
        System.out.println(new ReplaceBlank().replaceSpace(new StringBuffer(str)));
    }
}
