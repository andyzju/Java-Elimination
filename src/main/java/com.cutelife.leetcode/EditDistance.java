package com.cutelife.leetcode;

/**
 * Description:编辑距离
 * url:
 * User: tale@wacai.com
 *
 * @author: tale
 * Date: 2019-03-25
 * Time: 上午8:28
 * <p>
 * 回首向来萧瑟处，归去，也无风雨也无晴。
 * ----- 苏轼
 */
public class EditDistance {

    private int min(int a,int b,int c){

        int t= a<=b?a:b;
        return t<=c?t:c;

    }
    private int getDistance(char a[],int len1,char b[], int len2){

        if(len2==0 && len2>=0){
            return len2;

        }

        if(len1>=0 && len2==0){
            return len1;
        }

        int d[][] = new int[len1][len2];
        for(int i=0;i<len1;i++){
             d[i][0]=i;
        }
        for(int j=0;j<len2;j++){
            d[0][j]=j;
        }

        for(int i=1;i<len1;i++){
            for(int j=1;j<len2;j++){
                int f =0 ;
                if(a[i]!=b[j]){
                    f=1;
                }

                int insertion= d[i-1][j]+1;
                int deletion= d[i][j-1]+1;
                int subStrction = d[i-1][j-1]+f;

                d[i][j]= this.min(insertion,deletion,subStrction);
            }

        }

        return d[len1-1][len2-1];

    }

    public static void main(String args[]){

        System.out.println(new EditDistance().getDistance("abcdefg".toCharArray(),7,
                "acchefk".toCharArray(),7));
        System.out.println(new EditDistance().getDistance("abc".toCharArray(),3,
                "abcd".toCharArray(),4));

    }
}
