/*
You are given an array heights[] representing the heights of towers and another array cost[] where each element represents the cost of modifying the height of respective tower.

The goal is to make all towers of same height by either adding or removing blocks from each tower.
Modifying the height of tower (add or remove) 'i' by 1 unit costs cost[i].
Return the minimum cost to equalize the heights of all towers.

Examples:

Input: heights[] = [1, 2, 3], cost[] = [10, 100, 1000]
Output: 120
Explanation: The heights can be equalized by either "Removing one block from 3 and adding one in 1" or "Adding two blocks in 1 and adding one in 2". Since the cost of operation in tower 3 is 1000, the first process would yield 1010 while the second one yields 120.
Input: heights[] = [7, 1, 5], cost[] = [1, 1, 1]
Output: 6
Explanation: The minimum cost to equalize the towers is 6, achieved by setting all towers to height 5.
Constraints:
1 ≤ heights.size() = cost.size() ≤ 105
1 ≤ heights[i] ≤ 104
1 ≤ cost[i] ≤ 103
 */


// this is not our typical binary search where i use predicte model based logic.
//here graph is kind of like unimodal(concave/convex), meaning we search for answer answer...find best answer...suddenly now data willl increase.
//use ternary search or modified binary search as below.
class Solution {

  public int minCost(int[] H, int[] C) {
    int left = Arrays.stream(H).min().getAsInt();
    int right = Arrays.stream(H).max().getAsInt();

    int minCost = Integer.MAX_VALUE;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      int c1 = find(H, C, mid);
      int c2 = find(H, C, mid + 1);

      minCost = Math.min(minCost, c1);

      if (c1 < c2) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return minCost;
  }

  public int find(int[] H, int[] C, int h) {
    int n = H.length;
    int cost = 0;
    for (int j = 0; j < n; j++) {
      cost += Math.abs(h - H[j]) * C[j];
    }
    return cost;
  }
}
