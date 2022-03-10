package com.junxi.leetcode;

/**
 * leetcode 43
 * 43. 字符串相乘
 *
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 * 示例 1:
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 *
 * 示例 2:
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 */
public class Multiply {

    public String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2))
            return "0";

        int len1 = num1.length();
        int len2 = num2.length();
        int [] res = new int [len1 + len2];
        for(int i=len1-1;i>=0;i--){
            int n1 = num1.charAt(i) - '0';
            for(int j=len2-1;j>=0;j--){
                int n2 = num2.charAt(j)-'0';
                int sum = res[i+j+1] + n1*n2;
                res[i+j] += sum/10;
                res[i+j+i] = sum%10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<res.length;i++){
            if(i==0 && res[i]==0){
                continue;
            }
            sb.append(res[i]);
        }
        return sb.toString();
    }

}
