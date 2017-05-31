package gfg.tree;

public class Node {
    public int data;
    public Node left;
    public Node right;
    public Node nextRight;
    public String path = "";
    public int length = 0;
    public Node(int data) {
        this.data = data;
    }
}
