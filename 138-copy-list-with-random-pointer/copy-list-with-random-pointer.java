/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        //Insert Copy Nodes in between
        Node temp= head;
        while(temp!=null){
            Node copyNode = new Node(temp.val);
            copyNode.next = temp.next;
            temp.next=copyNode;
            temp = temp.next.next;
        }
        //Connect Random Pointers
        temp=head;
        while(temp!=null){
            Node copyNode = temp.next;
            if(temp.random!=null){
                copyNode.random = temp.random.next;
            }
            temp = temp.next.next;
        }
        //Connect Next Pointers (Clone and connect back the originals)
        Node dummy = new Node(-1);
        Node res = dummy;
        temp = head;
        while(temp!=null){
            res.next = temp.next;
            temp.next = temp.next.next;
            res = res.next;
            temp = temp.next;
        }
        return dummy.next;
     

        //brute
        // Node temp = head;
        // HashMap<Node, Node> map = new HashMap<Node, Node>();
        // while(temp!=null){
        //     map.put(temp, new Node(temp.val));
        //     temp = temp.next;
        // }
        // temp=head;
        // while(temp!=null){
        //     Node copyNode = map.get(temp);
        //     copyNode.next = map.get(temp.next); 
        //     copyNode.random = map.get(temp.random);
        //     temp = temp.next;
        // }
        // return map.get(head);
    }
}