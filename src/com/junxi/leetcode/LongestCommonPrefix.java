package com.junxi.leetcode;

/**
 * leetcode第十四题 14.最长公共前缀
 *
 *
 编写一个函数来查找字符串数组中的最长公共前缀。
 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs.length==1){
            return strs[0];
        }
        StringBuilder sb = new StringBuilder();
        int firstLen = strs[0].length();
        for(int i=0;i<firstLen;i++){
            char cur = strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(strs[j].length()<=i || cur != strs[j].charAt(i)){
                    return sb.toString();
                }
                if(j==strs.length-1){
                    sb.append(cur);
                }
            }
        }
        return sb.toString();
    }

}
