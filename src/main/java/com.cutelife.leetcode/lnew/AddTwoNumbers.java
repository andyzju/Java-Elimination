package com.cutelife.leetcode.lnew;

import java.util.List;

/**
 * Description:
 * User: tale@wacai.com
 *
 * @author: tale
 * Date: 2019-04-16
 * Time: 下午5:40
 * <p>
 * 回首向来萧瑟处，归去，也无风雨也无晴。
 * ----- 苏轼
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class AddTwoNumbers {

    /**
     * 从链表中逆序求得返回值
     * @param list
     * @return
     */
    private Integer getNumFromList(ListNode list){

        int num =0;
        int i = 0;
        while(list!=null){
            num+= list.val * Math.pow(10,i);
            list = list.next;
            i++;
        }
        return num;
    }


    /**
     * 从数字中获取list
     * @param num
     * @return
     */
    private ListNode getListFromNum(Integer num){

        if(num == 0){
            ListNode ln = new ListNode(0);
            ln.next = null;
            return ln;
        }

        ListNode head = new ListNode(0);
        ListNode p = head;
        while(num!=0){
            ListNode ln = new ListNode(num%10);
            ln.next = null;
            num/=10;
            p.next = ln;
            p = ln;
        }
        return head.next;

    }

    /**
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Integer num1 = this.getNumFromList(l1);

        System.out.println(num1);
        Integer num2 = this.getNumFromList(l2);

        System.out.println(num2);



        return this.getListFromNum(num1 + num2);

    }



    public static void main(String args[]){

        ListNode p1 = new ListNode(2);
        ListNode p2 = new ListNode(4);
        ListNode p3 = new ListNode(3);
        p3.next =null;
        p1.next=p2;
        p2.next=p3;


        ListNode q1 = new ListNode(5);
        ListNode q2 = new ListNode(6);
        ListNode q3 = new ListNode(4);
        q3.next =null;
        q1.next=q2;
        q2.next=q3;

        System.out.println(new AddTwoNumbers().addTwoNumbers(p1,q1));

    }
}
