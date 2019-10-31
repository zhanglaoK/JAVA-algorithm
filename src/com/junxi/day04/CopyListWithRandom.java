package com.junxi.day04;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 复制含有随机指针节点的链表
 【题目】 一种特殊的链表节点类描述如下：
 public class Node { public int value; public Node next; public
 Node rand;
 public Node(int data) { this.value = data; }
 }
 Node类中的value是节点值，next指针和正常单链表中next指针的意义
 一 样，都指向下一个节点，rand指针是Node类中新增的指针，这个指
 针可 能指向链表中的任意一个节点，也可能指向null。 给定一个由
 Node节点类型组成的无环单链表的头节点head，请实现一个 函数完成
 这个链表中所有结构的复制，并返回复制的新链表的头节点。 进阶：
 不使用额外的数据结构，只用有限几个变量，且在时间复杂度为 O(N)
 内完成原问题要实现的函数。
 *
 */

public class CopyListWithRandom {

    public static class Node{
        public int value;
        public Node next;
        public Node rand;
        public Node(int value){
            this.value = value;
        }
    }

    public static Node copyListWithRand1(Node head){
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null){
            map.put(cur,new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }



}
