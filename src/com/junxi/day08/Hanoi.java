package com.junxi.day08;

/**
 *
 * 汉诺塔问题
 * 打印n层汉诺塔从最左边移动到最右边的全部过程
 *
 */
public class Hanoi {

    /**
     *
     * @param n 几层汉诺塔
     * @param from  原本在哪里
     * @param to    最后去哪里
     * @param help  帮助的
     *
     *            汉诺塔问题可以看成把n-1层移动到帮助中，然后把第N层的汉诺塔移动到目的地
     *              最后再把n-1层的汉诺塔移动到目的地
     */
    public static void process(int n,String from,String to,String help){
        if(n == 1){
            System.out.println("move "+n+" form "+from+" to "+ to);
        }else{
            process(n-1,from,help,to);
            System.out.println("move "+n+" form "+from+" to "+ to);
            process(n-1,help,to,from);
        }

    }

}
