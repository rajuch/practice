package leetcode;
// https://leetcode.com/problems/two-sum/#/description

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) == null) {
                map.put(nums[i], i);
            } else {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 5};
        int[] res = twoSum(arr, 9);
        System.out.println(res[0] + " " + res[1]);
    }

}
