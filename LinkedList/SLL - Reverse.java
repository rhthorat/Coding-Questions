class Main {
    public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { 
       this.val = val; 
       this.next = null;
     }
     ListNode(int val, ListNode next) { 
       this.val = val;     
     this.next = next;
     }
 }
    public static ListNode reverseList(ListNode head) {
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
  public static void main(String[] args) {
    ListNode node = new ListNode(1);
    node.next = new ListNode(4);
    node.next.next = new ListNode(3);
    node.next.next.next = new ListNode(2);
    node.next.next.next.next = new ListNode(7);
    ListNode p = reverseList(node);
    while (p != null) {
      System.out.print(p.val + " -> ");
      p = p.next;
    }
  }
}