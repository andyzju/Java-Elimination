package com.cutelife.leetcode;

/**
 * Description: https://leetcode.com/problems/swap-nodes-in-pairs/
 * User: tale@wacai.com
 *
 * @author: tale
 * Date: 2019-05-13
 * Time: 上午10:42
 * <p>
 * 回首向来萧瑟处，归去，也无风雨也无晴。
 * ----- 苏轼
 */

public class SwapPairs {

    public ListNode swapPairs(ListNode head) {

        if (head == null) {
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        if (second != null) {
            head = second;
        } else {
            return head;
        }

        ListNode preNode = new ListNode(0);
        while (first != null && second != null) {

            ListNode tmp = second.next;
            second.next = first;
            first.next = tmp;

            preNode.next = second;
            preNode = first;

            if (tmp != null) {
                first = tmp;
                second = tmp.next;
            }
        }

        return head;
    }


    public static void main(String arsg[]) {

        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = null;

        ListNode head = new SwapPairs().swapPairs(one);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

