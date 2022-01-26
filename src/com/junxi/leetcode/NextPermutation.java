package com.junxi.leetcode;

/**
 * leetcode 第三十一题 31. 下一个排列
 *
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * 示例 3：
 *
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 * 示例 4：
 *
 * 输入：nums = [1]
 * 输出：[1]
 *
 *
 */
public class NextPermutation {

    public static void main(String[] args) {
        nextPermutation(new int []{1,3,2});
    }

    public static void nextPermutation(int[] nums) {
        int i = nums.length-2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        if(i>=0){
            int j = nums.length-1;
            while(j>=0 && nums[i]>=nums[j]){
                j--;
            }
            swap(nums,i,j);
        }
        reseve(nums,i+1);

    }

    private static void swap(int []nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private static void reseve(int []nums,int i){
        int end = nums.length-1;
        while(i<end){
            swap(nums,i++,end--);
        }
    }

}
