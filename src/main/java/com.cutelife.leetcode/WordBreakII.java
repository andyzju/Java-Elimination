package com.cutelife.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Administrator
 * 
 */
public class WordBreakII {
	/**
	 * NOT REALLY KNOW THE ALGORITHM
	 * 
	 * @param s
	 * @param dict
	 * @return
	 */
	public static ArrayList<String> wordBreak(String s, Set<String> dict) {
		ArrayList<String> results = new ArrayList<String>();
		StringBuilder re = new StringBuilder();
		ArrayList<ArrayList<Integer>> dp = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < s.length() + 1; i++) {
			dp.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < s.length(); i++) {
			if (i > 0 && dp.get(i).size() == 0)
				continue;
			for (String e : dict) {
				int end = i + e.length();
				if (end > s.length())
					continue;
				String sub = s.substring(i, end);
				if (sub.equals(e))
					dp.get(end).add(i);
			}
		}
		helper(results, re, s, dict, dp, s.length(), 0);
		return results;
	}

	public static void helper(ArrayList<String> results, StringBuilder re,
			String s, Set<String> dict, ArrayList<ArrayList<Integer>> dp,
			int cur, int step) {
		if (cur == 0) {
			results.add(re.toString());
			return;
		}
		for (int p : dp.get(cur)) {
			if (step > 0)
				re.insert(0, " ");
			re.insert(0, s.substring(p, cur));
			helper(results, re, s, dict, dp, p, step + 1);
			re.delete(0, cur - p);
			if (step != 0)
				re.deleteCharAt(0);
		}
	}

	public static void main(String args[]) {
		String s = "catsanddog";
		Set<String> dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("catsa");
		dict.add("and");
		dict.add("nd");
		dict.add("sand");
		dict.add("dog");
		System.out.print(new WordBreakII().wordBreak(s, dict));
	}
}
