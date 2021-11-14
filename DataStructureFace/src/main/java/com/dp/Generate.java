package com.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cm
 * @create 2021/11/14-8:55 下午
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Generate {
    public static void main(String[] args) {
        List<List<Integer>> generate = generate(5);
        for (List<Integer> list : generate) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;
    }
    public static List<List<Integer>> generate(int numRows) {
        int i = 2;
        List<List<Integer>> res = new ArrayList<>(numRows);
        ArrayList<Integer> row1 = new ArrayList<>(2);
        row1.add(1);
        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(1);
        row2.add(1);
        res.add(row1);
        res.add(row2);
        while (i < numRows){
            List<Integer> list = res.get(i - 1);
            List<Integer> num = new ArrayList<>();
            num.add(1);
            for (int j = 1; j < i ; j++) {
                num.add(list.get(j-1)+list.get(j));
            }
            num.add(i,1);
            res.add(num);
            i++;
        }
        return res;
    }
}
