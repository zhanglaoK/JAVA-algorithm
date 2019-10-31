package com.junxi.day05;
/**
 *
 * 判断一棵二叉树是否是平衡二叉树
 *
 * 平衡二叉树特点：左子树和右子树的深度之差的绝对值不超过1
 *
 */
public class IsBalancedTree {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value){
            this.value = value;
        }
    }

    public static class ReturnData{
        public boolean isB;
        public int height;
        public ReturnData(boolean isB,int height){
            this.isB = isB;
            this.height = height;
        }
    }

    public static boolean isBalance(Node head){
        return process(head).isB;
    }


    public static ReturnData process(Node head){
        if(head == null){
            return new ReturnData(true,0);
        }
        ReturnData leftData = process(head.left);
        if(!leftData.isB){
            return new ReturnData(false,0);
        }
        ReturnData rightData = process(head.right);
        if(!rightData.isB){
            return new ReturnData(false,0);
        }
        if(Math.abs(leftData.height-rightData.height)>1){
            return new ReturnData(false,0);
        }
        return new ReturnData(true,Math.max(leftData.height,rightData.height)+1);

    }

}
