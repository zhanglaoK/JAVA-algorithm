package com.junxi.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 第六题
 * 6. Z 字形变换
 *
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 *  P   A   H   N
 *  A P L S I I G
 *  Y   I   R
 *
 * 示例 1：
 *
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 *
 *
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * 示例 3：
 *
 * 输入：s = "A", numRows = 1
 * 输出："A"
 *
 */
public class Zconvert {

    public String convert(String s, int numRows) {

        if(numRows == 1){
            return s;
        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        int index = 0;
        List<StringBuilder> lists = new ArrayList<>();
        for(int i=0;i<Math.min(numRows,len);i++){
            lists.add(new StringBuilder());
        }
        boolean isDown = false;
        for(char c : chars){
            lists.get(index).append(c);
            if(index==0 || index==numRows-1){
                isDown = !isDown;
            }
            index += isDown?1:-1;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder sb : lists){
            res.append(sb);
        }
        return res.toString();
    }

}
