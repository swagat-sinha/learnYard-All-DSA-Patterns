package com.dsa.binaryTress.propertiesOfTrees;

import com.dsa.binaryTress.TreeNode;

public class MinDepthOfBinaryTree {
    public int minDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftSubtreeDepth = minDepth(root.left);
        int rightSubtreeDepth = minDepth(root.right);

        if(leftSubtreeDepth == 0){
            return rightSubtreeDepth + 1;
        }
        if(rightSubtreeDepth == 0){
            return leftSubtreeDepth + 1;
        }

        return Math.min(leftSubtreeDepth,rightSubtreeDepth)+1;
    }
}
