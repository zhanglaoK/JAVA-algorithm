package com.junxi.leetcode;

import java.util.*;

/**
 * leetcode 第40题
 * 40. 组合总和 II
 *
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 *
 * 注意：解集不能包含重复的组合。 
 *
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 *
 * 示例 2:
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 *
 */
public class CombinationSum2 {

    public static void main(String[] args) {
//        new CombinationSum2().
//        combinationSum2(new int[]{1,2,3},6);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int i = calendar.get(Calendar.DAY_OF_MONTH);
        int actualMaximum = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println(i);
        System.out.println(actualMaximum);
    }

    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> combin = new ArrayList<Integer>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates,0,target);
        return res;
    }

    private void dfs(int[]candidates,int index,int target){
        if(target == 0){
            res.add(new ArrayList<>(combin));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            if(target>=candidates[i]){
                if(i>index && candidates[i] == candidates[i-1]){
                    continue;
                }
                combin.add(candidates[i]);
                dfs(candidates,i+1,target-candidates[i]);
                combin.remove(combin.size()-1);
            }
        }
    }
}
