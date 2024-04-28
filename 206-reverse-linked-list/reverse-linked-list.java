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
    public ListNode reverseList(ListNode head) {
        //recursive Method
        if(head==null || head.next==null)return head;
        
        ListNode newHead = reverseList(head.next);
        ListNode front = head.next;
        front.next= head;
        head.next = null;
        return newHead;
        

        //Iterative Method
        //if(head==null || head.next==null)return head;
        // ListNode temp=head;
        // ListNode prev = null;
        // while(temp!=null){
        //     ListNode front = temp.next;
        //     temp.next = prev;
        //     prev = temp;
        //     temp = front;
        // }
        // return prev;
        //Brute Force Method
        // if(head==null || head.next==null)return head;
        // ArrayList<Integer> arr = new ArrayList<Integer>();
        // ListNode temp = head;
        // while(temp!=null){
        //     arr.add(temp.val);
        //     temp = temp.next;
        // }
        // temp =head;
        // for(int i=arr.size()-1;i>=0;i--){
        //     temp.val = arr.get(i);
        //     temp = temp.next;
        // }
        // return head;
    }
}