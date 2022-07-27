package lists;

class sllTest {

  @org.junit.jupiter.api.Test
  void reverse() {
    ListNode head1 = sll.build(new int[]{1,2,3,4,5});
    ListNode head2 = sll.build(new int[]{1,3});

    sll.print(head2);
    ListNode reversedList = sll.reverse(head2);
    sll.print(reversedList);
  }

  @org.junit.jupiter.api.Test
  void reverseKGroup() {
    ListNode head1 = sll.build(new int[]{1,2,3,4,5});
    sll.print(sll.reverseKGroup(head1, 2));
  }
}