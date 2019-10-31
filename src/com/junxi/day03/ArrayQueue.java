package com.junxi.day03;

/**
 * 用数组实现队列
 * 队列有增加，删除，查看队头的方法
 */
public class ArrayQueue {

    private Integer []arr;
    private Integer size;
    private Integer start;
    private Integer end;

    public ArrayQueue(int initSize){
        if(initSize <0 ){
            throw new IllegalArgumentException("the init size is less than 0");
        }
        arr = new Integer[initSize];
        start = 0;
        end = 0;
        size = 0;
    }

    public void push(int obj){
        if (size == arr.length) {
            throw new ArrayIndexOutOfBoundsException("The queue is full");
        }
        size++;
        arr[end] = obj;
        end = end == arr.length - 1 ? 0 : end+1;
    }

    public Integer pop(){
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("The queue is empty");
        }
        size--;
        int tmp = start;
        start = start == arr.length - 1 ? 0:start+1;
        return arr[tmp];
    }

    public Integer peek(){
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("The queue is empty");
        }
        return arr[start];
    }

}
