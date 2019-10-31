package com.junxi.day04;
/**
 *
 * 两个单链表相交的一系列问题
 【题目】 在本题中，单链表可能有环，也可能无环。给定两个
 单链表的头节点 head1和head2，这两个链表可能相交，也可能
 不相交。请实现一个函数， 如果两个链表相交，请返回相交的
 第一个节点；如果不相交，返回null 即可。 要求：如果链表1
 的长度为N，链表2的长度为M，时间复杂度请达到 O(N+M)，额外
 空间复杂度请达到O(1)。
 *
 */

public class FindFirstIntersectNode {

    public static Node getIntersectNode(Node head1,Node head2){
        if(head1 == null || head2 == null){
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if(loop1 == null && loop2 == null){
            return noLoop(head1,head2);
        }
        if(loop1 != null && loop2 != null){
            return bothLoop(head1, loop1, head2, loop2);
        }

        return null;
    }


    //两个无环链表相交问题，大体思路，先让两个链表都遍历完，如果最后一个节点不相等，那他们肯定不相交；
    public static Node noLoop(Node head1,Node head2){
        if(head1 == null || head2 == null){
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while (cur1 != null){
            n++;
            cur1 = cur1.next;
        }
        while (cur2 != null){
            n--;
            cur2 = cur2.next;
        }
        if(cur1 != cur2){
            return null;
        }
        cur1 = n > 0 ? head1:head2;
        cur2 = cur1 == head1 ? head2:head1;
        n = Math.abs(n);
        while (n != 0){
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }


    //两个有环链表相交问题
    /**
     * 两个有环链表
     * @param head1 第一个链表的头节点
     * @param loop1 第一个链表的入环节点
     * @param head2 第二个链表的头节点
     * @param loop2 第二个链表的入环节点
     * @return Node 两个链表第一次相交的节点
     */
    public static Node bothLoop(Node head1,Node loop1,Node head2,Node loop2){
        Node cur1 = null;
        Node cur2 = null;
        if(loop1 == loop2){
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1){
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2){
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1:head2;
            cur2 = cur1 == head1 ? head2:head1;
            n = Math.abs(n);
            while (n != 0){
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return  cur1;
        }else {
            cur1 = loop1.next;
            while (cur1 != loop1){
                if(cur1 == loop2){
                    return  loop1;
                }
                cur1 = cur1.next;
            }
            return  null;
        }
    }





    //判断链表是否有环：简单的方式就是利用hashMap或者hashSet，但是这样会用到额外空间；
    //这里用高级一点的，判断链表是否有环：快指针一次走两步，慢指针一次走一步，当快指针走到null时，则链表无环；如果快慢指针相遇，则有环，此时快指针回到头节点，然后快慢指针都一步一步走，第一次相遇的那个节点就是入环节点

    public static Node getLoopNode(Node head){
        if(head == null || head.next == null || head.next.next == null){
            return null;
        }
        Node n1 = head.next;    //慢指针
        Node n2 = head.next.next;   //快指针
        while(n1 != n2){
            if(n2.next == null || n2.next.next == null){
                return null;
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }
        n2 = head;
        while (n1 != n2){
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

}
