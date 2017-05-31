package hackerearth.janEasy;

import java.util.Arrays;
import java.util.Scanner;

public class ColorfulToys {

    private static int getMaxIndex(long[] prices) {
        long type3Price = prices[2] - prices[3];
        return prices[0] > prices[1] ? prices[0] < type3Price ? 2 : 0 : prices[1] > type3Price ? 1 : 2;
    }

    private static boolean hasIndividualCostMoreProfit(int maxIndex, long[] prices ) {
        long individualCost = 2 * prices[3];
        long toyCost = maxIndex == 2 ? prices[2] - prices[3] : prices[maxIndex];
        return individualCost > toyCost;
    }

    private static long cost(int[] counts, long[] prices, int maxIndex) {
        if (maxIndex == 0) {
            int remove = counts[0] > counts[1] ? counts[1] : counts[0];
            counts[1] -= remove;
            counts[0] -= remove;
            return remove * prices[0];
        }
        if (maxIndex == 1) {
            int remove = counts[1] > counts[2] ? counts[2] : counts[1];
            counts[1] -= remove;
            counts[2] -= remove;
            return remove * prices[1];
        }
        if (maxIndex == 2) {

        }
        return 0;
    }

    private static long profit(int[] counts, long[] prices) {
        int maxIndex = getMaxIndex(prices);
        if (hasIndividualCostMoreProfit(maxIndex, prices)) {
            return (counts[0] + counts[1] + counts[2]) * prices[3];
        }


        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < tests; i++) {
            int[] counts = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            long[] prices = Arrays.stream(scanner.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();

        }

    }
}
