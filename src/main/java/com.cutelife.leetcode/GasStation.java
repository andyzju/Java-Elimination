package com.cutelife.leetcode;

/*
 * http://oj.leetcode.com/problems/gas-station/
 *  ��ʵ���������ֶε�����
 */
public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {

		if (gas == null || cost == null || gas.length == 0 || cost.length == 0) {
			throw new IllegalArgumentException("Invalid arguments");
		}

		int n = gas.length;
		int diff[] = new int[n];
		for (int i = 0; i < n; i++) {
			diff[i] = gas[i] - cost[i];
		}

		int sum = 0;
		int totalSum = 0;
		int start = -1;

		for (int i = 0; i < n; i++) {
			sum += diff[i];
			totalSum += diff[i];
			if (sum < 0) {
				sum = 0;
				start = i;
			}
			/*
			 * if(sum>totalSum){ totalSum=sum; }
			 */
		}

		return totalSum >= 0 ? start + 1 : -1;  // equals

	}

	public static void main(String args[]) {
		int gas[] = { 1, 2, 3, 4, 7 };
		int cost[] = { 4, 5, 3, 2, 1 };
		System.out.println(new GasStation().canCompleteCircuit(gas, cost));
	}
}
