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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevLeft = dummy;

        for(int i=0;i<left-1;i++){
            prevLeft = prevLeft.next;
        }
        ListNode cur = prevLeft.next; 
        ListNode prev = null;

        for(int i=0;i<=right-left;i++){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next; 
        }
        ListNode leftNode = prevLeft.next;
        prevLeft.next = prev;
        leftNode.next = cur;
        return dummy.next;
    }
}