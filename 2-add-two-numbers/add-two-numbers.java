/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c = 0;
        ListNode dummy = new ListNode(0), cur = dummy;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + c;
            cur.next = new ListNode(val % 10);
            cur = cur.next;
            c = val > 9 ? 1 : 0;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int val = l1.val + c;
            cur.next = new ListNode(val % 10);
            cur = cur.next;
            c = val > 9 ? 1 : 0;
            l1 = l1.next;
        }
        while (l2 != null) {
            int val = l2.val + c;
            cur.next = new ListNode(val % 10);
            cur = cur.next;
            c = val > 9 ? 1 : 0;
            l2 = l2.next;
        }
        if (c == 1) {
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }
}