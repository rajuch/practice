package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/distribute-candies/#/description
 * Given an integer array with even length, where different numbers in this array represent different
 * kinds of candies.Each number means one candy of the corresponding kind. You need to distribute these
 * candies equally in number to brother and sister. Return the maximum number of kinds of candies the sister
 * could gain.
 */
public class DistributeCandies {

    public static int distributeCandies(int[] candies) {
        int length = candies.length;
        Set<Integer> different = new HashSet<>();
        for (int val : candies) {
            different.add(val);
        }
        return Math.min(different.size(), length/2);
    }

    public static void main(String[] args) {
        int[] candies = {1,2,3};
        System.out.println(distributeCandies(candies));
    }
}
