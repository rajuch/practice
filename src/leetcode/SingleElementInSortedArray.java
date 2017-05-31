package leetcode;

public class SingleElementInSortedArray {

    private static int search(int[] nums, int low, int high) {
        if (low == high) {
            return nums[low];
        }
        int mid = (low + high) / 2;
        if (((mid - low + 1) % 2) == 0) {
            if (nums[mid] == nums[mid - 1]) {
                return search(nums, mid+1, high);
            } else {
                return search(nums, low, mid-1);
            }
        } else {
            if (nums[mid] == nums[mid - 1]) {
                return search(nums, low, mid);
            } else if (nums[mid] == nums[mid+1]) {
                return search(nums, mid, high);
            } else {
                return nums[mid];
            }
        }
    }

    public static int singleNonDuplicate(int[] nums) {
        return search(nums, 0, nums.length-1);
    }

    public static void main(String[] args) {
        int arr[] = {1,1,2,2,3,3,4,4,5,5,7,7,8,8,11};
        System.out.println(singleNonDuplicate(arr));
    }
}
