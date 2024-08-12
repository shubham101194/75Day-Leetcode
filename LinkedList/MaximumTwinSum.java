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
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        //ListNode curr = head;
        ListNode nxt = head;
        
        while(head!=null) {
            nxt = head.next;
            head.next = prev;
            prev = head;
            head = nxt;
        }
        return prev;    
    }
    
    public int pairSum(ListNode head) {
        int result = Integer.MIN_VALUE;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode rev = reverse(slow.next);
        slow.next = null;
        
        while(head!=null) {
            result = Math.max(result,head.val+rev.val);
            head = head.next;
            rev = rev.next;
        }
        
        return result;
    }
}