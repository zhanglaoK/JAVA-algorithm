package com.junxi.leetcode;

/**
 * Leetcode 21题  21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 *
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *
 */
public class MergeTwoLists {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode temp = res;
        while(l1!=null && l2 != null){
            if(l1.val> l2.val){
                temp.next=l2;
                l2 = l2.next;
            }else{
                temp.next=l1;
                l1 = l1.next;
            }
            temp = temp.next;
        }
        if(l1 == null){
            temp.next = l2;
        }
        if(l2 == null){
            temp.next = l1;
        }
        return res.next;
    }
}
