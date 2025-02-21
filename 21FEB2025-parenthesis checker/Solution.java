/*
Given a string s, composed of different combinations of '(' , ')', '{', '}', '[', ']', verify the validity of the arrangement.
An input string is valid if:

         1. Open brackets must be closed by the same type of brackets.
         2. Open brackets must be closed in the correct order.

Examples :

Input: s = "[{()}]"
Output: true
Explanation: All the brackets are well-formed.
Input: s = "[()()]{}"
Output: true
Explanation: All the brackets are well-formed.
 */

//very standard stack question
class Solution {

  static boolean isBalanced(String s) {
    // code here
    Deque<Character> stack = new LinkedList<>();

    for (char ch : s.toCharArray()) {
      if (ch == '[' || ch == '{' || ch == '(') {
        stack.push(ch);
      } else {
        if (stack.isEmpty()) {
          return false;
        }
        if (stack.peek() != map(ch)) {
          return false;
        }
        stack.pop();
      }
    }

    return stack.isEmpty();


  }

  public static Character map(Character ch) {
    if (ch == ']') {
      return '[';
    } else if (ch == ')') {
      return '(';
    } else {
      return '{';
    }
  }
}
