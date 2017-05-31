package gfg.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BinaryTree {

    private Node root;
    private Map<Integer, List<Node>> map = new TreeMap<>();

    public void create() {
        Node node = new Node(35);
        root = node;
        Node node1 = new Node(11);
        Node node2 = new Node(7);

        node.left = node1;
        node.right = node2;

        node1.left = new Node(5);
        node1.right = new Node(6);

        node2.left = new Node(3);
        node2.right = new Node(4);
    }

    private void levelOrder() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()) {
            Node node = q.remove();
            if (node == null) {
                if (!q.isEmpty()) {
                    q.add(null);
                    System.out.println();
                }
                continue;
            }
            if (node.left != null)
                q.add(node.left);
            if (node.right != null)
                q.add(node.right);
            System.out.print(node.data);
        }
    }

    private void connectAtSameLevel(Node node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            node.left.nextRight = node.right;
        }
        if (node.right != null) {
            node.right.nextRight = node.nextRight != null ? node.nextRight.left : null;
        }
        connectAtSameLevel(node.left);
        connectAtSameLevel(node.right);
    }

    private boolean areIdentical(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return root1.data == root2.data && areIdentical(root1.left, root2.left) && areIdentical(root1.right, root2.right);
    }

    /**
     * Check tree1 is sub tree of tree2
     * @param root1 root node of tree1
     * @param root2 root node of tree2
     */
    private boolean isSubTreeOf(Node root1, Node root2) {
        if (root1 == null) {
            return true;
        }
        if (areIdentical(root1, root2)) {
            return true;
        }
        return isSubTreeOf(root1, root2.left) || isSubTreeOf(root1, root2.right);
    }

    private boolean isLeaf(Node node) {
        if (node.left == null && node.right == null) {
            return true;
        }
        return false;
    }

    private boolean isSumTree(Node node) {
        if (node == null || isLeaf(node)) {
            return true;
        }
        if (isSumTree(node.left) && isSumTree(node.right)) {
            int sum = 0;
            if (node.left != null) {
                if (isLeaf(node.left)) {
                    sum += node.left.data;
                } else {
                    sum += 2*node.left.data;
                }
            }
            if (node.right != null) {
                if (isLeaf((node.right))) {
                    sum += node.right.data;
                } else {
                    sum += 2*node.right.data;
                }
            }
            return sum == node.data;
        }
        return false;
    }

    private boolean printAncestorsOf(Node node, int target) {
        if (node == null) {
            return false;
        }
        if (node.data == target) {
            System.out.print(node.data + "->");
            return true;
        }
        if (printAncestorsOf(node.left, target) || printAncestorsOf(node.right, target)) {
            System.out.print(node.data + "->");
            return true;
        }
        return false;
    }

    private int getLevel(Node node, int target) {
        if (node == null) {
            return 0;
        }
        if (node.data == target) {
            return 1;
        }
        return 1 + Math.max(getLevel(node.left, target), getLevel(node.right, target));
    }

    private void printNodesAt(int level, Node node) {
        if (node == null) {
            return;
        }
        if (level == 0) {
            System.out.println(node.data);
        }
        printNodesAt(level-1, node.left);
        printNodesAt(level-1, node.right);
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        int lHeight = height(node.left);
        int rHeight = height(node.right);

        return lHeight > rHeight ? lHeight + 1 : rHeight + 1;
    }

    private int getMaxWidth() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int width = 0;
        while(!q.isEmpty()) {

        }
        return width;
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

    private int longestPath(Node node) {
        if (node == null) {
            return 0;
        }
        int l = longestPath(node.left);
        int r = longestPath(node.right);
        node.length = 1 + l > r ? l : r;
        if (l > r) {
            node.length = l + 1;
            node.path = node.data + (node.left != null ? "," + node.left.path : "");
        } else {
            node.length = r + 1;
            node.path = "" + node.data +  (node.right != null ? "," + node.right.path : "");
        }
        return node.length;
    }

    private int printNodesWithLeavesof(Node node, int k) {
        if (node == null) {
            return 0;
        }
        int leaves = 0;
        if (node.left == null && node.right == null) {
            leaves++;
        } else {
            leaves += printNodesWithLeavesof(node.left, k);
            leaves += printNodesWithLeavesof(node.right, k);
        }
        if (leaves == k) {
            System.out.println("k leaves " + node.data);
        }
        return leaves;
    }

    private static void printAtDistanceK(Node root, int k) {
        if (root == null) {
            return;
        }
        if (k == 0) {
            System.out.println(root.data);
            return;
        }
        printAtDistanceK(root.left, k-1);
        printAtDistanceK(root.right, k-1);
    }

    private void traverseInVertical(Node node, int level) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            traverseInVertical(node.left, level + 1);
        }
        if (map.get(level) == null) {
            map.put(level, new ArrayList<>());
        }
        map.get(level).add(node);
        if (node.right != null) {
            traverseInVertical(node.right, level-1);
        }
    }

    private void printInVertical() {
        for (Integer level : map.keySet()) {
            for (Node node : map.get(level)) {
                System.out.println(level + " -> " + node.data);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.create();
        System.out.println("********** Level order**************");
        tree.levelOrder();
        System.out.println("********** Sum Tree***********");
        System.out.println(tree.isSumTree(tree.root));
        System.out.println("******Ancestors of Node********");
        tree.printAncestorsOf(tree.root, 4);
        System.out.println("******Level of node*******");
        System.out.println(tree.getLevel(tree.root, 35));
        System.out.println("*******Height***********");
        System.out.println(tree.height(tree.root));
        System.out.println("*******Longest path***********");
        tree.longestPath(tree.root);
        System.out.println(tree.root.path);
        tree.printNodesWithLeavesof(tree.root, 2);
        System.out.println("************Vertical order**************");
        tree.traverseInVertical(tree.root, 0);
        tree.printInVertical();
    }
}
