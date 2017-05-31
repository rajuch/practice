package leetcode;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/#/description
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree
 * is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 */
public class DiameterOfBinaryTree {

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lHeight = height(root.left);
        int rHeight = height(root.right);

        return lHeight > rHeight ? lHeight + 1 : rHeight + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lHeight = height(root.left);
        int rHeight = height(root.right);

        int lDiameter = diameterOfBinaryTree(root.left);
        int rDiameter = diameterOfBinaryTree(root.right);

        return Math.max(lHeight + rHeight + 1, Math.max(lDiameter, rDiameter));
    }

    public static void main(String[] args) {

    }
}
