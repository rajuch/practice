package hackerearth;

import java.util.Scanner;

public class PileOfStocks {

    private static String win(int stacks, int coins, String player ) {
        System.out.println(stacks + " " + coins + " " + player);
        if ((stacks - 1) == 0 || (stacks - 2 == 0)) {
            return player;
        }
        String nextPlayer = player.equals("Mojo") ? "Jojo" : "Mojo";
        String winner = win(stacks-1, coins, nextPlayer);
        if (winner.equals(player)) {
            System.out.println("stack1" + winner);
            return player;
        }
        winner = win(stacks-2, coins, nextPlayer);
        if (winner.equals(player)) {
            System.out.println("stack2" + winner);
            return player;
        }
        int coinsToBeRemoved = coins%2 == 0 ? coins/2 : (coins+1)/2;

        if ((coins - coinsToBeRemoved) > 0) {
            coins -= coinsToBeRemoved;
            winner = win(stacks, coins, nextPlayer);
            if (winner.equals(player)) {
                System.out.println("coins" + winner);
                return player;
            }
        }
        return nextPlayer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noOfTests = scanner.nextInt();
        for (int i = 0; i < noOfTests; i++) {
            int stacks = scanner.nextInt();
            int coins = scanner.nextInt();
            String winner = win(stacks, coins, "Mojo");
            System.out.println(winner);
        }
    }
}
