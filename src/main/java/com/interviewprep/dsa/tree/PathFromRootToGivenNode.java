package com.interviewprep.dsa.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PathFromRootToGivenNode {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(5);
        node.right = new TreeNode(1);
        node.left.left = new TreeNode(6);
        node.left.right = new TreeNode(2);
        node.left.right.left = new TreeNode(7);
        node.left.right.right = new TreeNode(4);

        List<Integer> list = new ArrayList<>();
        path(node,7,list);
        Collections.reverse(list);
        System.out.println(list);
    }

    /**

            3
         /     \
        5       1
       / \
      6   2
         / \
        7  4
 **/


    public static boolean path(TreeNode root, int t, List<Integer> p){

        if(root == null){
            return false;
        }
       if(root.data==t){
            p.add(root.data);
            return true;
        }
        if(path(root.left,t,p)|| path(root.right,t,p)){
            p.add(root.data);
            return true;
        }
        return false;
    }


}
