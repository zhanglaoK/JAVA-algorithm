package com.junxi.day04;

/**
 * 类似day02包下的荷兰国旗问题，只不过这里是链表实现
 */
public class SmallerEqualBigger {

    public static Node listPartition1(Node head,int num){
        if(head == null){
            return head;
        }
        Node cur = head;
        int i = 0;
        while (cur != null){
            i++;
            cur = cur.next;
        }
        Node [] nodeArr = new Node[i];
        i = 0;
        cur = head;
        for (i=0;i != nodeArr.length;i++){
            nodeArr[i] = cur;
            cur = cur.next;
        }
        arrPartition(nodeArr,num);
        for(i = 1;i<nodeArr.length;i++){
            nodeArr[i-1].next = nodeArr[i];
        }
        nodeArr[i-1].next = null;
        return nodeArr[0];
    }

    public static void arrPartition(Node [] nodeArr,int num){
        int small = -1;
        int big = nodeArr.length;
        int index = 0;
        while (index < big){
            if(nodeArr[index].val < num){
                swap(nodeArr,++small,index++);
            }else if(nodeArr[index].val == num){
                index++;
            }else {
                swap(nodeArr,--big,index);
            }
        }
    }

    public static void swap(Node []nodeArr,int a,int b){
        int temp = nodeArr[a].val;
        nodeArr[a].val = nodeArr[b].val;
        nodeArr[b].val = temp;
    }


    public static Node listPartition2(Node head,int num){
        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node bH = null;
        Node bT = null;
        Node next = null;
        while (head != null){
            next = head.next;
            head.next = null;

            if(head.val < num){
                if(sH == null){
                    sH = head;
                    sT = head;
                }else {
                    sT.next = head;
                    sT = head;
                }
            }else if(head.val == num){
                if(eH == null){
                    eH = head;
                    eT = head;
                }else {
                    eT.next = head;
                    eT = head;
                }
            }else {
                if(bH == null){
                    bH = head;
                    bT = head;
                }else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }

        //连接，small和equal
        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        // all reconnect
        if (eT != null) {
            eT.next = bH;
        }
        return sH != null ? sH : eH != null ? eH : bH;

    }


    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
        // head1 = listPartition1(head1, 4);
        head1 = listPartition2(head1, 6);
        printLinkedList(head1);

    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

}
