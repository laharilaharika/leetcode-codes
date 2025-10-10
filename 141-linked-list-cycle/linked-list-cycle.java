/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
       int marker = 100001;
        while (head != null) {
            if (head.val == marker) return true;
            head.val = marker;
            head = head.next;
        }
        return false; 
    }
}