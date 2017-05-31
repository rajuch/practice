package gfg;

import java.util.Arrays;
import java.util.Scanner;

public class StockMaximizeProfit {

    private static void profit(int stocks[], int length) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, buyDay = -1, sellDay = -1;
        boolean maxFound = false, profit = false;
        for (int i=0; i < length; i++) {
            int stock = stocks[i];
            if (min > stock || stock < max) {
                if (maxFound) {
                    if (max > min) {
                        System.out.print("(" + buyDay + " " + sellDay + ") ");
                        profit = true;
                    }
                    maxFound = false;
                    max = Integer.MIN_VALUE;
                }
                min = stock;
                buyDay = i;
                continue;
            }
            if (max < stock) {
                max = stock;
                sellDay = i;
                maxFound = true;
            }
        }
        if (maxFound && max > min) {
            System.out.print("(" + buyDay + " " + sellDay + ")");
            profit = true;
        }
        if (!profit) {
            System.out.println("No Profit");
        } else {
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            scanner.nextLine();
            int[] stocks = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            profit(stocks, n);
        }

    }
}
