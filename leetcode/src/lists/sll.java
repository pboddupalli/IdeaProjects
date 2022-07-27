package lists;

public class sll {
  static ListNode reverse(ListNode head) {
    ListNode prev = null;
    ListNode current = head;

    while (current != null) {
      ListNode tmp = current.next;
      current.next = prev;
      prev = current;
      current = tmp;
    }
    return prev;
  }

  static ListNode build(int[] elems) {
    if (elems == null || elems.length == 0) {
      return null;
    }
    ListNode head = new ListNode();
    ListNode tail = head;
    for (int num : elems) {
      tail.next = new ListNode(num);
      tail = tail.next;
    }
    return head.next;
  }

  static void print(ListNode head) {
    while (head != null) {
      System.out.printf("%6d", head.val);
      head = head.next;
    }
    System.out.println();
  }

  static ListNode reverseKGroup(ListNode head, int k) {
    ListNode dummy = new ListNode();
    dummy.next = head;

    ListNode thisFirst = head;
    ListNode prev = dummy;
    while (true) {
      ListNode last = thisFirst;
      for (int i = 1; last != null && i < k; i++) {
        last = last.next;
      }
      if (last == null) {
        prev.next = thisFirst;
        break;
      }
      ListNode nextFirst = last.next;
      last.next = null;
      prev.next = reverse(thisFirst);
      prev = thisFirst;
      thisFirst = nextFirst;
    }
    return dummy.next;
  }
}
