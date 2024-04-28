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

    private static ListNode reverseList(ListNode head){
        if(head==null|| head.next==null){return head;}
        ListNode newHead = reverseList(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;

    }
    public boolean isPalindrome(ListNode head) {
        //iterative approach O(1) - space complexity using halves of the list and reversing the 2nd half
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow =slow.next;
            fast = fast.next.next;
        }
        ListNode second = reverseList(slow.next);
        ListNode first = head;
        while(second!=null){
            if(first.val!=second.val)return false;
            first=first.next;
            second = second.next;
        }
        head = reverseList(second);
        return true;
        // //brute force method
        // if(head==null|| head.next==null)return true;
        // Stack<Integer> stack = new Stack<Integer>();
        // ListNode temp = head;
        // while(temp!=null){
        //     stack.add(temp.val);
        //     temp= temp.next;
        // }
        // temp=head;
        // while(temp!=null){
        //     int val = stack.peek();
        //     stack.pop();
        //     if(val!=temp.val){
        //         return false;
        //     }
        //     temp = temp.next;
        // }
        // return true;
    }
}