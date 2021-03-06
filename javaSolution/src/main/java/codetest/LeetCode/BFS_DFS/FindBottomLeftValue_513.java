package codetest.LeetCode.BFS_DFS;/*
 * [513] Find Bottom Left Tree Value
 *
 * https://leetcode.com/problems/find-bottom-left-tree-value/description/
 *
 * algorithms
 * Medium (56.98%)
 * Total Accepted:    57.1K
 * Total Submissions: 100.1K
 * Testcase Example:  '[2,1,3]'
 *
 * 
 * Given a binary tree, find the leftmost value in the last row of the tree. 
 * 
 * 
 * Example 1:
 * 
 * Input:
 * 
 * ⁠   2
 * ⁠  / \
 * ⁠ 1   3
 * 
 * Output:
 * 1
 * 
 * 
 * 
 * ⁠ Example 2: 
 * 
 * Input:
 * 
 * ⁠       1
 * ⁠      / \
 * ⁠     2   3
 * ⁠    /   / \
 * ⁠   4   5   6
 * ⁠      /
 * ⁠     7
 * 
 * Output:
 * 7
 * 
 * 
 * 
 * Note:
 * You may assume the tree (i.e., the given root node) is not NULL.
 * 
 */

import codetest.DataStructure.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class FindBottomLeftValue_513 {
    public int findBottomLeftValue(TreeNode root) {
        if (root == null)
        {
            return 0;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int bottomLeft = 0;
        while (!queue.isEmpty())
        {
            int size = queue.size();
            
            bottomLeft = queue.peek().val;
            
            for (int i = 0; i < size; i++)
            {
                TreeNode n = queue.poll();
                if (n.left != null)
                {
                    queue.offer(n.left);
                }
                
                if (n.right != null)
                {
                    queue.offer(n.right);
                }
            }
        }
        return bottomLeft;
    }
}
