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
    private static ListNode findMiddle(ListNode head){
        ListNode fast = head, slow=head;
        fast = fast.next.next;
        while(fast!=null && fast.next!=null){
            slow =slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private static ListNode merge(ListNode left, ListNode right){
        if(left==right)return left;
        ListNode dummy = new ListNode(-1) ;
        ListNode temp=dummy;
        while(left!=null && right!=null){
            if(left.val<right.val){
                temp.next=left;
                temp = left;
                left =left.next;
            }else{
                temp.next = right;
                temp =right;
                right = right.next;
            }
        }
        if(left!=null)temp.next= left;
        else temp.next= right;
        return dummy.next;
    }
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)return head;
        ListNode middle = findMiddle(head);
        ListNode leftHead = head;
        ListNode rightHead = middle.next;
        middle.next= null;
        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);
        return merge(leftHead, rightHead);
    }
}