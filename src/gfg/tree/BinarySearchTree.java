package gfg.tree;

public class BinarySearchTree {
    private Node root;

    private void insert(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }
        Node temp = root, parent = null;
        Node newNode = new Node(data);
        while(temp != null) {
            parent = temp;
            if (temp.data > data) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        if (parent.data > data) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }

    private int maxInTree(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node.data;
    }

    private int minInTree(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }

    private boolean isBST(Node node) {
        if (node == null) {
            return true;
        }
        if (node.left != null && node.data < maxInTree(node.left)) {
            return false;
        }
        if (node.right != null && node.data > minInTree(node.right)) {
            return false;
        }
        return true;
    }

    private int lowestCommonAncestor(Node node1, Node node2) {
        return 0;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(5);
        tree.insert(10);
        tree.insert(11);
        tree.insert(3);
        tree.insert(4);
        tree.insert(2);
        BinaryTree.inOrder(tree.root);
        System.out.println(tree.isBST(tree.root));
    }
}
