package com.dsa.binaryTress.propertiesOfTrees;

import com.dsa.binaryTress.TreeNode;

public class MaxDepthOfBinaryTree {

    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftSubtreeDepth = maxDepth(root.left);
        int rightSubtreeDepth = maxDepth(root.right);

        return Math.max(leftSubtreeDepth,rightSubtreeDepth)+1;
    }
}
