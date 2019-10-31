package com.junxi.day03;

import java.util.Stack;

/**
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
 * 【要求】
 * 1．pop、push、getMin操作的时间复杂度都是O(1)。
 * 2．设计的栈类型可以使用现成的栈结构。
 */
public class GetMinStack {
    public static class MyStack1 {
        private Stack<Integer> dataStack;
        private Stack<Integer> minStack;

        public MyStack1() {
            this.dataStack = new Stack<Integer>();
            this.minStack = new Stack<Integer>();
        }

        public void push(int newNum) {
            if (this.minStack.isEmpty()) {
                minStack.push(newNum);
            } else if (newNum <= this.getMin()) {
                minStack.push(newNum);
            }
            dataStack.push(newNum);
        }

        public int pop() {
            if (this.dataStack.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            int value = this.dataStack.pop();
            if (value == this.getMin()) {
                this.minStack.pop();
            }
            return value;
        }


        public int getMin() {
            if (this.minStack.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return this.minStack.peek();
        }


    }


    public static class MyStack2{

        private Stack<Integer> dataStack;
        private Stack<Integer> minStack;

        public MyStack2(){
            this.dataStack = new Stack<Integer>();
            this.minStack = new Stack<Integer>();
        }

        public void push(int newNum){
            if (this.minStack.isEmpty()){
                this.minStack.push(newNum);
            }else if(newNum < this.getMin()){
                this.minStack.push(newNum);
            }else {
                this.minStack.push(this.minStack.peek());
            }
            this.dataStack.push(newNum);
        }

        public int pop(){
            if (this.dataStack.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            this.minStack.pop();
            return this.dataStack.pop();
        }

        public int getMin(){
            if (this.minStack.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return this.minStack.peek();
        }

    }

}
