package com.junxi.day02;

/**
 * 快速排序
 * 时间复杂度 O(nlog2n)
 * 空间复杂度 O(nlog2n)
 * 稳定性：不稳定
 */
public class QuickSort {

    public static void main(String[] args) {
        int arr[] = new int[]{32,26,12,49,66,22};
        quickSort(arr,0,arr.length-1);
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void quickSort(int []arr,int L, int R){
        if(arr.length<2 || arr == null){
            return;
        }
        if(L<R){
            int[] p = partition(arr, L, R);
            quickSort(arr,L,p[0]-1);
            quickSort(arr,p[1]+1,R);
        }


    }

    public static int[] partition(int[] arr,int L,int R){
        int less = L-1;
        int more = R;
        int num = arr[R];
        int cur = L;
        while(cur < more){
            if(arr[cur]<num){
                swap(arr,++less,cur++);
            }else if(arr[cur]>num){
                swap(arr,--more,cur);
            }else {
                cur++;
            }
        }
        swap(arr,R,more);
        return new int[]{less+1,more};
    }

    public static void swap(int[]arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
