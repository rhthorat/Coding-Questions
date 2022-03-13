/* Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Example 2:

Input: nums = [1]
Output: 1
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
  */
import java.util.*;
class Main {
  public static int findMaxSubArraySum(int[] nums) {
    int maxEndingHereSum = nums[0];
    int maxOfAll = nums[0];

    for (int i = 1; i < nums.length; i++) {
      maxEndingHereSum = Math.max(nums[i], nums[i] + maxEndingHereSum);
      maxOfAll = Math.max(maxOfAll, maxEndingHereSum);
    }
    return maxOfAll;
  }
  public static void main(String[] args) {
    int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
    System.out.println("Max Sub Array Sum is: " + findMaxSubArraySum(arr));
  }
}