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
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur = head;
        int len = 1;
        while(cur.next != null){
            cur = cur.next;
            len++;
        }
        k = k%len;
        if(k==0){
            return head;
        }
        cur.next = head;
        ListNode newCur = head;
        for(int i=1;i<len-k;i++){
            newCur = newCur.next;
        }
        ListNode newHead = newCur.next;
        newCur.next = null;
        return newHead;
    }
}