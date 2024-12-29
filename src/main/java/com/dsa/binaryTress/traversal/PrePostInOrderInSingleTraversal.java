package com.dsa.binaryTress.traversal;

import com.dsa.binaryTress.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

class Pair {
    TreeNode node;
    int state;

    Pair(TreeNode node, int state) {
        this.node = node;
        this.state = state;
    }
}

public class PrePostInOrderInSingleTraversal {
    public static Map<String, List<Integer>> unifiedTraveral(TreeNode root) {
        List<Integer> preordrer = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();

        //consider edge case also if root is null

        if (root == null) {
            return Map.of(
                    "preorder", preordrer,
                    "inorder", inorder,
                    "postorder", postorder

            );
        }

        Stack<Pair> st = new Stack<>();

        st.push(new Pair(root, 0));

        while (!st.isEmpty()) {

            Pair current = st.peek();
            TreeNode node = current.node;
            if (current.state == 0) {
                preordrer.add(node.val);
                current.state++;
                if (node.left != null) {
                    st.push(new Pair(node.left, 0));
                }
                //for preorder

            } else if (current.state == 1) {
                // for inorder

                inorder.add(node.val);
                current.state++;
                if (node.right != null) {
                    st.push(new Pair(node.right, 0));
                }
            } else {
                //for postorder
                postorder.add(node.val);
                st.pop();
            }

        }

        return Map.of(
                "preorder", preordrer,
                "inorder", inorder,
                "postorder", postorder

        );
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        Map<String, List<Integer>> result = unifiedTraveral(root);

        System.out.println("Pre-order: " + result.get("preorder"));
        System.out.println("In-order: " + result.get("inorder"));
        System.out.println("Post-order: " + result.get("postorder"));
    }
}
