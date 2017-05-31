package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigZagOrder {

    private void zigZag(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) {
            return;
        }
        if (res.size() <= level) {
            res.add(new LinkedList<>());
        }
        List<Integer> vals = res.get(level);
        if (level % 2 == 0) {
            vals.add(root.val);
        } else {
            vals.add(0, root.val);
        }
        zigZag(root.left, res, level + 1);
        zigZag(root.right, res, level + 1);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        zigZag(root, res, 0);
        System.out.println(res.get(0).get(0));
        return res;
    }

    public static void main(String[] args) {
        BinaryTreeZigZagOrder obj = new BinaryTreeZigZagOrder();
        TreeNode node = new TreeNode(3);
        obj.zigzagLevelOrder(node);
    }
}
