package com.junxi.leetcode;

/**
 * leetcode第七题 整数反转
 *
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）
 *
 *示例 1：
 *
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 *
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 *
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 *
 * 输入：x = 0
 * 输出：0
 *
 *
 */
public class NumberReverse {

    public int reverse(int x) {
        int res = 0;
        int temp;
        while(x!=0){
            temp = x%10;
            if(res>Integer.MAX_VALUE/10 || res<Integer.MIN_VALUE/10){
                return 0;
            }
            res = res*10+temp;
            x /=10;
        }
        if(x<0){
            res = -1*res;
        }
        return res;
    }

}
