/**
 * Definition for singly-linked list.
*/
 public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 
class Solution {
    public ListNode reverseList(ListNode head) {
        //if input is empty i.e. []
        if (head == null)
            return head;
        
        /*
        //Iterative Solution
      ListNode node = head;   
      ListNode prev = null;  
      while (node != null) {
          ListNode newNode = node.next;
          node.next = prev;
          prev = node;
          node = newNode;
      }
      return prev; 
      
      //Iterative Solution ends here
      */
      
        //Recursive solution
        if (head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
        //Recursive solution ends here
    }
}