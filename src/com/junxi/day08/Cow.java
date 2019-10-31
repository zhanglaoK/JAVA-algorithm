package com.junxi.day08;

/**
 *
 * 母牛每年生一只母牛，新出生的母牛成长三年后也能每年生一只
 * 母牛，假设不会死。求N年后，母牛的数量。
 * fn=f(n-1)+f(n-3)
 *
 * 如果每只母牛只能活10年，求N年后，母牛的数量
 *
 * 第一年：1 a
 * 第二年：2 a b
 * 第三年：3 a b c
 * 	        +1
 * 第四年：4 a b c d
 * 	        +2
 * 第五年：6 a b c d e f
 * 	        +3
 * 第六年：9 a b c d e f g h i
 * 	        +4
 * 第七年：13 a b c d e f g h i j k l m
 *          +6
 * 第八年：19 a b c d e f g h i j k l m o p q r s t
 *          +9
 * 第九年：28 a b c d e f g h i j k l m o p q r s t u v w x y z a1 a2 a3
 *
 */
public class Cow {

    public static int cowNumber(int n) {
        if(n < 1){
            return 0;
        }
        if(n == 1 || n == 2 || n == 3){
            return n;
        }
        return cowNumber(n-1) + cowNumber(n-3);
    }

    public static void main(String[] args) {
        System.out.println(cowNumber(9));

        Object[] o = null;
        System.out.println(o[0]);
    }

}
