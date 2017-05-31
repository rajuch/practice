package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class RemoveNthNodeLinkedList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head, node1 = new ListNode(0);
        node1.next = head;
        for (int i = 0; i < n-1; i++) {
            node = node.next;
        }
        while (node.next != null) {
            node = node.next;
            node1 = node1.next;
        }
        node1.next = node1.next.next;
        return node1.next;
    }

    private void print(ListNode head) {
        while (head!= null) {
            System.out.println(head.val);
            head = head.next;
        }
    }


    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
//        node.next.next = new ListNode(3);
//        node.next.next.next = new ListNode(4);
//        node.next.next.next.next = new ListNode(5);
        RemoveNthNodeLinkedList obj = new RemoveNthNodeLinkedList();
        ListNode res = obj.removeNthFromEnd(node, 2);
        obj.print(res);
        Queue queue = new LinkedList<>();


    }
}
