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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode p = head;
        if(head==null||head.next==null||k==0){
            return head;
        }
        int l = 1;
        while(p.next!=null){
            p = p.next;
            l++;
        }
        p.next = head;
        k = k%l;
        k = l-k;
        while(k-->0){
            p = p.next;
        }
        head = p.next;
        p.next = null;
        return head;
    }
}