package com.cutelife.leetcode;

import java.util.HashMap;
import java.util.Map;

import static javax.swing.UIManager.put;

/**
 * Description:
 * User: tale@wacai.com
 *
 * @author: tale
 * Date: 2019-05-13
 * Time: 上午10:22
 * <p>
 * 回首向来萧瑟处，归去，也无风雨也无晴。
 * ----- 苏轼
 */
public class RomToInteger {


    private static Map <Character, Integer> tagMap = new HashMap <Character, Integer>();

    private static void init() {

        tagMap.put('I', 1);
        tagMap.put('V', 5);
        tagMap.put('X', 10);
        tagMap.put('L', 50);
        tagMap.put('C', 100);
        tagMap.put('D', 500);
        tagMap.put('M', 1000);
    }

    /**
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {

        init();

        int res = 0;
        int prev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {

            Integer value = tagMap.get(s.charAt(i));
            if(value!=null && value > prev){
                res += value;
            }else if(value!=null && value<prev){
                res -= value;
            }

            prev = value;

        }

        return res;

    }


    public static void main(String args[]){

        System.out.println(new RomToInteger().romanToInt("MCDL"));

        System.out.println(new RomToInteger().romanToInt("CDL"));
    }

}
