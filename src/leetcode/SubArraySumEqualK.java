package leetcode;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k/#/description
 * Given an array of integers and an integer k, you need to find the
 * total number of continuous subarrays whose sum equals to k.
 *
 */
public class SubArraySumEqualK {

    public int subarraySum(int[] nums, int k) {
        int noOfSubArrays = 0;
        int sum;
        for (int i = 0; i < nums.length; i++) {
            sum = nums[i];
            for (int j = i+1; i < nums.length; j++) {
                if (sum == k) {
                    noOfSubArrays++;
                }
                if (sum > k) {
                    break;
                }
                sum += nums[j];
            }
        }
        return noOfSubArrays;
    }

    public int subArraySumWithPreSum(int[] nums, int k) {
        return 0;
    }

    public static void main(String[] args) {
        SubArraySumEqualK obj = new SubArraySumEqualK();
    }
}
