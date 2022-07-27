package problems;

public class SwapPairs {

  private class Solution
  {
    public ListNode swapPairs(ListNode head)
    {
      ListNode current = new ListNode();
      current.next = head;
      head = current;

      while (current.next != null && current.next.next != null)
      {
        ListNode tmp = current.next.next; // points to the second element
        current.next.next = tmp.next;
        tmp.next = current.next;
        current.next = tmp;
        current = current.next.next;
      }
      return head.next;
    }
  }
}


