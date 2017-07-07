package com.cutelife.leetcode;

import java.util.HashMap;
import java.util.Vector;
import java.util.Map;
/**
 * Not already resolved
 */
/*class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}*/

public class SortList {

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			throw new IllegalArgumentException("Empty List");

		ListNode pNode = head;
		Map<Integer, Vector<ListNode>> map = new HashMap<Integer, Vector<ListNode>>();
		while (pNode != null) {

			if (map.containsKey(pNode.val)) {
				Vector<ListNode> vList = map.get(pNode.val);
				vList.addElement(pNode);
				map.put(pNode.val, vList);
			}else{
				Vector<ListNode> vList=new Vector<ListNode>();
				vList.add(pNode);
				map.put(pNode.val, vList);
			}
		}
		return head;

	}

}
