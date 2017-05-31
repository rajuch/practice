package carerrcup.amazon;

// https://www.careercup.com/question?id=6248466092130304

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PresidentialVote {

    public static void minHeap() {
        PriorityQueue<Integer> heap = new PriorityQueue<>(3);
        heap.offer(10);
        heap.offer(5);
        heap.offer(7);

        System.out.println(heap.peek());
        int top = heap.peek();
        heap.remove(top);
        heap.add(11);
        System.out.println(heap.peek());

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int k = input[1];

        int maxVotes = 0;
        int totalVotes = 0;

        List<Integer> people = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        while (n-- > 0) {
            int[] tokens = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            totalVotes += tokens[1];
            if (tokens[0] == 0) {
                maxVotes += tokens[1];
            } else {
                if (minHeap.size() > k) {
                    if (tokens[1] > minHeap.peek()) {
                        minHeap.poll();
                        minHeap.offer(tokens[1]);
                    }
                } else {
                    minHeap.offer(tokens[1]);
                }
            }
        }

        for (int v : minHeap) {
            maxVotes += v;
        }
        System.out.println(maxVotes);
        System.out.println(totalVotes - maxVotes);
    }
}
