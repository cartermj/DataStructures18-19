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
    
//    public void add ( Object o )
//    {
//        if( head == null )
//        {
//            head = new Node ( o );
//        }
//        else
//        {
//            Node temp = head;
//            while ( head.next != null )
//            {
//                
//            }
//        }
//    }
    
    /**
     * Returns the value at the index of index.
     * @param index Gets the value at this index.
     * @return Object Returns what you want
     */
    private Object get( int index )
    {
        Node temp = head;
        if ( index < 0 || index >= size ) 
        {
            throw new IndexOutOfBoundsException();
        }
        
        return 
    }
}
