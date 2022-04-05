//Reference link
//https://www.geeksforgeeks.org/find-distance-between-two-nodes-of-a-binary-tree/

class Main {
  private static int dist1 = -1, dist2 = -1, totalDist = 0;
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

    public static int findLevel(Node root, int n, int lev) {
    if (root == null) {
      return 0;
    }
    if (root.data == n) {
      return lev;
    }
    
    return findLevel(root.left, n, lev+1) + findLevel(root.right, n, lev+1);
  }
    
  public Node findDistanceBetweenNodes(Node root, int n1, int n2, int level) {
      //base condition
      if (root == null) {
        return null;
      }
      if (root.data == n1) {
        dist1 = level;
        return root;
      }
      if (root.data == n2) {
        dist2 = level;
        return root;
      }
    
      Node lhs = findDistanceBetweenNodes(root.left,n1,n2, level+1);
      Node rhs = findDistanceBetweenNodes(root.right,n1,n2, level+1);

      if (lhs != null && rhs != null) {
        totalDist = dist1 + dist2 - (2*level);
      }
      return lhs != null ? lhs : rhs;
    }
  }
  
  public static void main(String[] args) {
    int[] nodes = {10,7,4,-1,-1,8,-1,-1,15,14,13,-1,-1,-1,20,-1,-1};
    BinaryTree tree = new BinaryTree();
    Node root = tree.buildTree(nodes);
    int n1 = 14, n2 = 13;
    
    Node lcRoot = tree.findDistanceBetweenNodes(root, n1, n2, 1);

    //if level of n1 and n2 are found
    if (dist1 != -1 && dist2 != -1)
      System.out.println("Distance between the nodes is " + totalDist);

    //n1's level was not found as n2 was its ancestor
    if (dist1 == -1) {
      //n2 node is ancestor of n1, so we find each of their level
      int n1Level = tree.findLevel(root, n1, 1);
      System.out.println("Distance between the nodes is " + (n1Level - dist2));
    }

    //n2's level was not found as n1 was its ancestor
    if (dist2 == -1) {
      //n1 is the ancestor, so we find each of their level
      int n2Level = tree.findLevel(root, n2, 1);
      System.out.println("Distance between the nodes is " + (n2Level - dist1));
    }
  }
}