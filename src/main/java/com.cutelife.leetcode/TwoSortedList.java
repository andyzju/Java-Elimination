package com.cutelife.leetcode;

/**
 * Description: https://leetcode.com/problems/merge-two-sorted-lists/
 * User: tale@wacai.com
 *
 * @author: tale
 * Date: 2019-05-29
 * Time: 上午10:15
 * <p>
 * 回首向来萧瑟处，归去，也无风雨也无晴。
 * ----- 苏轼
 */
public class TwoSortedList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode res = new ListNode(0);
        ListNode p = res;

        while(l1!=null || l2!=null){

            if(l1==null){
                res.next = l2;
                break;
            }

            if(l2==null){
                res.next = l1;
                break;
            }


            int left = l1.val;
            int right= l2.val;

            if(left<=right){
                res.next = l1;
                res = res.next;
                l1 = l1.next;
            }else{
                res.next= l2;
                res = res.next;
                l2 = l2.next;
            }

        }

        return p.next;

    }
}
