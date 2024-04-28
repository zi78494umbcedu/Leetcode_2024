/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //optimal approach
        if(headA==null || headB==null)return null;
        ListNode tempA = headA;
        ListNode tempB = headB;
        while(tempA!=tempB){
            tempA = tempA.next;
            tempB = tempB.next;
            if(tempA==tempB)return tempA;
            if(tempA==null)tempA=headB;
            if(tempB==null)tempB=headA;
        }
        return tempA;
        // //iterative approach
        // ListNode tempA = headA;
        // ListNode tempB = headB;
        // int cnt1=0, cnt2=0;
        // while(tempA!=null){
        //     cnt1++;
        //     tempA=tempA.next;
        // } 
        //  while(tempB!=null){
        //     cnt2++;
        //     tempB=tempB.next;
        // } 
        // if(cnt1-cnt2>0){
        //     int diff = cnt1-cnt2;
        //     while(diff!=0){
        //         diff--;
        //         tempA = tempA.next;
        //     }
        // }else if(cnt1-cnt2<0){
        //     int diff = cnt2-cnt1;
        //      while(diff!=0){
        //         diff--;
        //         tempB = tempB.next;
        //     }
        // }
        // while(tempA!=null && tempB!=null && tempA!=tempB){
        //     tempA = tempA.next;
        //     tempB = tempB.next;
        // }
        // return tempA;

        //brute force method
        // HashMap<ListNode, Integer> map =new HashMap<ListNode, Integer>();
        // ListNode tempA = headA;
        // ListNode tempB = headB;
        // while(tempA!=null){
        //     map.put(tempA, map.get(tempA)!=null?map.get(tempA)+1:1);
        //     tempA= tempA.next;
        // }
        //  while(tempB!=null){
        //     if(map.get(tempB)!=null){
        //         return tempB;
        //     }
        //     tempB= tempB.next;
        // }
        // return null;
    }
}