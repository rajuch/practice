package leetcode;


public class SubTreeOfAnotherTree {

    private static boolean areIdentical(TreeNode s, TreeNode t) {
        if (t == null && s == null) {
            return true;
        }
        if (t == null || s == null) {
            return false;
        }

        return s.val == t.val && areIdentical(s.left, t.left) && areIdentical(s.right, t.right);
    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) {
            return true;
        }
        if (s == null) {
            return false;
        }
        if (areIdentical(s, t)) {
            return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public static void main(String[] args) {


    }
}
