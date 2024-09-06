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
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        int n = nums.length;
        boolean[] rem = new boolean[100001];
        for (int num : nums) {
            rem[num] = true;
        }
        while (cur.next != null) {
            if (rem[cur.next.val]) {
                cur.next = cur.next.next;
            } else
                cur = cur.next;
        }
        return dummy.next;
    }
    
    // public ListNode modifiedList(int[] nums, ListNode head) {
    //     int max = 0;
    //     for(int n:nums){
    //         if(n > max){
    //             max = n;
    //         }
    //     }

    //     boolean[] seen = new boolean[max+1];

    //     for(int n:nums){
    //         seen[n] = true;
    //     }
    //     while(head != null && head.val <= max && seen[head.val]){
    //         head = head.next;
    //     }
    //     if(head == null){
    //         return head;
    //     }
    //     ListNode curr = head.next, prev = head;
    //     while(curr != null){
    //         if(curr.val <= max && seen[curr.val]){
    //             prev.next = curr.next;
    //         }else{
    //             prev = curr;
    //         }
    //         curr = curr.next;
    //     }        
    //     return head;
    // }
}