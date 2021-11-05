package com.junxi.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode 第十七题 17. 电话号码的字母组合
 */
public class LetterCombinations {

    public List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();
        if(digits.length()==0){
            return res;
        }
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        back(res,map,digits,0,new StringBuilder());
        return res;
    }

    private void back(List<String> res,Map<Character,String> map,String digits,int index,StringBuilder sb){
        if(digits.length()==index){
            res.add(sb.toString());
        }else{
            char num = digits.charAt(index);
            String strs = map.get(num);
            for(int i=0;i<strs.length();i++){
                sb.append(strs.charAt(i));
                back(res,map,digits,index+1,sb);
                sb.deleteCharAt(index);
            }
        }
    }

}
