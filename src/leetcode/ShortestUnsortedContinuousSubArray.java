package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/contest/leetcode-weekly-contest-32/problems/shortest-unsorted-continuous-subarray/
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in
 * ascending order, then the whole array will be sorted in ascending order, too.
 *
 * You need to find the shortest such subarray and output its length.
 * Algorithm: create temporary array and sort it find the start and end indexes
 */
public class ShortestUnsortedContinuousSubArray {

    public static int findUnsortedSubarray(int[] nums) {
        int length = nums.length;
        int[] temp = Arrays.copyOf(nums, length);
        Arrays.sort(temp);
        int start=0;
        while (start < length && temp[start] == nums[start]) {
            start++;
        }
        int end = length - 1;
        while (end > 0 && temp[end] == nums[end]) {
            end--;
        }

        return end > start ? end - start + 1 : 0;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 2, 4};
        System.out.println(findUnsortedSubarray(arr));
    }
}
