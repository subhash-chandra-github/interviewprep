package com.interviewprep.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by subhash on 7/2/21.
 */
public class Solution {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> lst = new ArrayList();
        q.add(root);
        q.add(null);
        while(!q.isEmpty())
        {
            TreeNode n = q.poll();
            if(n==null)
            {
                ans.add(new ArrayList(lst));
                lst.clear();
                if(q.peek()!=null)
                  q.add(null);
            }
            if(n!=null)
            {
                lst.add(n.val);
                if(n.left!=null)
                {
                    q.add(n.left);
                }
                if(n.right!=null)
                {
                    q.add(n.right);
                }
            }
        }
        return ans;
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {


        if(root == null)
            return false;
        if( root.left==null && root.right==null)
        {
            if(root.val == targetSum)
                return true;
            else
                return false;
        }

        return hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val);

    }

    public static void main(String args[])
    {
        TreeNode n = new TreeNode(5);
        n.left = new TreeNode(4);
        n.right = new TreeNode(8);
        n.right.left = new TreeNode(13);
        n.right.right = new TreeNode(4);
        n.right.right.right = new TreeNode(1);
        n.left.left = new TreeNode(11);
        n.left.left.left = new TreeNode(7);
        n.left.left.right = new TreeNode(2);

        List<List<Integer>> ans = levelOrder(n);
        System.out.println(ans);

        System.out.println(hasPathSum(n,22));
    }


}
