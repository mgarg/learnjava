public class stackLinkedList {
    node head;
    public class node{
        String val;
        node next;
    }
    void push(String v)
    {
        node item = new node();
        item.val = v;
        item.next = head;
        head = item;
    }
    String pop()
    {
        String item = head.val;
        head = head.next;
        return item;
    }
    boolean isEmpty()
    {
       return (head==null)?true:false;
    }
}
