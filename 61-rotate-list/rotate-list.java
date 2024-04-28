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
    private static ListNode findLastNode(ListNode node, int k){
       int cnt =1;
       while(node!=null){
        if(cnt==k){
            return node;
        }
        node =node.next;
        cnt++;
       }
       return node;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head==null  || k==0)return head;
        ListNode temp=head;
        ListNode end=head;
        int len = 1;
        while(end.next!=null){
            len++;
            end=end.next;
        }
        if(k%len==0)return head;
        end.next = head;
        k=k%len;
        ListNode newLastNode = findLastNode(temp, len-k);
        head = newLastNode.next;
        newLastNode.next=null;
        return head;
    }
   
}