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
    
    //getHeight Of Tree function
    public int getHeightOfTree(Node root) {
      if (root == null) {
        return 0;
      }
      int leftSubTreeHeight = getHeightOfTree(root.left);
      int rightSubTreeHeight = getHeightOfTree(root.right);
      return Math.max(leftSubTreeHeight, rightSubTreeHeight) + 1;
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
    //int[] preorderedNodes = {10,7,4,-1,-1,8,-1,-1,15,-1,20,-1,-1};

    int[] preorderedNodes = {10,6,4,3,-1,-1,5,-1,-1,8,7,-1,-1,9,-1,-1,15,-1,20,-1,-1};
    
    BinaryTree tree = new BinaryTree();
    Node root = tree.buildTree(preorderedNodes);
    int height = tree.getHeightOfTree(root);
    //tree.inorderTraversal(root);

    System.out.println("Height of Tree is " + height);
  }
}