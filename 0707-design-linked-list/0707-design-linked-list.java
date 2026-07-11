class MyLinkedList {
  class Node{
    int val;
    Node next;

    Node(int val){
        this.val = val;
        this.next = null;
    }
  }
    Node head;
    int size;

    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }
    public int get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }
        Node cur = head;
        for(int i=0;i<index;i++){
            cur = cur.next;
        }
        return cur.val;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if(head == null){
            head = newNode;
            size++;
            return;
        }
        newNode.next = head;
        head = newNode;
        size++;
    }
    
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if(head == null){
            head = newNode;
            size++;
            return;
        }
        Node curNode = head;
        while(curNode.next != null){
            curNode = curNode.next;
        }
        curNode.next = newNode;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index>size){
            return;
        }
        if(index==0){
            addAtHead(val);
            return;
        }
        Node curNode = head;
        for(int i=0;i<index-1;i++){
            curNode = curNode.next;
        }
        Node newNode = new Node(val);
        newNode.next = curNode.next;
        curNode.next = newNode;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size){
            return;
        }
        if(index==0){
            head = head.next;
            size--;
            return;
        }
        Node curNode = head;
        for(int i=0;i<index-1;i++){
            curNode = curNode.next;
        }
        curNode.next = curNode.next.next;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */