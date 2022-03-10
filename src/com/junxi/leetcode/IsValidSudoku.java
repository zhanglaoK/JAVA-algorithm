package com.junxi.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 第36题 36. 有效的数独
 *
 *请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 *
 * 示例 1：
 * 输入：board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * 输出：true
 *
 * 示例 2：
 * 输入：board =
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * 输出：false
 * 解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 *
 */
public class IsValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        Map<Integer,Integer>[] rows = new HashMap[9];
        Map<Integer,Integer>[] columns = new HashMap[9];
        Map<Integer,Integer>[] boxs = new HashMap[9];
        for(int i=0;i<9;i++){
            rows[i] = new HashMap<>();
            columns[i] = new HashMap<>();
            boxs[i] = new HashMap<>();
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] != '.'){
                    int n = Integer.parseInt(String.valueOf(board[i][j]));
                    int box_index = (i/3)*3 + j/3;
                    rows[i].put(n,rows[i].getOrDefault(n,0)+1);
                    columns[j].put(n,columns[j].getOrDefault(n,0)+1);
                    boxs[box_index].put(n,boxs[box_index].getOrDefault(n,0)+1);
                    if(columns[j].get(n)>1||rows[i].get(n)>1 || boxs[box_index].get(n)>1){
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
