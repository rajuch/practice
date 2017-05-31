package leetcode;

public class ValidBST {

    private boolean isValid(TreeNode root, long minVal, long maxVal) {
        if (root == null) {
            return true;
        }
        if (root.val >= maxVal || root.val <= minVal) {
            return false;
        }
        return isValid(root.left, minVal, root.val) && isValid(root.right, root.val, maxVal);
    }

    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static void main(String[] args) {
        ValidBST obj = new ValidBST();
        TreeNode node = new TreeNode(2147483647);
        System.out.println(obj.isValidBST(node));
    }
}
