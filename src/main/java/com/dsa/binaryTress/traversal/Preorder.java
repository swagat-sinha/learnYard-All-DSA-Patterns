package com.dsa.binaryTress.traversal;


import com.dsa.binaryTress.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Preorder {

    public List<Integer> preorderTraversal(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        preorderTraversalHelper(root, result);
        return result;

    }


    private void preorderTraversalHelper(TreeNode root, List<Integer> result) {

        if (root == null) {
            return;
        }
        result.add(root.val);
        preorderTraversalHelper(root.left, result);
        preorderTraversalHelper(root.right, result);

    }
}
