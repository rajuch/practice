package hackerrank;

import java.util.Arrays;

public class NCR {

    public NCR() {
        System.out.println("fdsfs");
    }

    public static class LinkedListNode {
        int val;
        LinkedListNode next;

        LinkedListNode(int node_value) {
            val = node_value;
            next = null;
        }
    }

    public void test() {
        System.out.println("fdsfsda");
    }

    static LinkedListNode removeNodes(LinkedListNode list, int x) {
        LinkedListNode current = list;
        LinkedListNode prev = null;
        while (current != null) {
            if (current.val > x) {
                if (prev == null) {
                    list = list.next;
                } else {
                    prev.next = current.next;
                }
            } else {
                prev = current;
            }
            current = current.next;
        }
        return list;
    }

    static char roll (char ch) {
        if (ch > 'z') {
            ch = (char)('a' + ch - 'z' - 1);
        }
        return ch;
    }

    static String rollTheString(String s, int[] roll) {
        int size = roll.length;
        Arrays.sort(roll);
        String rolledString = "";
        int prev = -1;
        for (int i = 0; i < size; i++) {
            int toRoll = roll[i];
            if (prev != toRoll) {
                int timesToRoll = (size - i) % 26;
                char ch = (char)(s.charAt(toRoll -1) + timesToRoll);

                rolledString += roll(ch);
            }
            prev = toRoll;
        }
        return rolledString;
    }



    public static void main(String[] args) {
        int[] arr = {1,2,2,3,3};
        String rolled = rollTheString("abz", arr);
        System.out.println(rolled);
        //System.out.println(roll((char)98));
    }
}
