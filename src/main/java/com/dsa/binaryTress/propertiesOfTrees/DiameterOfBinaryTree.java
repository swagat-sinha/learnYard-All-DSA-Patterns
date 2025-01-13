package com.dsa.binaryTress.propertiesOfTrees;

import com.dsa.binaryTress.TreeNode;

public class DiameterOfBinaryTree {
private int maxDia = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getHeight(root);
        return maxDia;
    }
    private int getHeight(TreeNode root ){
        if( root == null){
            return 0;
        }
        int leftSubtreeHeight = getHeight(root.left);
        int rightSubtreeHeight = getHeight(root.right);

         maxDia = Math.max(maxDia,leftSubtreeHeight + rightSubtreeHeight);
         return Math.max(leftSubtreeHeight,rightSubtreeHeight)+1;
    }
}
