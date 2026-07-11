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
    public ListNode middleNode(ListNode head) {
        //brute-force
        int length = 0;
        ListNode curNode = head;
        while(curNode != null){
            curNode = curNode.next;
            length++;
        }
        int middle = length/2;
        curNode = head;
        for(int i=0;i<middle;i++){
            curNode = curNode.next;
        }
        return curNode;
    }
}