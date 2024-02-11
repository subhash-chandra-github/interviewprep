package com.interviewprep.dsa.tree;

public class BST {

        public TreeNode deleteNode(TreeNode root, int key) {

            if(root == null){
                return root;
            }
            if(root.val > key){
                root.left = deleteNode(root.left,key);
            }
            else if(root.val < key){
                root.right = deleteNode(root.right,key);
            }
            else if(root.val == key){
                if(root.right == null){
                    return root.left;
                }
                if(root.left == null){
                    return root.right;
                }
                TreeNode cur = root.left;
                    while (cur.right != null) {
                        cur = cur.right;
                    }
                    cur.right = root.right;
                return root.left;
            }

            return root;
        }
}

//        3
//       / \
//     1    5
//    / \
//   0   2