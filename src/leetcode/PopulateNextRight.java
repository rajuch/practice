package leetcode;

public class PopulateNextRight {

    class TreeLinkNode {
        int val;
        TreeLinkNode next;
        TreeLinkNode left;
        TreeLinkNode right;

        public TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            root.left.next = root.right;
        }

        if (root.right != null) {
            root.right.next = root.next != null ? (root.next.left != null ? root.next.left : root.next.right) : null;
        }

        connect(root.left);
        connect(root.right);
    }
}
