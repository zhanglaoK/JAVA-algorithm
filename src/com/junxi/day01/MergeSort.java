package com.junxi.day01;

/**
 * 归并排序
 * 时间复杂度O(nlog2n)
 * 空间复杂度O(n)
 * 稳定性：稳定
 */

public class MergeSort {

    public static void main(String[] args) {
        int arr[] = new int[]{32,26,12,49,66,22};
        margeSort(arr);
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void margeSort(int []arr){
        if(arr == null || arr.length<2){
            return;
        }
        margeProcess(arr,0,arr.length-1);
    }

    public static void margeProcess(int []arr,int L,int R){
        if(L==R){
            return;
        }
        int mid = L+((R-L)>>1);
        margeProcess(arr,L,mid);
        margeProcess(arr,mid+1,R);
        marge(arr,L,mid,R);

    }


    public static void marge(int []arr,int L,int mid,int R){
        int help[] = new int[R-L+1];
        //辅助数组的指针
        int i = 0;
        //左半数组指针
        int p1 = L;
        //右半数组指针
        int p2 = mid+1;
        while(p1<=mid && p2<=R){
            help[i++] = arr[p1]<arr[p2]?arr[p1++]:arr[p2++];
        }
        while(p1<=mid){
            help[i++] = arr[p1++];
        }
        while(p2<=R){
            help[i++] = arr[p2++];
        }
        for(int j=0;j<help.length;j++){
            arr[L+j] = help[j];
        }
    }


}
