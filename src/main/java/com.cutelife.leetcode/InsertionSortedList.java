package com.cutelife.leetcode;

import java.util.Arrays;

public class InsertionSortedList {

	public int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0)
			throw new IllegalArgumentException("Invalid args");
		// Arrays.sort(ratings); // sort

		int n = ratings.length;
		int num[] = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++)
			num[i] = 1;

		int k = 1;
		for (int i = 1; i < n; i++) {
			if (ratings[i] > ratings[i - 1]) {
				num[i] = Math.max(++k, num[i]);
			} else {
				k = 1;
			}

		}

		k = 1;
		for (int i = n - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				num[i] = Math.max(++k, num[i]);

			} else {
				k = 1;
			}
		}

		for (int i = 0; i < n; i++)
			sum += num[i];
		
		return sum;

	}
	
	public static void main(String args[]){
		int a[]={2,1};
		System.out.println(new InsertionSortedList().candy(a));
	}
}
