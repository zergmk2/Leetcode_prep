package codetest.LeetCode.tree;
/*
 * [437] Path Sum III
 *
 * https://leetcode.com/problems/path-sum-iii/description/
 *
 * algorithms
 * Easy (40.35%)
 * Total Accepted:    79.2K
 * Total Submissions: 194.1K
 * Testcase Example:  '[10,5,-3,3,2,null,11,3,-2,null,1]\n8'
 *
 * You are given a binary tree in which each node contains an integer value.
 * 
 * Find the number of paths that sum to a given value.
 * 
 * The path does not need to start or end at the root or a leaf, but it must go
 * downwards
 * (traveling only from parent nodes to child nodes).
 * 
 * The tree has no more than 1,000 nodes and the values are in the range
 * -1,000,000 to 1,000,000.
 * 
 * Example:
 * 
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * 
 * ⁠     10
 * ⁠    /  \
 * ⁠   5   -3
 * ⁠  / \    \
 * ⁠ 3   2   11
 * ⁠/ \   \
 * 3  -2   1
 * 
 * Return 3. The paths that sum to 8 are:
 * 
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 * 
 * 
 */

import codetest.DataStructure.Tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PathSum3_437 {
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
        {
            return 0;
        }
        return dfsHelper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int dfsHelper(TreeNode root, int sum)
    {
        if (root == null)
        {
            return 0;
        }
        System.out.print("[ " + root.val + " -> ");
        //
        int ret = 0;
        if (sum == root.val)
        {
            System.out.print("!!");
            ret = 1;
        }

        ret += dfsHelper(root.left, sum - root.val) + dfsHelper(root.right, sum - root.val);
        System.out.print(" ]");
        return ret;
    }
}
