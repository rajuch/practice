package leetcode;

public class LinkedListSwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode node1 = head, prev = null, node2;
        while (node1 != null && node1.next != null) {
            node2 = node1.next.next;
            if (prev != null) {
                prev.next = node1.next;
            } else {
                head = node1.next;
            }

            node1.next.next = node1;
            node1.next = null;

            prev = node1;
            node1 = node2;
        }
        if (node1 != null && prev != null) {
            prev.next = node1;
        }

        return head;
    }

    public static void main(String[] args) {
        LinkedListSwapNodesInPairs obj = new LinkedListSwapNodesInPairs();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
//        node.next.next = new ListNode(3);
//        node.next.next.next = new ListNode(4);
        //node.next.next.next.next = new ListNode(5);
        ListNode res = obj.swapPairs(node);
        res.print(res);

    }
}
