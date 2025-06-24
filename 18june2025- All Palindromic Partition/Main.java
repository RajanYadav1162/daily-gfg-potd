/*
Given a string s, find all possible ways to partition it such that every substring in the partition is a palindrome.

Examples:

Input: s = "geeks"
Output: [[g, e, e, k, s], [g, ee, k, s]]
Explanation: [g, e, e, k, s] and [g, ee, k, s] are the only partitions of "geeks" where each substring is a palindrome.
Input: s = "abcba"
Output: [[a, b, c, b, a], [a, bcb, a], [abcba]]
Explanation: [a, b, c, b, a], [a, bcb, a] and [abcba] are the only partitions of "abcba" where each substring is a palindrome.
Constraints:
1 ≤ s.size() ≤ 20
 */

class Solution {

  ArrayList<ArrayList<String>> ans = new ArrayList<>();

  public ArrayList<ArrayList<String>> palinParts(String s) {
    // code here
    dfs(s, 0, new ArrayList<>());
    return ans;
  }

  public void dfs(String s, int i, List<String> psf) {

    if (i == s.length()) {
      ans.add(new ArrayList<>(psf));
    }

    StringBuilder sb = new StringBuilder();
    for (int j = i; j < s.length(); j++) {
      sb.append(s.charAt(j));
      if (pal(sb)) {
        psf.add(sb.toString());
        dfs(s, j + 1, psf);
        psf.remove(psf.size() - 1);
      }
    }
  }

  public boolean pal(StringBuilder sb) {
    int left = 0, right = sb.length() - 1;
    while (left < right) {
      if (sb.charAt(left) != sb.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
}