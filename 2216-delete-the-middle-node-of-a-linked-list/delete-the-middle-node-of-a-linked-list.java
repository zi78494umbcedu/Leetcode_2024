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
    public ListNode deleteMiddle(ListNode head) {
        if(head==null || head.next==null)return null;
        ListNode fast = head,slow=head;
        fast = fast.next.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

        }
        slow.next= slow.next.next;
        return head;
        // if(head==null || head.next==null)return null;
        // ListNode temp =head;
        // int len=0;
        // while(temp!=null){
        //     len++;
        //     temp = temp.next;
        // }
        // temp=head;
        // int mid = len/2;
        // while(mid!=1){
        //     mid--;
        //     temp=temp.next;
        // }
        // System.out.println(temp.val);
        // if(temp.next!=null && temp.next.next!=null){
        //     temp.next = temp.next.next;
        // }
        // else if(temp.next!=null && temp.next.next==null){
        //     temp.next=null;
        // }
        // return head;
    }
}