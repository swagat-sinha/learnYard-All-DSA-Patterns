package com.dsa.binaryTress.propertiesOfTrees;

import com.dsa.binaryTress.TreeNode;

class TreeInfo{
int height;
boolean isBalanced;

TreeInfo(int height , boolean isBalanced){
this.height = height;
this.isBalanced = isBalanced;
}
}

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

    // T=> O(n)
    public boolean isBalancedBinaryTreeEfficient(TreeNode root){

        return isBalancedBinaryTreeEfficientHelper(root).isBalanced;
    }

    private TreeInfo isBalancedBinaryTreeEfficientHelper(TreeNode root){

        if(root == null){
            return new TreeInfo(0,true);
        }

        TreeInfo leftSubtree = isBalancedBinaryTreeEfficientHelper(root.left);
        TreeInfo rightSubtree = isBalancedBinaryTreeEfficientHelper(root.right);

        boolean isBalanced = leftSubtree.isBalanced && rightSubtree.isBalanced && (Math.abs(leftSubtree.height- rightSubtree.height)<=1);
        int height = Math.max(leftSubtree.height, rightSubtree.height) +1;
        return new TreeInfo(height,isBalanced);
    }

}
