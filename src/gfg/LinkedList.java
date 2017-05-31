package gfg;

class Node {
    public int data;
    public Node next;
    public Node rand;
    public Node() {

    }
    public Node(int data) {
        this.data = data;
    }
}
public class LinkedList {

    private static int add(Node node1, Node node2) {
        int sum = 0;
        if (node1.next != null && node2.next != null) {
            sum = add(node1.next, node2.next);
        }
        int div = sum/10;
        int rem = sum % 10;
        //node1.data + node2.data;
        return 0;
    }

    private static Node reverse(Node node) {
        Node node1 = node, node2 = node1.next, node3;
        node1.next = null;
        while (node2 != null) {
            node3 = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = node3;
        }
        return node1;
    }

    private static void updateRandToNextGreatest(Node head) {
        Node temp = head;
        while (temp != null) {
            Node node1 = head;
            while (node1 != null) {
                if (temp.rand == null && temp.data < node1.data) {
                    temp.rand = node1;
                } else if (temp.rand != null && temp.data < node1.data && temp.rand.data > node1.data) {
                    temp.rand = node1;
                }
                node1 = node1.next;
            }
            temp = temp.next;
        }
        print(head);
    }
    private static void reverse(Node head, int k) {
        Node temp = head, tail = null;
        Node newHead = null;
        while (temp != null) {
            Node node1 = temp, node2 = null;
            for (int i=0; i < k && temp != null; i++) {
                node2 = temp;
                temp = temp.next;
            }
            node2.next = null;
            Node tempHead = reverse(node1);
            if (tail != null) {
                tail.next = tempHead;
            } else {
                tail = head;
                newHead = tempHead;
            }
        }
        print(newHead);
    }

    private static void print(Node node) {
        Node temp = node;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.rand;
        }
    }

    private static Node addNumbers(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return null;
        }
        Node newNode = new Node();
        newNode.next = addNumbers(node1.next, node2.next);
        return null;//int sum = (node1.data + node2.data + carry) / 10;

        //return  (node1.data + node2.data + carry) % 10;

    }

    /**
     * http://www.geeksforgeeks.org/sort-linked-list-already-sorted-absolute-values/
     */
    private static Node sortLinkedList(Node head) {
        Node node = head, prev = null;
        while (node != null) {
            if (node.data < 0 && prev != null) {
                prev.next = node.next;
                node.next = head;
                head = node;
                node = prev.next;
            } else {
                prev = node;
                node = node.next;
            }
        }
        return head;
    }

    private static Node findMiddle(Node head) {
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * http://www.geeksforgeeks.org/rearrange-a-given-linked-list-in-place/
     * Given a singly linked list L0 -> L1 -> … -> Ln-1 -> Ln.
     * Rearrange the nodes in the list so that the new formed list is : L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 …
     * @param head
     */
    private static Node rearrange(Node head) {
        Node middle = findMiddle(head);
        middle.next = null;
        Node head2 = reverse(middle.next);

        Node node1 = head, node2 = head2, node3;
        while (node1 != null && node2 != null) {
            //
        }
        return head;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(8);
        node.next.next = new Node(4);
        node.next.next.next = new Node(3);
        node.next.next.next.next = new Node(6);
        node.next.next.next.next.next = new Node(1);

        updateRandToNextGreatest(node);
        //reverse(node, 6);

        //reverse(node);
        System.out.println(2147483647 > Integer.MAX_VALUE);

    }

}
