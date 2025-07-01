/*

HARD - Given a garden with n flowers planted in a row, that is represented by an array arr[], where arr[i] denotes the height of the ith flower.You will water them for k days. In one day you can water w continuous flowers. Whenever you water a flower its height increases by 1 unit. You have to maximize the minimum height of all flowers after  k days of watering.

Examples:

Input: arr[] = [2, 3, 4, 5, 1], k = 2, w = 2
Output: 2
Explanation: The minimum height after watering is 2.
Day 1: Water the last two flowers -> arr becomes [2, 3, 4, 6, 2]
Day 2: Water the last two flowers -> arr becomes [2, 3, 4, 7, 3]
Input: arr[] = [5, 8], k = 5, w = 1
Output: 9
Explanation: The minimum height after watering is 9.
Day 1 - Day 4: Water the first flower -> arr becomes [9, 8]
Day 5: Water the second flower -> arr becomes [9, 9]
 */


class Solution {

  public int maxMinHeight(int[] arr, int k, int w) {
    // code here
    int n = arr.length;
    int left = Arrays.stream(arr).min().getAsInt();
    int right = Arrays.stream(arr).max().getAsInt() + k;

    while (left < right) {
      int mid = left + (right - left) / 2;
      if (!good(arr, k, w, mid)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
//
//    System.out.println(left + "  " + good(arr, k, w, left));
    return good(arr, k, w, left) ? left : left - 1;

  }

  public boolean good(int[] arr, int k, int w, int mid) {

    int n = arr.length;
    int[] prefix = new int[n + 1];
    int cs = 0;
    for (int i = 0; i < n; i++) {
      cs += prefix[i];
      if (cs + arr[i] < mid) {
        int diff = mid - (cs + arr[i]);
        k -= diff;
        if (k < 0) {
          return false;
        }
        cs += diff;
        prefix[Math.min(n, i + w)] -= diff;
      }
    }
    // System.out.println(Arrays.toString(prefix));
    return true;
  }
}