package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < length; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = i; j < length; j++) {
                int c = nums[i] + nums[j];
                if (map.get(-c) != null && map.get(-c) > j) {
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[map.get(-c)]);
                    System.out.println(nums[i] + " " + nums[j] + " " + nums[map.get(-c)]);
                }
            }
            if (temp.size() > 0) {
                res.add(temp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        threeSum(arr);
    }
}
