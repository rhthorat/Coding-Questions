import java.util.*;
class Main {
  public static class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
    TreeNode(int data, TreeNode left, TreeNode right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  static HashMap<Integer, Integer> map;
  static int preorderIndex;
  
  public static TreeNode buildTree(int[] preorder, int[] inorder) {
    preorderIndex = 0;
    map = new HashMap<Integer, Integer>();
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }
    TreeNode root = buildBinaryTree(preorder, 0, preorder.length - 1);
    return root;
  }

  public static TreeNode buildBinaryTree(int[] preorder, int left, int right) {
    if (left > right) {
      return null;
    }
    int rootVal = preorder[preorderIndex];
    preorderIndex++;
    TreeNode node = new TreeNode(rootVal);
    node.left = buildBinaryTree(preorder, left, map.get(rootVal) - 1);
    node.right = buildBinaryTree(preorder, map.get(rootVal) + 1, right);
    return node;
  }

  //traversing to verify if i got the tree right
  public static void PreorderTraversal(TreeNode node) {
    if (node == null) {
      return;
    }
    System.out.print(node.data + " -> ");
    PreorderTraversal(node.left);
    PreorderTraversal(node.right);
  }
  
  public static void main(String[] args) {
    int[] preorder = {3,9,8,14,20,15,7};
    int[] inorder = {8,9,14,3,15,20,7};
    TreeNode root = buildTree(preorder, inorder);
    System.out.println("Pre-order traversal of tree");
    PreorderTraversal(root);
  }
}