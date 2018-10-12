import java.util.Collection;

/** 
 * A class that creates and 
 * @author Michael Carter
 * @version 2018-10-02
 * @param <E> The type of Object this class is taking in
 */
public class MyArrayList<E> {
    private int size;
    private Object[] values;
    
    /**
     * Creates a new ArrayList that starts with
     * an initial capacity of 10
     */
    public MyArrayList()
    {
        size = 0;
        values = new Object[10];
    }
    
    /**
     * Creates a new ArrayList that starts with
     * the given initialCapacity
     * @param initialCapacity The capacity of the ArrayList
     */
    public MyArrayList( int initialCapacity )
    {
        size = 0;
        values = new Object[initialCapacity];
    }
    
    /**
     * Creates a new ArrayList filled with the given Collection 
     * @param c The Collection that will go into the new ArrayList
     */
    public MyArrayList( Collection<E> c )
    {
        this( c.size() );
        addAll( c );
    }
    
    /**
     * Adds the given Object to the end of the ArrayList
     * @param obj The Object added to the ArrayList
     * @return boolean Whether obj was successfully added.
     */
    public boolean add( E obj )
    {
        size++;
        if ( size > values.length ) 
        {
            ensureCapacity(size * 2 );
        }
        values[size - 1] = obj;
        return true;
    }
    
    /**
     * Adds the given Object at the given index
     * @param index The index where obj is added.
     * @param obj The Object to be added.
     */
    public void add( int index, E obj )
    {
        if ( index > size || index < 0 )
        {
            throw new IndexOutOfBoundsException();
        }
        if ( index == size )
        {
            add( obj );
        }
        else 
        {
            size++;
            if ( size > values.length )
            {
                ensureCapacity(size * 2 );
            }
            for ( int i = size - 2; i >= index; i-- )
            {
                values[i + 1]  = values[i];
            }
            values[index] = obj;
        }
    }
    
    /**
     * Adds all in the given collection to the ArrayList
     * @param c Adds this collection to the ArrayList.
     */
    public void addAll( Collection<E> c )
    {
        ensureCapacity(c.size());
        for ( E o : c ) 
        {
            add( o );
        }
    }
    
    /**
     * Returns the value at the index of index.
     * @param index Gets the value at this index.
     * @return E Returns what you want
     */
    public E get( int index )
    {
        if ( index < 0 || index >= size ) 
        {
            throw new IndexOutOfBoundsException();
        }
        else 
        {
            E get = (E) values[index];
            return get;
        }
    }
    
    /**
     * Ensures the length of the ArrayList is equal to
     * minCapacity; if not, it increases the length of the
     * ArrayList to minCapacity.
     * @param minCapacity Ensures the ArrayList is as big as this capacity.
     */
    public void ensureCapacity( int minCapacity )
    {
        if ( minCapacity < 0 )
        {
            minCapacity = Integer.MAX_VALUE;
        }
        if ( minCapacity > values.length )
        {
            Object [] nValues = new Object[minCapacity];
            for (int i = 0; i < values.length; i++)
            {
                nValues[i] = values[i];
            }
            values = nValues;
        }
    }
    
    /**
     * Returns the size of the ArrayList.
     * @return int The size
     */
    public int size()
    {
        return size;
    }
    
    /**
     * Checks whether the ArrayList is empty.
     * @return boolean Whether it's empty.
     */
    public boolean isEmpty()
    {
        return size <= 0;
    }
    
    /**
     * Removes the Object at the given index
     * and returns the removed Object.
     * @param index Removes the Object at this index.
     * @throws IndexOutOfBoundsException if the index is not inside the
     * current list.
     * @return The Object removed.
     */
    public E remove(int index)
    {
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException();
        }
        E old = (E)values[index];
        if (index == size - 1 ) 
        {
            values[size - 1] = null;
            size--;
            return old;
        }
        else
        {
            for ( int i = index; i < size - 1; i++ )
            {
                values[i] = values[i + 1];
            }
            values[size - 1] = null;
            size--;
            return old;
        }
    }
    
    /**
     * Removes the given Object and returns
     * whether the remove was successful.
     * @param obj The object removed.
     * @return boolean Whether it was removed.
     */
    public boolean remove(Object obj)
    {
        for ( int i = 0; i < size; i++ )
        {
            if ( values[i].equals(obj))
            {
                remove(i);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Clears the ArrayList.
     */
    public void clear()
    {
        for (int i = 0; i < size; i++ )
        {
            values[i] = null; 
        }
        size = 0;
    }
    
    /**
     * Returns the first index of a given Object.
     * @return int The integer index of.
     * @param obj the Object looked for.
     */
    public int indexOf(Object obj)
    {
        for ( int i = 0; i < size; i++ )
        {
            if ( values[i].equals(obj) )
            {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Returns the location of the last
     * instance of a given Object.
     * @return int The location of obj.
     * @param obj The object looked for.
     */
    public int lastIndexOf( Object obj )
    {
        for ( int i = size - 1; i >= 0; i-- )
        {
            if ( values[i].equals(obj) )
            {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Checks whether the ArrayList contains
     * a given object.
     * @param obj Checks if the ArrayList contains this object.
     * @return boolean Whether it contains it or not.
     */
    public boolean contains( Object obj )
    {
        for ( int i = 0; i < size; i++ )
        {
            if ( values[i].equals(obj) )
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Gets rid of empty spaces in the ArrayList.
     */
    public void trimToSize()
    {
        
        values = toArray();
    }
    
    /**
     * Returns the elements in the
     * ArrayList as an array.
     * @return Object[] The array.
     */
    public Object [] toArray()
    {
        Object [] nValues = new Object[size];
        for ( int i = 0; i < size; i++ )
        {
            nValues[i] = values[i];
        }
        return nValues;
    }
    
    /**
     * Returns the ArrayList as a String, with the
     * Objects listed in brackets.
     * @return String The String form.
     */
    public String toString()
    {
        if ( size == 0 )
        {
            return "[]";
        }
        StringBuilder s = new StringBuilder("]");
        for ( int i = 0; i < size - 1; i++ )
        {
            s.insert( s.length( ) - 1, values[i] + ", "  );
        }
        s.insert(s.length() - 1, values[size - 1]);
        s.insert(0, "[");
        return s.toString();      
    }
    
    /**
     * Returns whether it's equal
     * @return boolean Whether they're equal
     * @param o The Object taken in.
     */
    public boolean equals( Object o )
    {
        if ( o == this )
        {
            return true;
        }
        if ( ! (o instanceof MyArrayList ) )
        {
            return false;
        }
        
        MyArrayList other = (MyArrayList)o;

        if ( size() == other.size() )
        {
            for ( int i = 0; i < size; i++ )
            {
                if ( values[i] != other.values[i] )
                {
                    return false;
                }
            }
        }
        return true;
    
    }
    
    /**
     * Removes this range from the ArrayList
     * @param fromIndex Starting point.
     * @param toIndex Ending point. 
     */
    public void removeRange( int fromIndex, int toIndex )
    {
        int range = toIndex - fromIndex;
        while ( range > 0 )
        {
            remove( fromIndex );
            range--;
        }
    }
    
    /**
     * Sets a new thing to the thing.
     * @return E Returns E.
     * @param index The index of.
     * @param obj The Object set.
     */
    public E set( int index, E obj )
    {
        if ( index < 0 || index >= size )
        {
            throw new IndexOutOfBoundsException();
        }
        E old = (E) values[index];
        values[index] = obj;
        return old;
    }

}
