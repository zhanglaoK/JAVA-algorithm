package com.junxi.day01;

/**
 *  插入排序
 *  时间复杂度O（n2）
 *  空间复杂度O(1)
 *  稳定性：稳定
 */
public class InsertSort {

    public static void main(String[] args) {
        int arr[] = new int[]{32,26,12,49,66,22};
        insertSort(arr);
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void insertSort(int []arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for(int i = 1;i<arr.length;i++){
            for(int j = i;j>0;j--){
                if(arr[j] < arr[j-1]){
                    swap(arr ,j,j-1);
                }else{
                    break;
                }
            }
        }
    }

    public static void swap(int[]arr,int a,int b){
        arr[a] = arr[a]^arr[b];
        arr[b] = arr[a]^arr[b];
        arr[a] = arr[a]^arr[b];
    }

}
