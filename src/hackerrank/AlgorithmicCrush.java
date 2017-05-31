package hackerrank;
//https://www.hackerrank.com/challenges/crush

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Pair {

    private int l;
    private int r;
    private int sum;

    public Pair(int l, int r, int sum) {
        this.l = l;
        this.r = r;
        this.sum = sum;
    }

    public int getL() {
        return l;
    }

    public int getR() {
        return r;
    }

    public int getSum() {
        return sum;
    }

    public void setL(int l) {
        this.l = l;
    }

    public void setR(int r) {
        this.r = r;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}

public class AlgorithmicCrush {

    private void maxVal(List<Pair> pairs, int size) {
        Pair temp;
        for (int i = 0; i < size; i++) {
            temp = pairs.get(i);
            for (int j = i+1; j < size; j++) {

            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        List<Pair> list = new ArrayList<>();
        while (n-- > 0) {
            list.add(new Pair(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
        }
    }
}
