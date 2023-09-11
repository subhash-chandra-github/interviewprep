package com.interviewprep.tree;

import java.util.*;

public class NodesAtKDistanceFromGivenNode {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
        Map<TreeNode, List<TreeNode>> map = new HashMap<>();

        public  List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
            List<Integer> res = new ArrayList<>();
            if (root == null || K < 0) return res;
            buildMap(root, null);
            if (!map.containsKey(target))
                return res;

            Set<TreeNode> visited = new HashSet<>();
            Queue<TreeNode> q = new LinkedList<>();
            q.add(target);
            visited.add(target);
            while (!q.isEmpty()) {
                int size = q.size();
                if (K == 0) {
                    for (int i = 0; i < size ; i++) res.add(q.poll().val);
                    return res;
                }
                for (int i = 0; i < size; i++) {
                    TreeNode node = q.poll();
                    List<TreeNode> list = map.get(node);
                    for (TreeNode next : list) {
                        if (visited.contains(next)) continue;
                        visited.add(next);
                        q.add(next);
                    }
                }
                K--;
            }
            return res;
        }

        private void buildMap(TreeNode node, TreeNode parent) {  // build adjecency list
            if (node == null) return;
            if (!map.containsKey(node)) {
                map.put(node, new ArrayList<>());
                if (parent != null)
                {
                    map.get(node).add(parent);
                    map.get(parent).add(node) ;
                }
                buildMap(node.left, node);
                buildMap(node.right, node);
            }
        }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(5);
        node.right = new TreeNode(1);
        node.left.left = new TreeNode(6);
        node.left.right = new TreeNode(2);
        node.left.right.left = new TreeNode(7);
        node.left.right.right = new TreeNode(4);

        NodesAtKDistanceFromGivenNode n = new NodesAtKDistanceFromGivenNode();
        List<Integer> list = n.distanceK(node, node.left,2);
        System.out.println(list);
    }

}
