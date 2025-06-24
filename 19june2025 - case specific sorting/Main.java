/*
Given a string s consisting of only uppercase and lowercase characters. The task is to sort uppercase and lowercase letters separately such that if the ith place in the original string had an Uppercase character then it should not have a lowercase character after being sorted and vice versa.

Examples :

Input: s = "GEekS"
Output: EGekS
Explanation: Sorted form of given string with the same case of character will result in output as EGekS.
 */


//main idea is separate lower and upper case character, sort individually and aggregate the result.

class Solution {

  public static String caseSort(String s) {
    // code here

    StringBuilder sb = new StringBuilder();

    List<Character> upper = new ArrayList<>();
    List<Character> lower = new ArrayList<>();

    for (char ch : s.toCharArray()) {
      if (Character.isLowerCase(ch)) {
        lower.add(ch);
      } else {
        upper.add(ch);
      }
    }

    upper.sort(Comparator.naturalOrder());
    lower.sort(Comparator.naturalOrder());

    int l = 0, r = 0;
    for (char ch : s.toCharArray()) {
      if (Character.isLowerCase(ch)) {
        sb.append(lower.get(l++));
      } else {
        sb.append(upper.get(r++));
      }
    }
    return sb.toString();

  }
}


