package sums;

public class AddTwoNumbers {

  public static void main(String[] args) {

  }

  private static class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode retval = l1;
      int carry = 0;
      ListNode prev = null;
      while (l1 != null && l2 != null) {
        l1.val += l2.val + carry;
        if (l1.val > 9) {
          l1.val -= 10;
          carry = 1;
        } else {
          carry = 0;
        }
        if (l1.next == null) {
          l1.next = l2.next;
          l2 = null;
        } else {
          l2 = l2.next;
        }
        prev = l1;
        l1 = l1.next;
      }
      while (l1 != null) {
        l1.val += carry;
        if (l1.val > 9) {
          l1.val -= 10;
          carry = 1;
        } else {
          carry = 0;
        }
        prev = l1;
        l1 = l1.next;
      }
      if (carry != 0) {
        prev.next = new ListNode(carry);
      }
      return retval;
    }
  }
}
