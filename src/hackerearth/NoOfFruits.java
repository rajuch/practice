package hackerearth;

import java.util.Arrays;
import java.util.Scanner;

/**
 * John loves fruits. He eats one apple, banana or pear literally every hour.

 John came to fruit shop to buy some fruits. He has
 m
 m coins that he is going to spend to buy as many fruits as he can. He counted the number of apples, bananas and pears, and he also knows the price of a single apple, the price of a single banana and the price of a single pear in this shop.

 Help John to buy the maximum number of fruits.

 Input format

 First line contains three integers a, b, p. the number of coins needed to be spend to buy one apple, one banana and one pear
  (1≤a,b,p≤100).

 Second line contains three integers ca, cb, cp- the number of apples, the number of bananas and the number of pears available in the store
 (1≤ca,cb,cp≤100).

 Third line contains integer m — the number of coins John owns (1≤m≤30000).

 Output format

 Output single integer — the maximum number of fruits John can buy.
 */
public class NoOfFruits {

    private static int getMinCostIndex(int[] costs, int prevMin, int prevMinIndex) {
        int temp = Integer.MAX_VALUE, tempIndex = -1;
        for (int i = 0; i < costs.length; i++) {
            if (costs[i] < temp && costs[i] >= prevMin && i !=prevMinIndex) {
                temp = costs[i];
                tempIndex = i;
            }
        }
        return tempIndex;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] costs = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] counts = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int noOfCoins = scanner.nextInt();
        int noOfFruits = 0;
        int prevMin = Integer.MIN_VALUE;
        int prevMinIndex = -1;
        for (int i = 0; i < costs.length; i++) {
            int minCostIndex = getMinCostIndex(costs, prevMin, prevMinIndex);
            int count = counts[minCostIndex];
            while((costs[minCostIndex] * count > noOfCoins) && count != 0) {
                count--;
            }
            if (count == 0) {
                break;
            }
            noOfFruits += count;
            noOfCoins -= costs[minCostIndex] * count;
            prevMin = costs[minCostIndex];
            prevMinIndex = minCostIndex;
        }
        System.out.println(noOfFruits);
    }
}
