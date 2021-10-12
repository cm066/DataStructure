package com.ntencent;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author cm
 * @create 2021/9/25-9:02 下午
 * 按层次打印二叉树
 */
public class LevelOrder {

    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode1 root) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode1> deque = new LinkedList();
        deque.add(root);
        while (!deque.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode1 node = deque.pop();
                list.add(node.val);
                if (node.left != null) deque.addLast(node.left);
                if (node.right != null) deque.addLast(node.right);
            }
            res.add(list);
        }
        return res;
    }
}
class TreeNode1{
    int val;
    TreeNode1  left;
    TreeNode1 right;

}