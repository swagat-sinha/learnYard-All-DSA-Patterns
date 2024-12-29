package com.dsa.binaryTress.propertiesOfTrees;

import com.dsa.binaryTress.TreeNode;

public class BalancedBinaryTree {

    //time -> O(n^2)
    public boolean isBalancedBinaryTree(TreeNode root){
        if(root == null){
           return true;
        }

        Integer heightOfLeftSubtree = heightOfTree(root.left);
        Integer heightOfRightSubtree = heightOfTree(root.right);
       if( Math.abs(heightOfLeftSubtree - heightOfRightSubtree ) > 1 ){
           return false;
       }
        return isBalancedBinaryTree(root.left) && isBalancedBinaryTree(root.right);
    }


    //Time - O(n) -> to find height
    private Integer heightOfTree(TreeNode root){

        if(root == null){
         return 0;
        }
        Integer heightOfLeftSubtree  = heightOfTree(root.left);
        Integer heightOfRightSubtree  = heightOfTree(root.right);
        return Math.max(heightOfRightSubtree , heightOfLeftSubtree) + 1;
    }
}
