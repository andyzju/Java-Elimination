package com.cutelife.leetcode.lnew;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * 求出最大的连续子序列的长度
 * User: tale@wacai.com
 *
 * @author: tale
 * Date: 2019-04-17
 * Time: 上午10:37
 * <p>
 * 回首向来萧瑟处，归去，也无风雨也无晴。
 * ----- 苏轼
 */
public class LongestsSubstring {

    /**
     * 存在重复返回true，否则返回false
     * @param str
     * @return
     */
    private boolean containDuplicateChar(String str){

        Set<Character> charSet = new HashSet <Character>();
        int i = 0;
        while(i<str.length()){
            charSet.add(str.charAt(i));
            i++;
        }

        // 相同则无重复
        return str.length() != charSet.size();
    }

    public int lengthOfLongestSubstring(String s) {

        int start = 0;
        int end  = 1;
        int maxLength = 0;
        if(s==null){
            return 0;
        }
        if(s.length() ==1){
            return 1;
        }
        while(start<=s.length()-1 && end<=s.length()){

            String subString  = s.substring(start,end);
            if(!containDuplicateChar(subString)){
                // 如果不重复
                end++;
                maxLength = maxLength>subString.length()?maxLength:subString.length();
            }else{
                start++;
            }

        }

        return maxLength;
    }


    public static void main(String args[]){

        System.out.println(new LongestsSubstring().lengthOfLongestSubstring("abbdabcbb"));
    }
}
