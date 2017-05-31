package leetcode;

public class MergeSortedLinkedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0), prev = head;
        while (l1 != null && l2 != null) {
            ListNode node;
            if (l1.val > l2.val) {
                node = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                node = new ListNode(l1.val);
                l1 = l1.next;
            }
            prev.next = node;
            prev = node;
        }
        ListNode temp = l1 == null ? l2 : l1;
        while (temp != null) {
            prev.next = new ListNode(temp.val);
            temp = temp.next;
        }
        return head.next;
    }

    public static void main(String[] args) {

    }
}
