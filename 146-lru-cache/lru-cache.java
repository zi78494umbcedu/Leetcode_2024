import java.util.*;

class LRUCache {
    int capacity;
    //initialising doubly linked list for least recent loggin
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    Map<Integer, Node> map = new HashMap<Integer, Node>();

    //linkin the head and tail for the doubly linked list
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    //get logic
    /*
    *1.if map contains the key - 
    a.get the node
    b.update the recent count by 
    b.1.removing the node 
    b.2 inserting next to head
    c.return node value since get
    d if not present then return -1
    */
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        else{
            return -1;
        }
    }
    
    //put logic
    /*
    if map contains key then
        delete existing node from map and DLL
        insert into map and head.next
    if map does not contain then check capacity
        if capacity full
            delete from map 
            remove tail.prev
            insert map -> head.next
        if capacity not full then insert map -> head.next
    */
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size()==capacity){
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }
    /*
    remove from map
    node.prev.next = node.next
    node.next.prev = node.prev
    */
     void remove(Node node){
        map.remove(node.key);
        node.prev.next= node.next;
        node.next.prev= node.prev;
    }

    /*
    insert in map
    new node
    head.next=node
    node.next=head.next
    head.next.prev = node
    */
     void insert(Node node){
        map.put(node.key, node);
        Node headnext = head.next;
        node.prev = head;
        node.next = headnext;
        head.next = node;
        headnext.prev = node;   
    }

    public class Node{
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */