/* Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: [4,-1,2,1]
Explanation: [4,-1,2,1] has the largest sum = 6.

  */
import java.util.*;
class Main {
  public static int[] findMaxSubArraySum(int[] nums) {
    int maxSumEndingHere = nums[0];
    int maxOfAll = nums[0];
    int startIndex = 0;
    int endIndex = 0;
    for (int i = 0; i < nums.length; i++) {
      maxSumEndingHere = Math.max(nums[i], nums[i] + maxSumEndingHere);
      if (maxSumEndingHere == nums[i]) {
        startIndex = i;
      }
      if (maxSumEndingHere > maxOfAll) {
        endIndex = i;
      }
      maxOfAll = Math.max(maxOfAll, maxSumEndingHere);
    }
    int[] indices = {startIndex, endIndex};
    return indices;
  }
  public static void main(String[] args) {
    int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
    int[] indices = findMaxSubArraySum(arr);
    for (int i = indices[0]; i <= indices[1]; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }
}