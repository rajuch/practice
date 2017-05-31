package gfg.dp;

public class CoinChange {

    private static int changeCountWays(int[] coins, int noOfCoins, int total) {

        if (noOfCoins == 0 || total < 0) {
            return 0;
        }
        if (total == 0) {
            return 1;
        }

        return changeCountWays(coins, noOfCoins, total - coins[noOfCoins-1]) + changeCountWays(coins, noOfCoins-1, total);
    }

    public static void main(String[] args) {
        int[] coins = {1,2,3};
        System.out.println(changeCountWays(coins, 4, 0));
    }
}
