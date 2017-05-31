package leetcode.contest33;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubSequence {


    public int findLHS(int[] nums) {
        Map<Integer, Integer> numberCount = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = numberCount.getOrDefault(nums[i], 0);
            numberCount.put(nums[i], count + 1);

        }
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = numberCount.getOrDefault(nums[i] - 1, 0);
            if (count != 0 ) {
                count +=  numberCount.get(nums[i]);
            }
            if (maxCount < count) {
                maxCount = count;
            }
            count = numberCount.getOrDefault(nums[i] + 1, 0);
            if (count != 0 ) {
                count +=  numberCount.get(nums[i]);
            }
            if (maxCount < count) {
                maxCount = numberCount.getOrDefault(nums[i] + 1, 0);
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        LongestHarmoniousSubSequence obj = new LongestHarmoniousSubSequence();
        int[] arr = {1,3,2,2,5,2,3,7};
        System.out.println(obj.findLHS(arr));

    }
}
