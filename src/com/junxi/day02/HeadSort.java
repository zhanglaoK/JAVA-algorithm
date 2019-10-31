package com.junxi.day02;

/**
 * 堆排序
 * 时间复杂度O(nlog2n)
 * 空间复杂度O(1)
 * 稳定性：不稳定
 * 涉及知识;大根堆，小根堆
 */
public class HeadSort {


    public static void main(String[] args) {
        int arr[] = new int[]{32,26,12,49,66,22};
        headSort(arr);
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void headSort(int []arr){
        if(arr.length<2 || arr == null){
            return;
        }
        for (int i=0;i<arr.length;i++){
            headInsert(arr,i);
        }
        int size = arr.length;
        swap(arr,0,--size);
        while (size>0){
            headify(arr,0,size);
            swap(arr,0,--size);
        }
    }

    public static void headInsert(int[]arr,int index){

        while(arr[(index-1)/2]<arr[index]){
            swap(arr,(index-1)/2,index);
            index = (index-1)/2;
        }

    }

    public static void headify(int []arr,int index,int size){
        int left = index * 2 + 1;
        while (left<size){
            int largest = left + 1 < size && arr[left + 1]>arr[left] ? left+1:left;
            largest = arr[largest] > arr[index] ? largest:index;
            if (largest == index){
                break;
            }
            swap(arr,index,largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void swap(int []arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
