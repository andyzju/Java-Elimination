package com.cutelife.leetcode;

/**
 * Created by andyzju on 2017/7/18.
 *
 * 经一个字符串中的单词顺序进行逆转而单词本身不逆转；
 * "I am alibaba"  --> "alibaba am I"
 *
 * 非常完美的解决方案，很好
 */
public class WordReverse {


    private char[] reverse(char str[], int begin, int end){
        while(begin <= end){
            char temp = str[begin];
            str[begin] = str[end];
            str[end] = temp;
            begin ++;
            end --;
        }

        return str;
    }
    public char[] wordReverse(String words){

        char[] newWords = reverse(words.toCharArray(), 0 , words.length()-1);

        int idx = 0;
        for(int i=0; i< newWords.length; i++){

            //这里用不是a-z& A-Z 来判断分词;
            if(!((newWords[i] >='a' && newWords[i] <='z') ||( newWords[i]>='A' && newWords[i]<='Z'))){
                reverse(newWords, idx, i-1);
                idx = i+1;
            }

        }

        return newWords;

    }

    public static void main(String args[]){
        System.out.println(new WordReverse().wordReverse(new String("I am    alibaba")));
    }
}
