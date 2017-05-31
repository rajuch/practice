package leetcode;

public class FindTilt {

    private int sum;

    private int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sum(root.left) + sum(root.right) + root.val;
    }

    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = 0, rightSum = 0;
        if (root.left != null) {
            leftSum = sum(root.left);
        }
        if (root.right != null) {
            rightSum = sum(root.right);
        }
        sum += Math.abs(leftSum-rightSum);
        findTilt(root.left);
        findTilt(root.right);
        return sum;
    }

    public static void main(String[] args) {
        FindTilt obj = new FindTilt();
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        node.left = node1;
        node.right = null;
        node1.left  = node2;
        node1.right = node3;
        //node2.left = node4;
        System.out.println(obj.findTilt(node));
    }
}
