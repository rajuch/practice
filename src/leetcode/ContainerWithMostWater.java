package leetcode;

/**
 * https://leetcode.com/problems/container-with-most-water/#/description
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 */
public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int i = 0, j = height.length - 1;
        while (i < j) {
            int h = Math.min(height[i], height[j]);
            max = Math.max(max, (j - i)* h);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int heights[] = {2, 3, 7, 8, 4};
        System.out.println(maxArea(heights));
    }
}
