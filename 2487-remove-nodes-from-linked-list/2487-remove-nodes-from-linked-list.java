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
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while(cur!=null){
            while(!stack.isEmpty() && stack.peek().val < cur.val){
                stack.pop();
            }
            stack.push(cur);
            cur = cur.next;
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for(ListNode node : stack){
            tail.next = node;
            tail = tail.next;
        }
        tail.next = null;
        return dummy.next;
    }
}