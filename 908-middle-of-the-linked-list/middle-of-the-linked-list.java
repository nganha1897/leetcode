/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode pt1 = new ListNode(head.val, head.next);
        ListNode pt2 = new ListNode(head.val, head.next);
        while (pt2 != null && pt2.next != null) {
            pt1 = pt1.next;
            pt2 = pt2.next.next;
        }
        return pt1;
    }
}