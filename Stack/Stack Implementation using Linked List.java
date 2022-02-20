import java.util.*;

class Main {
  //Node class
  private static class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  //stack class
  static class Stack {
    public static Node head;
    public static int size;

    Stack() {
      size = 0;
    }
    
    public static int getSize() {
      return size;
    }
    public static boolean isEmpty() {
      return head == null;
    }
    //push
    public static void push(int data) {
      Node newNode = new Node(data);
      newNode.next = head;
      head = newNode;
      size++;
    }

    public static int pop() {
      if (isEmpty()) {
        return -1;
      }

      int top = head.data;
      head = head.next;
      size--;
      return top;
    }

    public static int peek() {
      if(isEmpty()) {
        return -1;
      }
      return head.data;
    }

    public static void printStack() {
      if (isEmpty()) {
        System.out.println("Stack is is Empty");
        return;
      }

      Node currNode = head;
      while (currNode != null) {
        System.out.print(currNode.data + "  ");
        currNode = currNode.next;
      }
    }
  }
  public static void main(String[] args) {
    Stack stack = new Stack();
    stack.push(5);
    stack.push(1);
    stack.push(3);
    stack.push(6);
    stack.peek();
    stack.printStack();
    System.out.println(stack.pop());
    System.out.println(stack.getSize());
  }
}