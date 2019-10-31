package com.junxi.day01;

/**
 * 选择排序
 * 时间复杂度O（n2）
 * 空间复杂度O（1）
 * 稳定性：不稳定
 */
public class SelectionSort {

    public static void main(String[] args) {
        int arr[] = new int[]{32,26,12,49,66,22};
        selectionSort(arr);
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void selectionSort(int[] arr){
        if(arr == null || arr.length<2){
            return;
        }
        for(int i=0;i<arr.length;i++){
            int minIndex = i;
            for (int j=i+1;j<arr.length;j++){
                minIndex = arr[minIndex] > arr[j]?j:minIndex;
            }
            if(i != minIndex){
                swap(arr,i,minIndex);
            }
        }
    }

    public static void swap(int []arr,int a,int b){
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }

}
