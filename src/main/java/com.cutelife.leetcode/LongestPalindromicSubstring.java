package com.cutelife.leetcode;


import com.sun.xml.internal.ws.util.StringUtils;

/**
 *
 */
public class LongestPalindromicSubstring {


    private String longestPalindrome2(String s)
    {
        int len = s.length();
        int maxlen = 1;
        int start = 0;

        for(int i = 0; i < len; i++)//求长度为奇数的回文串
        {
            int j = i - 1, k = i + 1;
            while(j >= 0 && k < len && s.charAt(j) == s.charAt(k))
            {
                if(k - j + 1 > maxlen)
                {
                    maxlen = k - j + 1;
                    start = j;
                }

                j--;
                k++;
            }
        }

        for(int i = 0; i < len; i++)//求长度为偶数的回文串
        {
            int j = i, k = i + 1;
            while(j >= 0 && k < len && s.charAt(j) == s.charAt(k))
            {
                if(k - j + 1 > maxlen)
                {
                    maxlen = k - j + 1;
                    start = j;
                }

                j--;
                k++;
            }
        }

        return s.substring(start, start + maxlen);
    }


    /**
     * 获取最长回文
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {


        int len = s.length();
        int start = 0;
        int maxLength = 1;

        //奇数长度

            for (int i = 0; i < s.length(); i++) {

                int j = i - 1;
                int k = i + 1;

                while(j>=0 && k<len && s.charAt(j) == s.charAt(k)){

                    if(k-j+1 > maxLength){
                        maxLength = k-j+1;
                        start = j;
                    }
                    j--;
                    k++;
                }


            }


            for (int i = 0; i < s.length(); i++) {

                int j = i ;
                int k = i + 1;

                while(j>=0 && k<len && s.charAt(j) == s.charAt(k)){

                    if(k-j+1 > maxLength){
                        maxLength = k-j+1;
                        start = j;
                    }
                    j--;
                    k++;
                }
            }

        System.out.println(start + " " + maxLength);

        return s.substring(start,start + maxLength);

    }

    public static void main(String args[]) {

        System.out.println(new LongestPalindromicSubstring().longestPalindrome("dsasdsasdassss"));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("asds"));

    }
}
