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
    public ListNode partition(ListNode head, int x) {
        ListNode smallDummy = new ListNode(0);
        ListNode bigDummy = new ListNode(0);

        ListNode cur1 = smallDummy;
        ListNode cur2 = bigDummy;
        ListNode cur = head;
        while(cur != null){
            if(cur.val <x){
                cur1.next = cur;
                cur1 = cur1.next;
            }
            else{
                cur2.next = cur;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        cur1.next = bigDummy.next;
        cur2.next = null;
        return smallDummy.next;
    }
}