package com.junxi.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * leetcode 第十二题 20. 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 *
 * 输入：s = "([)]"
 * 输出：false
 * 示例 5：
 *
 * 输入：s = "{[]}"
 * 输出：true
 *
 *
 */
public class IsValid {

    public boolean isValid(String s) {

        if(s.length()<2 && s.length() !=0){
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if('('==c){
                stack.push(')');
            }else if('{'==c){
                stack.push('}');
            }else if('['==c){
                stack.push(']');
            }else if(stack.isEmpty() || c!=stack.pop()){
                return false;
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }

}
