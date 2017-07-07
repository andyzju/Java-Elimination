package com.cutelife.leetcode;

import java.util.Vector;

/*class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}*/

public class RecorderList {

	public void sortList(ListNode head) {
		if (head == null || head.next == null)
			throw new IllegalArgumentException("Empty list");

		Vector<ListNode> vList = new Vector<ListNode>();
		ListNode pNode = head;
		while (pNode.next != null) {
			vList.add(pNode.next);
			pNode = pNode.next;
		}

		pNode = head;
		for (int i = 0; i <= (vList.size() - 1) / 2; i++) {
			pNode.next = vList.elementAt(i);
			pNode = pNode.next;
			if (i != (vList.size() - 1 - i))
				pNode.next = vList.elementAt(vList.size() - 1 - i);
		}
		pNode.next = null;
	}
	
	public static void main(String args[]){
		
	}

}
