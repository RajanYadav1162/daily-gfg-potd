/*
You are given an array arr[] of integers, where each element represents the number of coins in a pile. You are also given an integer k.
Your task is to remove the minimum number of coins such that the absolute difference between the number of coins in any two updated piles is at most k.

Note: You can also remove a pile by removing all the coins of that pile.

Examples:

Input: arr[] = [2, 2, 2, 2], k = 0
Output: 0
Explanation: For any two piles the difference in the number of coins is <= 0. So no need to remove any coin.
Input: arr[] = [1, 5, 1, 2, 5, 1], k = 3
Output: 2
Explanation: If we remove one coin each from both the piles containing 5 coins, then for any two piles the absolute difference in the number of coins is <= 3.
Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 104
0 ≤ k ≤ 104
 */


//it took nearly 2 hours for me to finally come with proper solution

// main crux any item can be work as minimum, if that is so, how you can incorporate other item such that they are less than (item+k)

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {

    var res = new Solution().minimumCoins(new int[]{12, 4, 11, 12}, 3);
    System.out.println(res);
  }

}

class Solution {

  public int minimumCoins(int[] arr, int k) {

    int count = Integer.MAX_VALUE;
    int n = arr.length;
    Arrays.sort(arr);
    // 1 1 1 2 5 5
    int[] prefix = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      prefix[i] = prefix[i - 1] + arr[i - 1];
    }
    // System.out.println(Arrays.toString(arr));

    for (int i = 0; i < n; i++) {

      int idx = find(arr, i + 1, arr[i] + k + 1);
      int idx2 = find(arr, 0, arr[i]);
      int rs = idx >= n ? 0 : prefix[n] - prefix[idx];
      int ls = prefix[idx2];
      count = Math.min(count, (ls + (rs - ((arr[i] + k) * (n - idx)))));
      //   System.out.println(ls + "  " + rs + "  " + (ls + (rs - ((arr[i] + k) * (n - idx)))));
    }
    return count;
  }

  public int find(int[] arr, int left, int target) {
    int right = arr.length;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] >= target) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

}
