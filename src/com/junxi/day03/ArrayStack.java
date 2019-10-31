package com.junxi.day03;

/**
 * 数组实现栈
 * 栈有出栈，入栈，查看栈顶元素的方法
 */
public class ArrayStack {

    private Integer [] arr;
    private Integer index;

    public ArrayStack(int initSize){
        if(initSize <0 ){
            throw new IllegalArgumentException("the init size is less than 0");
        }
        arr = new Integer[initSize];
        index = 0;
    }

    public void push(int obj){
        if(index == arr.length){
            throw new ArrayIndexOutOfBoundsException("The queue is full");
        }
        arr[index++] = obj;
    }

    public Integer peek(){
        if(index == 0){
            return null;
        }
        return arr[index -1];

    }

    public Integer pop(){
        if(index == 0){
            throw new ArrayIndexOutOfBoundsException("The queue is empty");
        }
        return arr[--index];
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
    }


}
