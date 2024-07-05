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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] res = new int[] {-1, -1};
        int minD = 100001;
        int maxD = -1;
        int firstCritic = -1;
        int lastCritic = -1;
        int prevCritic = -1;
        ListNode prev = head;
        if (head == null)
            return res;
    
        ListNode curr = head.next;
        if (curr == null)
            return res;
        
        int currIdx = 1;
        while (curr != null && curr.next != null) {
            if ((curr.val > prev.val && curr.val > curr.next.val) || (curr.val < prev.val && curr.val < curr.next.val)) {
                if (prevCritic != -1) {
                    minD = Math.min(minD, currIdx - prevCritic);
                } else {
                    firstCritic = currIdx;
                }
                lastCritic = currIdx;
                prevCritic = currIdx;
            }
            prev = curr;
            curr = curr.next;
            currIdx++;
        }
        if (firstCritic != -1 && lastCritic != -1)
            maxD = lastCritic - firstCritic;
        res[0] = minD < 100001 ? minD : -1;
        res[1] = maxD <= 0 ? -1 : maxD;
        return res;
    }
}