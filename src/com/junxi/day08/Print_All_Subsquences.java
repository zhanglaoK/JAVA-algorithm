package com.junxi.day08;

/**
 *
 * 打印一个字符串的全部子序列，包括空字符串
 *
 */
public class Print_All_Subsquences {

    public static void process(char[]chs,int i,String res){
        if(chs.length==i){
            System.out.println(res);
            return;
        }
        process(chs,i+1,res);
        process(chs,i+1,res+String.valueOf(chs[i]));
    }

    public static void main(String[] args) {
        process("abc".toCharArray(),0,"");
    }
}
