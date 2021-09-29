package com.junxi.leetcode;

/**
 * leetcode 第五题 5. 最长回文子串
 *
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * 示例 3：
 *
 * 输入：s = "a"
 * 输出："a"
 *
 * 示例 4：
 *
 * 输入：s = "ac"
 * 输出："a"
 *
 * 解题思路：用动态规划，创建一个布尔类型的二维数组，表示字符串i到j位置是否是回文串
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        int length = s.length();
        if(s==null || length ==0){
            return "";
        }
        int right = 0;
        int left = 0;
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[length][length];
        for(int i=length-2;i>=0;i--){
            dp[i][i] = true;
            for(int j=i+1;j<length;j++){
                dp[i][j] = chars[i]==chars[j] &&(j-i<3 || dp[i+1][j-1]);
                if(dp[i][j] && right-left<j-i){
                    right = j;
                    left = i;
                }
            }
        }
        return s.substring(left,right+1);
    }

    public static void main(String[] args) {
        System.out.println(Math.ceil((double)1/20000));
    }

}
