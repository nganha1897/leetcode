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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int count = 0;
        ListNode prev = new ListNode(0);
        ListNode next = new ListNode(0);
        ListNode head = list1;
        while (count < b) {
            if (count == a - 1) {
                prev = list1;
            }
            list1 = list1.next;
            count++;
        }
        next = list1.next;
        ListNode list2Head = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        prev.next = list2Head;
        list2.next = next;
        return head;
    }   
}