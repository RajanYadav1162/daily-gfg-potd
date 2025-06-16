/*
Koko is given an array arr[], where each element represents a pile of bananas. She has exactly k hours to eat all the bananas.

Each hour, Koko can choose one pile and eat up to s bananas from it.

If the pile has atleast s bananas, she eats exactly s bananas.

If the pile has fewer than s bananas, she eats the entire pile in that hour.

Koko can only eat from one pile per hour.


Your task is to find the minimum value of s (bananas per hour) such that Koko can finish all the piles within k hours.

Examples:

Input: arr[] = [5, 10, 3], k = 4
Output: 5
Explanation: Koko eats at least 5 bananas per hour to finish all piles within 4 hours, as she can consume each pile in 1 + 2 + 1 = 4 hours.
 */


/*
idea:-
1. identify its binary search problem.
2. minimisation with optimizations.
 */

class Solution {

  public int kokoEat(int[] arr, int k) {

    int left = 0, right = Arrays.stream(arr).max().getAsInt();

    while (left < right) {
      int mid = left + (right - left) / 2;

      int req = 0;

      for (int a : arr) {
        req += Math.ceil(a / (mid * 1.0));
        if (req > k) {
          break;
        }
      }

      if (req <= k) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }

    return left;
  }
}
