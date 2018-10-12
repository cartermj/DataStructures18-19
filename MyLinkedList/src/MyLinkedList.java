/**
 * Nederlands
 * @author Michael Carter
 * @version 2018-10-03
 */
public class MyLinkedList 
{
    private int size;
    private Node head;
    {
        size = 0;
    }
    
    public MyLinkedList()
    {
        size = 0;
        head = null;
    }
    
    class Node
    {
        private Object data;
        private Node next;
        
        public Node( Object data, Node next )
        {
            this.data = data;
            this.next = next;
        }
        
        public Node( Object data )
        {
            this( data, null );
        }
    }
}
