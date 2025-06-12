/*
You are given a sorted array arr[] of unique integers, an integer k, and a target value x. Return exactly k elements from the array closest to x, excluding x if it exists.

An element a is closer to x than b if:


|a - x| < |b - x|, or
|a - x| == |b - x| and a > b (i.e., prefer the larger element if tied)


Return the k closest elements in order of closeness.

Examples:

Input: arr[] = [1, 3, 4, 10, 12], k = 2, x = 4
Output: 3 1
Explanation: 4 is excluded, Closest elements to 4 are: 3 (1), 1 (3). So, the 2 closest elements are: 3 1
 */


class Solution {

  int[] printKClosest(int[] arr, int k, int x) {
    // code here
    int n = arr.length;

    PriorityQueue<int[]> pq = new PriorityQueue<>(
        (a, b) -> b[1] == a[1] ? Integer.compare(a[0], b[0]) : Integer.compare(b[1], a[1]));

    for (int a : arr) {
      if (a == x) {
        continue;
      }
      pq.offer(new int[]{a, Math.abs(a - x)});
      if (pq.size() > k) {
        pq.poll();
      }
    }

    int[] ans = new int[k];
    int i = 0;
    while (!pq.isEmpty()) {
      ans[k - i - 1] = pq.poll()[0];
      i++;
    }

    return ans;
  }
}
