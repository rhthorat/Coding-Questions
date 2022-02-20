import java.util.*;

class Main {

  public static Node head;
  int size;

  Main () {
    size = 0;
  }

  public class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public void addFirst(int data) {
    Node newNode = new Node(data);
    newNode.next = head;
    head = newNode;
    size++;

    /* as there are fixed number of operations to be performed to add new node to first of a single link list, so the time complexity is O(1) i.e constant */
  }

  public void addLast(int data) {
    Node newNode = new Node(data);
    
    //if the linked list is empty
    if (head == null) {
      head = newNode;
      size++;
      return;
    }

    //if the linked list is not empty
    Node lastNode = head;
    while (lastNode.next != null) {
      lastNode = lastNode.next;
    }
    lastNode.next = newNode;
    size++;

    /* as to add last in a single linke list you have traverse through the whole linked list , its time complexity becomes O(n), where n is the size of the linked list */
  }

  public void printList() {
    Node currNode = head;

    while (currNode != null) {
      System.out.print(currNode.data + " -> ");
      currNode = currNode.next;
    }

    System.out.println("null");
  }

  public void removeFirst() {
    //if linked list is empty
    if (head == null) {
      System.out.println("The list is empty");
      return;
    }

    // if linked list has one or more elements
    head = head.next;
    size--;
    /* as removing the first node has a fixed set of operations to be performed, the time conplexity is O(1), i.e constant */
  }

  public void removeLast() {

    //if linked list is empty
    if (head == null) {
      System.out.println("The list is empty");
      return;
    }

    //if linked list has only 1 element
    if (head.next == null) {
      head = null;
      size--;
      return;
    }

    //if linked list has elements more than 1
    Node secLastNode = head;
    Node lastNode = head.next;
    while (lastNode.next != null) {
      secLastNode = secLastNode.next;
      lastNode = lastNode.next;
    }
    secLastNode.next = null;
    size--;

    /* As to remove the last we have to traverse from the head till the last node, its time complexity is O(n) */
  }

  public int getElementAtIndex(int index) {
    if (head == null) {
      System.out.println("List is Empty");
    }
    if(index >= size) {
      return -1;
    }
    Node currNode = head;
    int count = 0;
    while (currNode.next != null && count < index) {
      currNode = currNode.next;
      count++;
    }
    return currNode.data;
  }

  public void insertAtIndex(int data, int index) {
    //index of our linked list starts from 0
    Node newNode = new Node(data);

    //if index is 0, so in this case head changes
    if(index == 0) {
      addFirst(data);
      return;
    }

    if(index < 0 || index > size) {
      System.out.println("Invalid index");
      return;
    }
    //if index is grater than 0
    int prevIndex = index - 1;
    int count = 0;
    Node currNode = head;
    while(count < prevIndex) {
      currNode = currNode.next;
      count++;
    }
    newNode.next = currNode.next;
    currNode.next = newNode;
  }
  
  public int getSize() {
    return size;
  }
  public static void main(String[] args) {
    Main SLL = new Main();

    SLL.addLast(2);
    SLL.addFirst(4);
    SLL.removeFirst();
    SLL.printList();
    System.out.println("Size is " + SLL.getSize());

    SLL.addFirst(3);
    SLL.removeFirst();
    SLL.printList();
    System.out.println("Size is " + SLL.getSize());

    SLL.insertAtIndex(8, 1);
    int val = SLL.getElementAtIndex(7);
    if(val < 0) { 
      System.out.println("Element not found at the index");
      }
    System.out.println("Element at index "+ val);
  }
}