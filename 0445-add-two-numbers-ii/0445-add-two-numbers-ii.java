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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        while(l1 != null && l1.next != null && l1.val == 0){
            l1 = l1.next;
        }
        while(l2 != null && l2.next != null && l2.val == 0){
            l2 = l2.next;
        }
        l1 = reverse(l1);
        l2 = reverse(l2);
        
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            int sum = carry;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum/10;
            cur.next = new ListNode(sum%10);
            cur = cur.next;
            }
        ListNode result = reverse(dummy.next);
        while(result != null && result.val == 0 && result.next != null){
            result = result.next;
        }
        return result;
    }
    private ListNode reverse(ListNode head){
        ListNode cur = head;
        ListNode prev = null;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}