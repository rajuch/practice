package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        List<Integer> values = new ArrayList<>();
        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node == null) {
                list.add(values);
                values = new ArrayList<>();
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
                continue;
            }
            values.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return list;
    }
}
