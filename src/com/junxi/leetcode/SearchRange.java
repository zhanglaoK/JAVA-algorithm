package com.junxi.leetcode;

/**
 * leetcode 第34题  34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 *  示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 *
 * 示例 2：
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 *
 * 示例 3：
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 */
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int left = binarySearch(nums,target,true);
        int right = binarySearch(nums,target,false)-1;
        if(left<=right && right<nums.length&&nums[left] == target && nums[right] == target){
            return new int[] {left,right};
        }
        return new int[] {-1,-1};
    }

    private int binarySearch(int[] nums, int target,boolean flag){
        int right = nums.length-1;
        int left = 0;
        int res = nums.length;
        while(left<=right){
            int mid = (right + left)/2;
            if(target<nums[mid] || (flag && target==nums[mid])){
                right = mid -1;
                res = mid;
            }else{
                left = mid+1;
            }
        }
        return res;
    }

}
