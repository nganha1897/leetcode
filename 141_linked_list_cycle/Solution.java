/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
  public boolean hasCycle(ListNode head) {
      ListNode pt1 = new ListNode(0);
      ListNode pt2 = new ListNode(1);
      pt1.next = head;
      pt2.next = head;
      while (pt2.next != null && pt2.next.next != null) {
          pt1 = pt1.next;
          pt2 = pt2.next.next;
          if (pt1 == pt2) {
              return true;
          }
      }
      return false;
  }
}