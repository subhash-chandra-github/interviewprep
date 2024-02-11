package com.interviewprep.dsa.tree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintLevel {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        printLevelOrder(root);
    }



    public static void printLevel(int level,TreeNode root){

        if(root == null){
            return;
        }
        if(level==1){
            System.out.print(root.data+" ");
        }
        else if (level > 1){
            printLevel(level-1,root.left);
            printLevel(level-1,root.right);

        }
    }

    public static void printLevelOrder(TreeNode root)
    {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int s = queue.size();
            while(s > 0) {
                TreeNode tempNode = queue.poll();
                System.out.print(tempNode.data + " ");

                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
                s--;
            }
            System.out.println();
        }
    }
}
