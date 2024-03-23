

import javax.xml.stream.events.EndElement;

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
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode end = reverse(slow);
        while (head != null && end != null) {
            ListNode temp = head.next;
            ListNode temp2 = end.next;
            head.next = end;
            end.next = temp;
            head = temp;
            end = temp2;
        }
        if (head != null) {
            head.next = null;
        }
    }
    private ListNode reverse(ListNode head) {
        if (head == null) 
            return null;
        if (head.next == null)
            return head;
       
        ListNode next = head.next;
        head.next = null;
        while (next != null) {
            ListNode temp = next.next;
            next.next = head;
            head = next;
            next = temp;
        }

        return head;
    }
}