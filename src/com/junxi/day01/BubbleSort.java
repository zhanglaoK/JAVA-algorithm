package com.junxi.day01;

/**
 * 冒泡排序
 * 时间复杂度O（n2）
 * 空间复杂度O(1)
 * 稳定性：稳定
 */
public class BubbleSort {

    public static void main(String[] args) {
        int arr[] = new int[]{32,26,12,49,66,22};
        bubbleSort(arr);
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void bubbleSort(int []arr){

        if(arr.length < 2 || arr == null){
            return ;
        }
        for (int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j+1,j);
                }
            }
        }

    }

    public static void swap(int []arr,int a,int b){
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }

}
