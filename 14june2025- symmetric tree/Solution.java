/*
Symmetric Tree
Given the root of a binary tree, check whether it is symmetric, i.e., whether the tree is a mirror image of itself.


A binary tree is symmetric if the left subtree is a mirror reflection of the right subtree.

Examples:

Input: root[] = [1, 2, 2, 3, 4, 4, 3]
   ex-1_1
Output: True
Explanation: As the left and right half of the above tree is mirror image, tree is symmetric.
Input: root[] = [1, 2, 2, N, 3, N, 3]
   ex-2_1
Output: False
Explanation:  As the left and right half of the above tree is not the mirror image, tree is not symmetric.
 */

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

*/
class Solution {

  public boolean isSymmetric(Node root) {

    return dfs(root, root);
  }

  public boolean dfs(Node root1, Node root2) {

    if (root1 == null && root2 == null) {
      return true;
    }

    if (root1 == null || root2 == null) {
      return false;
    }

    if (root1.data != root2.data) {
      return false;
    }

    boolean c1 = dfs(root1.left, root2.right);
    boolean c2 = dfs(root1.right, root2.left);
    return c1 && c2;


  }
}