package com.junxi.leetcode;

/**
 * leetcode 第二题  两数相加
 *
 *
 *
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *  输入：l1 = [2,4,3], l2 = [5,6,4]
 *  输出：[7,0,8]
 *  解释：342 + 465 = 807.
 *
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 *
 *
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 *
 * 解题思路：变量两条链表的每个节点，逢十进一
 *
 */
public class AddTwoNumbers {

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //创建一个哨兵节点，用于动态指向下一节点
        ListNode calc = new ListNode(0);
        //创建一个返回结果的节点，这个节点指向哨兵节点的头节点
        ListNode result = calc;

        //这个变量主要是为了存储进位
        int temp = 0;
        while(l1 != null || l2 != null){
            int l1temp = 0;
            int l2temp = 0;
            if(l1 != null){
                l1temp = l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                l2temp = l2.val;
                l2 = l2.next;
            }
            int total = l1temp + l2temp + temp;
            temp = total>=10?1:0;
            calc.next = new ListNode(total %10);
            calc = calc.next;
        }
        if(temp == 1){
            calc.next = new ListNode(1);
        }
        return result.next;

    }

}
