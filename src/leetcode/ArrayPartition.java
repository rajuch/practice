package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/array-partition-i/#/description
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer,
 * say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 *
 * Pending
 */
public class ArrayPartition {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        return nums[0] + nums[nums.length-1];
    }

    public static void main(String[] args) {
        ArrayPartition obj = new ArrayPartition();
        int[] nums = {1,4,3,2};
        System.out.println(obj.arrayPairSum(nums));
    }
}
