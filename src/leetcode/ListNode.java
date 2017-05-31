package leetcode;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public void print(ListNode head) {
        while(head!= null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
