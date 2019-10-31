package com.junxi.day05;



/**
 *
 * 在二叉树中找到一个节点的后继节点
 *  该结构比普通二叉树节点结构多了一个指向父节点的parent指针。假
 设有一 棵Node类型的节点组成的二叉树，树中每个节点的parent指针
 都正确地指向 自己的父节点，头节点的parent指向null。只给一个在
 二叉树中的某个节点 node，请实现返回node的后继节点的函数。在二
 叉树的中序遍历的序列中， node的下一个节点叫作node的后继节点。
 */
public class SuccessorNode {

    /**
        思路：要找某一个节点的后继节点，那么要先
            判断那个节点有没有右子树
                1）如果有右子树：则它的后继节点就是为他右子树的最左节点
                如果没有右子树：则判断这个节点是否为它父节点的左节点
                    如果这个节点是它父节点的左节点：则它的父节点即为它的后继节点
                    如果这个节点不是它父节点的左节点，则继续往上边找，即将当前节点置为它的父节点，往上
     */

    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int value){
            this.value = value;
        }
    }

    public static Node getSuccessorNode(Node node){
        if(node == null){
            return node;
        }
        if(node.right != null){
            return getLeftMost(node.right);
        }else {
            Node parent = node.parent;
            while(parent != null && parent.left != node){
                node = parent;
                parent = node.parent;
            }
            return parent;
        }

    }



    //获取最左节点
    public static Node getLeftMost(Node node){
        if(node == null){
            return node;
        }
        while(node.left != null){
            node = node.left;
        }
        return node;
    }

}
