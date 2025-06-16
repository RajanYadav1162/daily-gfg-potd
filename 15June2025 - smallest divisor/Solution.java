/*
Smallest Divisor
Difficulty: MediumAccuracy: 50.74%Submissions: 25K+Points: 4Average Time: 25m
Given an integer array arr[] and an integer k (where k ≥ arr.length), find the smallest positive integer divisor such that the sum of the ceiling values of each element in arr[] divided by this divisor is less than or equal to k.

Examples:

Input: arr[] = [1, 2, 5, 9], k = 6
Output: 5
Explanation: 5 is the smallest divisor having sum of quotients (1 + 1 + 1 + 2 = 5) less than or equal to 6.
Input: arr[] = [1, 1, 1, 1], k = 4
Output: 1
Explanation: 1 is the smallest divisor having sum of quotients (1 + 1 + 1 + 1 = 4) less than or equal to 4.
Constraints:
1  ≤  arr.size()  ≤ 105
1  ≤  arr[i]  ≤ 106
arr.size()  ≤ k  ≤ 106
 */

//trick - minization/maximization of answer kind problem.
class Solution {

  int smallestDivisor(int[] arr, int k) {
    // Code here
    int left = 1, right = Arrays.stream(arr).max().getAsInt();

    while (left < right) {
      int mid = left + (right - left) / 2;
      int temp = 0;
      for (int a : arr) {
        temp += Math.ceil(a / (mid * 1.0));
        if (temp > k) {
          break;
        }
      }

      if (temp > k) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }

    return left;
  }
}