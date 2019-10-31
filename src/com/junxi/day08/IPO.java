package com.junxi.day08;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 贪心策略
 *
 * IPO问题
 *
 * 输入：
 * 参数1，正数数组costs
 * 参数2，正数数组profits
 * 参数3，正数k
 * 参数4，正数m
 * costs[i]表示i号项目的花费 profits[i]表示i号项目在扣除花
 * 费之后还能挣到的钱(利润) k表示你不能并行、只能串行的最多
 * 做k个项目 m表示你初始的资金
 * 说明：你每做完一个项目，马上获得的收益，可以支持你去做下一个 项目。
 * 输出： 你最后获得的最大钱数。
 *
 */

public class IPO {

    public static class Node{
        public int c;
        public int p;
        public Node(int c,int p){
            this.c = c; // 花费
            this.p = p; //利润
        }
    }

    public static class MinCostComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o1.c;
        }
    }

    public static class MaxProfitComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o2.p - o2.p;
        }
    }

    /*
     *  k:次数
     *  m:本钱
     *  Capital:开销数组
     *  Profits:利润数组
     */

    public static int findMaximizedCapital(int k, int m, int[] Capital, int[] Profits){
        Node node[] = new Node[Capital.length];
        for(int i = 0;i<node.length;i++){
            node[i] = new Node(Capital[i],Profits[i]);
        }
        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());
        for (int i = 0;i<node.length;i++){
            minCostQ.add(node[i]);
        }
        for(int i=0;i<k;i++){
            while (!minCostQ.isEmpty() && minCostQ.peek().c<=m){
                maxProfitQ.add(minCostQ.poll());
            }
            if(maxProfitQ.isEmpty()){
                return m;
            }
            m += maxProfitQ.poll().p;
        }
        return m;
    }

}
