package com.dsa.binaryTress.propertiesOfTrees;


import com.dsa.binaryTress.TreeNode;

// O(log^2 n)
public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // calculate height of the tree
        int height = getTreeHeight(root);

        // height 0 means only root node present
        if(height == 0){
            return 1;
        }

        //perform binary search
        int low = 0, high = (1 << height) - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (doesNodeExist(mid, height, root)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }


        }

        int totalNodes = (1 << height) - 1 + low;
        return totalNodes;
    }


    private int getTreeHeight(TreeNode root) {
        int height = 0;
        while (root.left != null) {
            root = root.left;
            height++;
        }
        return height;
    }

    private boolean doesNodeExist(int index, int height, TreeNode root) {
        int left = 0, right = (1 << height) - 1;

        for (int i = 0; i < height; i++) {
            int mid = left + (right - left) / 2;

            if (index <= mid) {
                root = root.left;
                right = mid;
            } else {
                root = root.right;
                left = mid + 1;
            }

        }

        return root != null;
    }
}

