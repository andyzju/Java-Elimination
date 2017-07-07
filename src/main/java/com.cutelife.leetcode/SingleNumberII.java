package com.cutelife.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class SingleNumberII {
	public int singleNumber(int[] A) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int single=A[0];

		for (int i = 0; i < A.length; i++) {
			if (map.containsKey(A[i])) {
				map.put(A[i], map.get(A[i]) + 1);
			} else {
				map.put(A[i], 1);
			}
		}

		//Iterator<Integer> ite = map.keySet().iterator();
		Iterator<Map.Entry<Integer, Integer>> ite=map.entrySet().iterator();  // how to retrieve the map
		while (ite.hasNext()) {
			//int x=ite.next();
			Entry<Integer,Integer> e=ite.next();
			if(e.getValue()!=3){
				single=e.getValue();
				break;
			}
		}
		return single;
	}

}
