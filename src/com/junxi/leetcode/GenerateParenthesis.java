package com.junxi.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 22题 22. 括号生成
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n==0){
            return res;
        }
        dfs("",res,n,n);
        return res;
    }

    private void dfs(String str,List<String> res,int left,int right){
        if(left==0&&right==0){
            res.add(str);
            return;
        }
        if(left>right){
            return;
        }
        if(left>0){
            dfs(str+"(",res,left-1,right);
        }
        if(right>0){
            dfs(str+")",res,left,right-1);
        }
    }

}
