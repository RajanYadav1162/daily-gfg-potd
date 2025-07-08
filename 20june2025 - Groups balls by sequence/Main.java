/*
You are given an array arr[] of positive integers, where each element arr[i] represents the number written on the i-th ball, and a positive integer k.
Your task is to determine whether it is possible to rearrange all the balls into groups such that:


Each group contains exactly k balls.
The numbers in each group are consecutive integers
Examples:

Input: arr[] = [10, 1, 2, 11], k = 2
Output: true
Explanation: The hand can be rearranged as [1, 2], [10, 11]. There are two groups of size 2. Each group has 2 consecutive cards.
 */

// main idea is, pick one smallest element, say 'a', try to find a+1 a+2..till k, then next 'a'...so on


class Solution {

  public boolean validgroup(int[] arr, int k) {

    Arrays.sort(arr);

    int n = arr.length;

    if (n % k != 0) {
      return false;
    }

    if (k == 1) {
      return true;
    }

    Map<Integer, Integer> map = new HashMap<>();

    for (int a : arr) {
      map.merge(a, 1, Integer::sum);
    }
    int i = 0;

    while (i < n) {
      int current = arr[i];
      if (!map.containsKey(current)) {
        i++;
        continue;
      }
      int count = 0;
      int req = current;
      while (count < k && map.containsKey(req)) {
        count++;
        map.merge(req, -1, Integer::sum);
        if (map.get(req) == 0) {
          map.remove(req);
        }
        req++;
      }

      if (count != k) {
        return false;
      }
      i++;
    }

    return true;
  }
}

