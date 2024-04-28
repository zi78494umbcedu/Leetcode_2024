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
    private static ListNode findKth(ListNode head, int k){
        k-=1;
        while(head!=null && k>0){
            k--;
            head = head.next;
        }
        return head;
    }
    private static ListNode reverseList(ListNode head){
        if(head==null || head.next==null)return head;
        ListNode newHead = reverseList(head.next);
        ListNode front = head.next;
        front.next= head;
        head.next=null;
        return newHead;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||head.next==null)return head;
        ListNode temp = head;
        ListNode prev = null;
        while(temp!=null){
            ListNode kth = findKth(temp,k);
            if(kth==null){
                if(prev!=null)prev.next = temp;
                break;
            }
            ListNode nextNode = kth.next;
            kth.next=null;
            reverseList(temp);
            if(head==temp){
                head = kth;
            }
            else{
                prev.next = kth;
            }
            prev = temp;
            temp = nextNode;
            
        }
        return head;
    }
}