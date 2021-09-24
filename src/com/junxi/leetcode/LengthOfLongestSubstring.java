package com.junxi.leetcode;

/**
 * leetcode第三题 3. 无重复字符的最长子串
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int maxLength = 0;
        int leftIndex = 0;
        for(int i=0;i<chars.length;i++){
            for(int j=leftIndex;j<i;j++){
                if(chars[i]==chars[j]){
                    maxLength = Math.max(i-leftIndex,maxLength);
                    leftIndex = j+1;
                }
            }
        }
        return Math.max(maxLength,chars.length-leftIndex);
    }

}
