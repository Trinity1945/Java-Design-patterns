package com;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    HashMap<String, Integer> memo = new HashMap<>();
    List<TreeNode> res=new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        travel(root);
        return res;
    }

    public String travel(TreeNode root){
        if(root==null){
            return "#";
        }
        String left=travel(root.left);
        String right=travel(root.right);
        String subTree = left + "," + right+ "," + root.val;

        int freq = memo.getOrDefault(subTree, 0);
        // 多次重复也只会被加入结果集一次
        if (freq == 1) {
            res.add(root);
        }
        // 给子树对应的出现次数加一
        memo.put(subTree, freq + 1);
        return subTree;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
