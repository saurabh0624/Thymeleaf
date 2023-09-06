package com.demo.thymleaf.singleCode;

import java.util.ArrayList;
import java.util.List;

public class RootToLeaf {
    public List<List<Integer>> findPaths(TreeNode root, int B) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();

        findPathsRecursive(root, B, currentPath, result);

        return result;
    }

    private void findPathsRecursive(TreeNode node, int remainingSum, List<Integer> currentPath, List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        // Add the current node's value to the current path
        currentPath.add(node.val);

        if (node.left == null && node.right == null && remainingSum == node.val) {
            // Leaf node and remaining sum equals the node's value
            result.add(new ArrayList<>(currentPath));
        } else {
            // Recursively search in the left and right subtrees
            findPathsRecursive(node.left, remainingSum - node.val, currentPath, result);
            findPathsRecursive(node.right, remainingSum - node.val, currentPath, result);
        }

        // Backtrack: Remove the current node from the current path
        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);

        int targetSum = 22;

        RootToLeaf solution = new RootToLeaf();
        List<List<Integer>> paths = solution.findPaths(root, targetSum);

        // Print the paths
        for (List<Integer> path : paths) {
            System.out.println(path);
        }
    }
}

