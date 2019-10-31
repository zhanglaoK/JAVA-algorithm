package com.junxi.day03;

/**
 * 时间复杂度位O（n）
 * 找出两个数的最大差值
 */
public class MaxGap {

    public static int maxGap(int []nums){
        if(nums == null || nums.length<2){
            return 0;
        }
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i=0;i<len;i++){
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }

        if(max == min){
            return 0;
        }
        boolean [] hasNum = new boolean[len+1];
        int [] maxs = new int [len+1];
        int [] mins = new int [len+1];

        int bid = 0;
        for(int i=0;i<len;i++){
            bid = bucket(nums[i],len,min,max);
            maxs[bid] = hasNum[bid]?Math.max(maxs[bid],nums[i]):nums[i];
            mins[bid] = hasNum[bid]?Math.min(mins[bid],nums[i]):nums[i];
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = maxs[0];
        int i = 1;
        for (;i<=len;i++){
            if (hasNum[i]){
                res = Math.max(res,mins[i]-lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }


    public static int bucket(int num,int len,int min, int max){

        return (int)((num - min)*len/(max-min));

    }

}
