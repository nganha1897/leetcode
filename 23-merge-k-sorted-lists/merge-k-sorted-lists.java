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
    //public ListNode mergeKLists(ListNode[] lists) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // for (int i=0; i<lists.length; i++) {
        //     ListNode cur = lists[i];
        //     while (cur != null) {
        //         pq.add(cur.val);
        //         cur = cur.next;
        //     }
        // }
        // ListNode dummy = new ListNode();
        // ListNode cur = dummy;
        // while (!pq.isEmpty()) {
        //     int val = pq.poll();
        //     cur.next = new ListNode(val);
        //     cur = cur.next;
        // }
        // return dummy.next;
    //}

    public ListNode mergeKLists(ListNode[] lists) {
        int offset = 10000;
        int[] nums = new int[2 * offset + 1];
        for (int i=0; i<lists.length; i++) {
            ListNode cur = lists[i];
            while (cur != null) {
                nums[cur.val + offset]++;
                cur = cur.next;
            }
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        for (int i=0; i<nums.length; i++) {
            while (nums[i] > 0) {
                cur.next = new ListNode(i - offset);
                cur = cur.next;
                nums[i]--;
            }
        }
        return dummy.next;
    }
}