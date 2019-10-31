package com.junxi.day05;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * 判断一棵树是否是搜索二叉树    在一节点中，它会比左子树大，比右子树小；即中序遍历时，他会顺序排序
 * 判断一棵树是否是完全二叉树
 *
 */

public class IsBSTAndCBT {

    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int value){
            this.value = value;
        }
    }

    //判断一棵树是否是搜索二叉树
    public static boolean isBST(Node head) {
        if (head == null) {
            return true;
        }
        Stack<Node> stack = new Stack<Node>();
        Integer pre = Integer.MIN_VALUE;
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                if (pre < head.value) {
                    pre = head.value;
                } else {
                    return false;
                }
                head = head.right;

            }
        }
        return true;
    }

    //判断一棵树是否是完全二叉树
    public static boolean isCBT(Node head){
        if(head == null){
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        Node l = null;
        Node r = null;
        boolean leaf = false;
        queue.offer(head);
        while (!queue.isEmpty()){
            head = queue.poll();
            l = head.left;
            r = head.right;
            if((leaf && (l != null || r != null))|| (l == null && r != null)){
                return false;
            }
            if(l != null){
                queue.offer(l);
            }
            if(r != null){
                queue.offer(r);
            }else {
                leaf = true;
            }

        }
        return true;
    }

}
