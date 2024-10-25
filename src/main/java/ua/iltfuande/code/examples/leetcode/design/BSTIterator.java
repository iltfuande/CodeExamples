package ua.iltfuande.code.examples.leetcode.design;

import ua.iltfuande.code.examples.leetcode.design.util.TreeNode;

import java.util.Stack;

public class BSTIterator {

    private final Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        addLeft(root);
    }

    public int next() {
        TreeNode node = stack.pop();
        if (node.right != null) {
            addLeft(node.right);
        }
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void addLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
