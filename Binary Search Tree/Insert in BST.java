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
    
    //insertion function
    public Node insertNode(Node root, Node node) {
      if (root == null) {
        return node;
      }
      if (node.data < root.data) {
        root.left = insertNode(root.left, node);
      } else {
        root.right = insertNode(root.right, node);
      }
      return root;
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
    int[] nodes = {10,7,4,-1,-1,8,-1,-1,15,-1,20,-1,-1};
    BinaryTree tree = new BinaryTree();
    Node root = tree.buildTree(nodes);
    Node node = new Node(13);
    root = tree.insertNode(root, node);
    
    tree.inorderTraversal(root);
  }
}