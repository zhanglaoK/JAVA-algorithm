package com.junxi.leetcode;

/**
 * leetcode 12. 整数转罗马数字
 *
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * 示例 1:
 *
 * 输入: num = 3
 * 输出: "III"
 * 示例 2:
 *
 * 输入: num = 4
 * 输出: "IV"
 * 示例 3:
 *
 * 输入: num = 9
 * 输出: "IX"
 * 示例 4:
 *
 * 输入: num = 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例 5:
 *
 * 输入: num = 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 * 1 <= num <= 3999
 *
 */
public class IntToRoman {

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        String lm[] = {"M","D","C","L","X","V","I"};
        int nums [] = {1000,500,100,50,10,5,1};
        for(int i =0;i<7;i++){
            int temp = num/nums[i];
            if(temp<4){
                for(int j=0;j<temp;j++){
                    sb.append(lm[i]);
                }
            }else if(temp==4){
                sb.append(lm[i]);
                sb.append(lm[i-1]);
            }else if(temp < 9){
                sb.append(lm[i-1]);
                for(int j=0;j<temp-5;j++){
                    sb.append(lm[i]);
                }
            }else{
                sb.append(lm[i]);
                sb.append(lm[i-2]);
            }
            num -= temp*nums[i];
        }
        return sb.toString();
    }

}
