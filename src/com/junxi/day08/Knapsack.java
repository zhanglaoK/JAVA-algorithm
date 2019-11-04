package com.junxi.day08;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 背包问题
 * 可用暴力递归解法，贪心解法，动态规划解法
 * 给定两个数组w和v，两个数组长度相等，w[i]表示第i件商品的
 * 重量，v[i]表示第i件商品的价值。 再给定一个整数bag，要求
 * 你挑选商品的重量加起来一定不能超 过bag，返回满足这个条件
 * 下，你能获得的最大价值。
 */
public class Knapsack {


    /**
     * 递归方式
     * @param w 商品种类数组
     * @param v 价值价值数组
     * @param i 第几件商品
     * @param bag   包的容量
     * @param curBag    当前包的重量
     * @return
     */
    public static int process1(int []w,int []v,int i,int bag,int curBag){
        if(curBag > bag){
            return 0;
        }
        if(i == w.length){
            return 0;
        }
        return Math.max(process1(w,v,i+1,bag,curBag),v[i]+process1(w,v,i+1,bag,curBag+bag));
    }

    /**
     * 分割线=======================================================================
     * 以下代码都用在了贪心算法
     */


    public static class Node{
        public int w;
        public int v;
        public int xjb;
        public Node(int w,int v){
            this.w = w; // 重量
            this.v = v; //  价值
            this.xjb = v/w; //  性价比
        }
    }


    public static class MaxValueComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o2.v - o1.v;
        }
    }

    /**
     * 性价比比较器
     */
    public static class MaxXJBComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o2.xjb - o1.xjb;
        }
    }


    public static int process2(int []w,int []v,int bag,int curBag,int curValue){
        Node node[] = new Node[w.length];
        for (int i=0;i<node.length;i++){
            node[i] = new Node(w[i],v[i]);
        }
        PriorityQueue<Node> maxValueQ = new PriorityQueue<>(new MaxValueComparator());
        PriorityQueue<Node> maxXJBQ = new PriorityQueue<>(new MaxXJBComparator());

        for(int i=0;i<node.length;i++){
            maxXJBQ.add(node[i]);
        }

        int count = 0;
        while(curBag <= bag && count != w.length){
            while(!maxXJBQ.isEmpty() && (maxXJBQ.peek().w + curBag) <= bag){
                curBag += maxXJBQ.peek().w;
                maxValueQ.add(maxXJBQ.poll());
            }
            if(maxValueQ.isEmpty()){
                return curValue;
            }
            curValue += maxValueQ.poll().v;
            count++;
        }
        return curValue;
    }

    /**
     * 分割线=======================================================================
     * 以下代码都用在了动态规划
     */


    /**
     * 动态规划
     * @param w
     * @param v
     * @param bag
     * @return
     */
    public static int process3(int[] w,int[] v,int bag){
        int row = w.length;
        int [][]dp = new int[row+1][bag+1];
        for (int i=0;i <= bag;i++){
            dp[0][i] = 0;
        }
        for(int i=0;i<=row;i++){
            dp[i][0] = 0;
        }
        for(int i = 1;i <= row;i++){
            for(int j = 1;j <= bag;j++){
                if(w[i-1]<=j){
                    dp[i][j] = Math.max(v[i-1]+dp[i-1][j-w[i-1]],dp[i-1][j]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[row][bag];
    }


    public static void main(String[] args) {
        int[] w = { 3, 2, 4, 7 };
        int[] v = { 5, 6, 3, 19 };
        int bag = 11;
        System.out.println(process1(w, v, 0,bag,0));
        System.out.println(process2(w, v, bag,0,0));
        System.out.println(process3(w, v, bag));
    }

}
