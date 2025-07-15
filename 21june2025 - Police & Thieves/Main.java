/*
Given an array arr[], where each element contains either a 'P' for policeman or a 'T' for thief. Find the maximum number of thieves that can be caught by the police.
Keep in mind the following conditions :

Each policeman can catch only one thief.
A policeman cannot catch a thief who is more than k units away from him.
Examples:

Input: arr[] = ['P', 'T', 'T', 'P', 'T'], k = 1
Output: 2
Explanation: Maximum 2 thieves can be caught. First policeman catches first thief and second police man can catch either second or third thief.
Input: arr[] = ['T', 'T', 'P', 'P', 'T', 'P'], k = 2
Output: 3
 */

class Solution {

  public int catchThieves(char[] arr, int k) {
    // code here
    int n = arr.length;

    int left = 0, right = 0;
    int count = 0;
    while (left < n && right < n) {
      while (left < n && arr[left] != 'P') {
        left++;
      }
      while (right < n && arr[right] != 'T') {
        right++;
      }

      if (left == n || right == n) {
        break;
      }

      if (Math.abs(left - right) <= k) {
        count++;
        left++;
        right++;
      } else if (left < right) {
        left++;
      } else {
        right++;
      }
    }

    return count;
  }
}