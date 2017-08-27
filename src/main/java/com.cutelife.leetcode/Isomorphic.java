package com.cutelife.leetcode;


import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;


/**
 * Created by andyzju on 2017/8/23.
 */
public class Isomorphic {

    public boolean isIsomorphic(String s, String t) {
        //init check
        if(s==null || t==null) return false;
        if(s.length() != t.length()) return false;

        Map<Character, Character> map = new HashMap<Character, Character>();
        Set<Character> set = new HashSet<Character>();

        for(int i=0; i<s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if(map.containsKey(c1)) {
                if(map.get(c1) != c2) return false;
            } else {
                if(set.contains(c2)) return false;
                else {
                    map.put(c1, c2);
                    set.add(c2);
                }
            }
        }
        return true;
    }


    public static void main(String args[]){

        System.out.println(new Isomorphic().isIsomorphic("egg","add"));

        System.out.println(new Isomorphic().isIsomorphic("foo","bar"));

        System.out.println(new Isomorphic().isIsomorphic("paper","title"));

        System.out.println(new Isomorphic().isIsomorphic("a","a"));

    }
}
