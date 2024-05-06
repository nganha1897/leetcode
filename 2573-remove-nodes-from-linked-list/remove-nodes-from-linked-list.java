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
    public ListNode removeNodes(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> d = new ArrayDeque<>();
        
        while (head != null) {
            while (!d.isEmpty() && d.peekLast().val < head.val) {
                d.pollLast();
            }
            if (d.isEmpty()) {
                dummy.next = head;
            } else {
                d.peekLast().next = head;
            }
            d.offerLast(head);
            head = head.next;
        }
        
        return dummy.next;
    }
}