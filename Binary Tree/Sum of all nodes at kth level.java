import java.util.*;
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
    
    //get sum of all nodes at kth level Of Tree
    public int getSumofKthLevelNode(Node root, int k) {
      if (root == null) {
        return 0;
      }
      Queue<Node> queue = new LinkedList<Node>();
      queue.add(root);
      queue.add(null);
      int i = 1;
      int sum = 0;
      while (!queue.isEmpty() && i < k) {
        i++;
        Node node = queue.poll();
        while (node != null) {
          if (node.left != null) {
            queue.add(node.left);
          }
          if (node.right != null) {
            queue.add(node.right);
          }
          
          node = queue.poll();
        }
        queue.add(null);
      }
      
      while (!queue.isEmpty()) {
        int data = 0;
        Node node = queue.poll();
        if (node != null) {
          data = node.data;
        }
        
        sum += data;
      }
      return sum;
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
    int[] preorderedNodes = {1,2,5,10,11,-1,-1,12,-1,-1,-1,4,-1,-1,3,6,-1,-1,7,-1,15,13,-1,-1,14,-1,-1};

    //int[] preorderedNodes = {10,6,4,3,-1,-1,5,-1,-1,8,7,-1,-1,9,-1,-1,15,-1,20,-1,-1};
    
    BinaryTree tree = new BinaryTree();
    Node root = tree.buildTree(preorderedNodes);
    int sum = tree.getSumofKthLevelNode(root, 5);
    //tree.inorderTraversal(root);

    System.out.println("Sum of all nodes at kth level is " + sum);
  }
}