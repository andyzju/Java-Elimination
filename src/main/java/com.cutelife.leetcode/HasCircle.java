package com.cutelife.leetcode;

/**
 * Definition for singly-linked list.
 * */
/*class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
          val = x;
          next = null;
    }
  }*/

public class HasCircle {
    public boolean hasCycle(ListNode head) {
    	
    	if(head==null)
    		return false; // if null then no circle
    	
    	ListNode fast=head;
    	ListNode slow=head;
    	
    	while(fast!=null && fast.next!=null){
    		slow=slow.next;
    		fast=fast.next.next;
    		
    		if(slow==fast)
    			return true;	
    	}
    	/**
    	 * If we want to return the node where slow and fast encounter
    	 *  a=(n-1)*r+L-a-r;
    	 *  
    	 *  2s=s+nr
    	 *  s=nr=(n-1)*r+L-a
    	 *  s=a+x;
    	 *  
    	 *  a=(n-1)*r+L-a-x
    	 */
    	/*if(fast!=null&&fast.next!=null){ // has circle
    		slow=head;
    		while(slow!=fast){
    			slow=slow.next;
    			fast=fast.next;
    		}
    	} */
		return !(fast==null||fast.next==null);   
    }
}