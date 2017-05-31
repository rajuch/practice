package hackerearth;

/**
 * There are a lot of Poke'mons who are jealous of the fact that they do NOT have any specialty, they're the... normal type of Poke'mon. But, what they fail to realize is that their power is their normalcy, the ability to think, rationalize and then act.

 But, they do have an additional power... Poke'mons like Jigglypuff - which are normal, can figure out if a trainer is real or is a part of Team Rocket. And they need to use their power to a great extent.

 In an array, which consists of
 N
 N elements, A1, A2, ..., AN, if a subarray has the total number of distinct elements as that of the original array, that determines the presence of Team Rocket.

 You've to help the normal type Poke'mons in figuring out the total number of subarrays having total number of distinct elements same as that of the original array.

 Input format:
 The first line of the input will consist of a single integer
 N
 N. The next line will consist of
 N
 N integers A1, A2, ... , AN.

 Output format: Output the answer to the problem.

 Constraints:
 1 ≤
 N
 N ≤ 2 * 10^5
 1 ≤
 A
 Ai ≤ 10^9

 Sample Input:
 5
 1 2 2 1 1
 O/p
 8

 Explanation
 All the possible subarrays are [1,2] , [1,3] , [1,4] , [1,5] , [2,4] , [2,5] , [3,4] , [3,5]
 */

import java.util.Scanner;

public class NormalType {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = sc.nextLine().split(" ");
    }
}
