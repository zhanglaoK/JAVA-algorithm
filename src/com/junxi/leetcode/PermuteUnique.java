package com.junxi.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 47. 全排列 II
 *
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 *
 * 示例 2：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 */
public class PermuteUnique {

    public static void main(String[] args) {
        List<List<Integer>> lists = new PermuteUnique().permuteUnique(new int[]{1, 1, 3});
        System.out.println(lists);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length==0){
            return res;
        }
        List<Integer> combin = new ArrayList<>();
        boolean [] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums,res,combin,used,0);
        return res;
    }

    private void dfs(int[] nums,List<List<Integer>> res,List<Integer> combin,boolean [] used,int index){
        if(index == nums.length){
            res.add(new ArrayList<>(combin));
        }
        for(int i=0;i<nums.length;i++){
            if(used[i] || (i>0 && nums[i]==nums[i-1] && !used[i-1])){
                continue;
            }
            used[i] = true;
            combin.add(nums[i]);
            dfs(nums,res,combin,used,index+1);
            used[i] = false;
            combin.remove(combin.size()-1);
        }
    }

}
