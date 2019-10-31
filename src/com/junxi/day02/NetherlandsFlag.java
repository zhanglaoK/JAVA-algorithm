package com.junxi.day02;

/**
 * 荷兰国旗问题:给定一个数组，和一个数字，使得这个数组中的每个数字小于给定数字的话就放在左边，等于放中间，大于放右边
 */
public class NetherlandsFlag {

    public static int[] partition(int[]arr,int L,int R,int num){
        int less = L-1;
        int more = R+1;
        int cur = L;
        while(cur<more){
            if(arr[cur]<num){
                swap(arr,++less,cur++);
            }else if(arr[cur]>num){
                swap(arr,--more,cur);
            }else{
                cur++;
            }

        }
        return new int[]{less+1,more-1};
    }

    public static void swap(int []arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        //两个数相同时不能用以下方法
//        arr[a] = arr[a] ^ arr[b];
//        arr[b] = arr[a] ^ arr[b];
//        arr[a] = arr[a] ^ arr[b];
    }

    public static void main(String[] args) {
        int arr[] = new int[]{32,26,12,49,66,22};
        partition(arr,0,arr.length-1,18);
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

}
