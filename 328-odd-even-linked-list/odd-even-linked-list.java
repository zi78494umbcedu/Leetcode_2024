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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null)return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even!=null && even.next!=null) {
            odd.next = odd.next.next;
            odd=odd.next;
            even.next= even.next.next;
            even = even.next;
        }
        odd.next= evenHead;
        return head;
        // ArrayList<Integer> arr = new ArrayList<Integer>();
        // ListNode temp = head;
        // //odd
        // while(temp!=null && temp.next!=null){
        //     arr.add(temp.val);
        //     temp = temp.next.next;
        // }
        // //if list is odd length accommodate for the last one missed in the while condition
        // if(temp!=null)arr.add(temp.val);
        // //even
        // temp = head.next;
        // while(temp!=null && temp.next!=null){
        //     arr.add(temp.val);
        //     temp = temp.next.next;
        // }
        // //if list is even length accommodate for the last one missed in the while condition
        // if(temp!=null)arr.add(temp.val);
        // //creating final list
        // int i=0;
        // temp = head;
        // while(temp!=null){
        //     temp.val = arr.get(i);
        //     i++;
        //     temp=temp.next;
        // }   
    }
}