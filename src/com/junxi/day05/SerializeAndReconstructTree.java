package com.junxi.day05;


import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 二叉树的序列化和反序列化
 *
 */
public class SerializeAndReconstructTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value){
            this.value = value;
        }
    }

    //二叉树的序列化
    public static String serialByPre(Node head){
        if(head == null){
            return "#!";
        }
        String res = head.value + "!";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }

    //二叉树的反序列化
    public static Node reconByPreString(String preStr){
        String[] values = preStr.split("!");
        Queue<String> queue = new LinkedList<>();
        for(int i=0;i<values.length;i++){
            queue.offer(values[i]);
        }
        return reconPreOrder(queue);
    }


    public static Node reconPreOrder(Queue<String>queue){
        String value = queue.poll();
        if(value.equals("#")){
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }

}
