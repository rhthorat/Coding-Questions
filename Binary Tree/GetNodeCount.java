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
    static int count = 0;
    public static Node buildTree(int[] nodes) {
      idx++;
      if (nodes[idx] == -1) {
        return null;
      }
      Node newNode = new Node(nodes[idx]);
      newNode.left = buildTree(nodes);
      newNode.right = buildTree(nodes);

      return newNode;
    }

    public static int getNodeCount(Node node) {
      if (node == null) {
        return 0;
      }
      count = count + 1;
      getNodeCount(node.left);
      getNodeCount(node.right);
      return count;
    }
  }
  public static void main(String[] args) {
    int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
    BinaryTree tree = new BinaryTree();
    Node root = tree.buildTree(nodes);
    int nodeCount = tree.getNodeCount(root);
    System.out.println("Node count is " + nodeCount);
  }
}