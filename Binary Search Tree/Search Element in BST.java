class Main {
  public static class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  public static class BinaryTree {
    static int idx = -1;
    
    //search in tree
    public Boolean searchNode(Node root, int n) {
      if (root == null) {
        return false;
      }
      if (root.data == n) {
        return true;
      }
      if (n < root.data) {
        return searchNode(root.left, n);
      } else {
        return searchNode(root.right, n);
      }
    }
    
    //supporting methods
    public Node buildTree(int[] nodes) {
      idx++;
      if (nodes[idx] == -1) {
        return null;
      }
      Node newNode = new Node(nodes[idx]);
      newNode.left = buildTree(nodes);
      newNode.right = buildTree(nodes);

      return newNode;
    }

    public void inorderTraversal(Node node) {
      if (node == null) {
        return;
      }
      inorderTraversal(node.left);
      System.out.print(node.data + " -> ");
      inorderTraversal(node.right);
    }
  }
  public static void main(String[] args) {
    int[] nodes = {10,7,4,-1,-1,8,-1,-1,15,14,13,-1,-1,-1,20,-1,-1};
    BinaryTree tree = new BinaryTree();
    Node root = tree.buildTree(nodes);
    
    tree.inorderTraversal(root);

    System.out.println();
    int n = 13;
    System.out.println("Is the element " + n + " present in the tree: " + tree.searchNode(root, 50));
  }
}