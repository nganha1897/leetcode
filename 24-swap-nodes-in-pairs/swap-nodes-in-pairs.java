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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            ListNode temp = cur.next;
            cur.next = cur.next.next;
            temp.next = cur;
            prev.next = temp;
            // temp.next = cur.next.next;
            // cur.next.next = temp;
            // cur = cur.next.next;
            prev = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
    /*ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        ListNode next;

        while (cur.next != null && cur.next.next != null) {
            ListNode temp = cur.next;
            cur.next = cur.next.next;
            temp.next = cur.next.next;
            cur.next.next = temp;
            cur = cur.next.next;
        }
        return dummy.next;*/
}