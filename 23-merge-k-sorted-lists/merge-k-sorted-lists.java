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

    // public ListNode mergeKLists(ListNode[] lists) {
    //     int offset = 10000;
    //     int[] nums = new int[2 * offset + 1];
    //     for (int i=0; i<lists.length; i++) {
    //         ListNode cur = lists[i];
    //         while (cur != null) {
    //             nums[cur.val + offset]++;
    //             cur = cur.next;
    //         }
    //     }
    //     ListNode dummy = new ListNode();
    //     ListNode cur = dummy;
    //     for (int i=0; i<nums.length; i++) {
    //         while (nums[i] > 0) {
    //             cur.next = new ListNode(i - offset);
    //             cur = cur.next;
    //             nums[i]--;
    //         }
    //     }
    //     return dummy.next;
    // }

    // public ListNode mergeKLists(ListNode[] lists) {
    //     PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
    //     for (int i=0; i<lists.length; i++) {
    //         ListNode cur = lists[i];
    //         if (cur != null) {
    //             pq.add(cur);
    //         }
    //     }

    //     ListNode dummy = new ListNode();
    //     ListNode cur = dummy;
    //     while (!pq.isEmpty()) {
    //         cur.next = pq.poll();
    //         cur = cur.next;
    //         if (cur.next != null) {
    //             pq.add(cur.next);
    //         }
    //     }
    //     return dummy.next;
    // }

    public ListNode mergeKLists(ListNode[] lists) {
        int size = lists.length;
        int interval = 1;
        while (interval < size) {
            for (int i=0; i+interval<size; i+=interval*2) {
                lists[i] = merge(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return size > 0 ? lists[0] : null;
    }

    public ListNode merge(ListNode a, ListNode b) {
        ListNode head = new ListNode();
        ListNode cur = head;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }

        if (a != null) {
            cur.next = a;
        } else {
            cur.next = b;
        }

        return head.next;
    }
}