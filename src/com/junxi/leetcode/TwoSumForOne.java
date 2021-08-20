package com.junxi.leetcode;

/**
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 *
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 *
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 */


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 解题思路：
 * 利用缓存，先去缓存找那个数，缓存的键存的是数组的值，值存的是数据的下标
 * 遍历数组，
 *      如果缓存里面有那个数，则直接返回当前的下标，和索引的下标
 *      如果缓存里面不存在那个数，则key存的值为目标数-当前值，value存当前这个数的索引下标
 */
public class TwoSumForOne {

    public static int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        int res[] = new int[2];
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                res[0] = i;
                res[1] = map.get(nums[i]);
                break;
            }
            map.put(target-nums[i],i);
        }
        return res;
    }

    public static void main(String[] args) {
        int nums[] ={2,7,11,15};
        int target = 9;
        Arrays.stream(twoSum(nums, target)).forEach(num -> System.out.println(num));

    }

}
