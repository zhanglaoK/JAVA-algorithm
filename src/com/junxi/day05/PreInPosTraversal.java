package com.junxi.day05;

/**
 * 二叉树的各种遍历
 * 包括递归方法和非递归方法
 */

import java.util.Stack;

public class PreInPosTraversal {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value){
            this.value = value;
        }
    }

    //递归方式先序遍历
    public static void preOrderRecur(Node head){
        if(head == null){
            return;
        }
        System.out.print(head.value+" ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    //递归方式中序遍历
    public static void inOrderRecur(Node head){
        if(head == null){
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value +" ");
        inOrderRecur(head.right);
    }

    //递归方式后序遍历
    public static void posOrderRecur(Node head){
        if(head == null){
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value+" ");
    }

    //非递归方式先序遍历
    public static void preOrderUnRecur(Node head){
        if(head != null){
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            while(!stack.isEmpty()){
                head = stack.pop();
                System.out.print(head.value+" ");
                if(head.right != null){
                    stack.push(head.right);
                }
                if(head.left != null){
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    //非递归方式中序遍历
    public static void inOrderUnRecur(Node head){
        if(head != null){
            Stack<Node> stack = new Stack<>();
            while(!stack.isEmpty() || head != null){
                if(head != null){
                    stack.push(head);
                    head = head.left;
                }else {
                    head = stack.pop();
                    System.out.print(head.value +" ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    //非递归方式后序遍历，双栈
    public static void posOrderUnRecur1(Node head){
        if(head != null){
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.push(head);
            while(!stack1.isEmpty()){
                head = stack1.pop();
                stack2.push(head);
                if(head.left != null){
                    stack1.push(head.left);
                }
                if(head.right != null){
                    stack1.push(head.right);
                }
            }
            while (!stack2.isEmpty()){
                System.out.print(stack2.pop().value);
            }
        }
        System.out.println();
    }

    //非递归方式后序遍历，炫技
    public static void posOrderUnRecur2(Node head){
        if(head != null){
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            Node c = null;
            while(!stack.isEmpty()){
                c = stack.peek();
                if(c.left != null && c.left != head && c.right != null){
                    stack.push(c.left);
                }else if(c.right != null && head !=c.right){
                    stack.push(c.right);
                }else {
                    System.out.print(stack.pop().value+" ");
                    head = c;
                }
            }
        }
        System.out.println();
    }
}
