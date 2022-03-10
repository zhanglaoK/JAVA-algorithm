package com.junxi.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 46全排列
 *
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 *
 * 示例 3：
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 */
public class Permute {

    public static void main(String[] args) {
        List<List<Integer>> permute = new Permute().permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0){
            return res;
        }
        List<Integer> combin = new ArrayList<>();
        boolean [] flags = new boolean[nums.length];
        dfs(nums,res,combin,0,flags);
        return res;
    }

    private void dfs(int[] nums,List<List<Integer>> res,List<Integer> combin,int index,boolean [] flags){
        if(nums.length==index){
            res.add(new ArrayList<>(combin));
        }
        for(int i=0;i<nums.length;i++){
            if(flags[i]){
                continue;
            }
            flags[i] = true;
            combin.add(nums[i]);
            dfs(nums,res,combin,index+1,flags);
            flags[i] = false;
            combin.remove(combin.size()-1);
        }

    }


}
