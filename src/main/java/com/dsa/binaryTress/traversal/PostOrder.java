package com.dsa.binaryTress.traversal;


import com.dsa.binaryTress.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PostOrder {

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        postorderTraversalHelper(root, result);
        return result;

    }

    private void postorderTraversalHelper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postorderTraversalHelper(root.left, result);
        postorderTraversalHelper(root.right, result);
        result.add(root.val);

    }
}
