package problems;

public class SwapKthNodes {

  private class Solution {
    public ListNode swapNodes(ListNode head, int k)
    {
      if (head == null) {
        return null;
      }

      ListNode first = head;
      for (int i = 1; i < k; i++) {
        first = first.next;
      }

      ListNode second = head;
      ListNode fast = first;
      while (fast.next != null) {
        second = second.next;
        fast = fast.next;
      }

      int tmp = first.val;
      first.val = second.val;
      second.val = tmp;
      return head;
    }
  }
}
