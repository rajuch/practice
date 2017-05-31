package leetcode.contest34;

/**
 * https://leetcode.com/contest/leetcode-weekly-contest-34/problems/array-nesting/
 */
public class ArrayNesting {

    public static int arrayNesting(int[] nums) {
        int maxLength = 0, size;

        for (int i = 0; i < nums.length; i++) {
            size = 0;
            for (int j = i; nums[j] >= 0; size++) {
                int k = nums[j];
                nums[j] = -1;
                j = k;
            }
            maxLength = Math.max(maxLength, size);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int arr[] = {0, 1, 2};
        System.out.println(arrayNesting(arr));
    }
}
