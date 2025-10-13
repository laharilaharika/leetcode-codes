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
    public ListNode swapNodes(ListNode head, int k) {
        if(head.next == null){
            return head;
        }
        ListNode temp = head;
        int size = 0;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        if(k > size){
            return head;
        }
        int fromStart = size - k + 1;
        if(fromStart == k) return head;
        ListNode p1 = head;
        ListNode p2 = head;
        while(k > 1){
            p1 = p1.next;
            k--;
        }
        while(fromStart > 1){
            p2 = p2.next;
            fromStart--;
        }
        p1.val = p1.val + p2.val;
        p2.val = p1.val - p2.val;
        p1.val = p1.val - p2.val;
        
        return head;
    }
}