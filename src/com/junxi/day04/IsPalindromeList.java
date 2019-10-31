package com.junxi.day04;

import java.util.Stack;

/**
 *
 * 判断一个链表是否为回文结构
 【题目】 给定一个链表的头节点head，请判断该链表是否为回
 文结构。 例如： 1->2->1，返回true。 1->2->2->1，返回true。
 15->6->15，返回true。 1->2->3，返回false。
 进阶： 如果链表长度为N，时间复杂度达到O(N)，额外空间复杂
 度达到O(1)。
 *
 */

public class IsPalindromeList {

    //method1   用栈 空间复杂度O（n）
    public static boolean isPalindrome1(Node head){
        Stack<Node> stack = new Stack<Node>();
        Node cur = head;
        while(cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null){
            if(head.val != stack.pop().val){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    //method2   快指针一次走两步，慢指针一次走一步   用半个栈    空间复杂度O（n/2）
    public static boolean isPalindrome2(Node head){
        if(head == null || head.next == null){
            return true;
        }
        Node right = head.next;
        Node cur = head;
        while(cur.next != null && cur.next.next != null){
            right = right.next;
            cur = cur.next.next;
        }
        Stack<Node> stack = new Stack<>();
        while(right != null){
            stack.push(right);
            right = right.next;
        }
        while (!stack.isEmpty()){
            if (head.val != stack.pop().val){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    //method3 快指针一次走两步,慢指针一次走一步,让后半部分指针的指向方向改变，当节点个数为双数时，让最后节点指向null    空间复杂度为O（1）
    public static boolean isPalindrome3(Node head){
        if(head == null || head.next == null){
            return true;
        }
        Node n1 = head;
        Node n2 = head;
        while (n2.next != null && n2.next.next != null){    //找到中间节点
            n1 = n1.next;   //n1指向中点
            n2 = n2.next.next;  //n2指向最后的节点
        }
        n2 = n1.next;   //让n2指向右半部分的第一个节点
        n1.next = null; //让左半部分的最后一个节点指向null
        Node n3 = null; //辅助节点
        while (n2 != null){ //此循环用作右半部分节点指向反转
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        n3 = n1;    //右半部分最后一个节点
        n2 = head;  //左半部分第一个节点
        boolean res = true;

        while (n1 != null && n2 != null){
            if(n1.val != n2.val){
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        n1 = n3.next;
        n3.next = null;
        while (n1 != null){
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }


    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(5);
        Node node4 = new Node(2);
        Node node5 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(isPalindrome3(node1));
    }


}
