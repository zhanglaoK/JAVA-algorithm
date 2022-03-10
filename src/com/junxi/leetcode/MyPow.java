package com.junxi.leetcode;

/**
 * leetcode 50. Pow(x, n)
 *
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn ）。
 *
 * 示例 1：
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 *
 * 示例 2：
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 *
 * 示例 3：
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 *
 */
public class MyPow {

    public double myPow(double x, int n) {
        double res = 1.0;
        for(int i=n;i!=0;i=i/2){
            if(i%2!=0){
                res *=x;
            }
            x*=x;
        }
        return n>0?res:1/res;
    }


}
