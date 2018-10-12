import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 
 * A test class for MyArrayList
 * @author MeermaBR and <Michael C>
 * @version 9/27/18
 */
public class MyArrayListTest
{
    private MyArrayList<String> default2;
    private MyArrayList<String> default3;
    private MyArrayList<Integer> default5;
    
    /**
     * no
     */
    @Before
    public void setUp()
    {
        default2 = new MyArrayList<>();
        default2.add("1");
        default2.add("2");
        default2.add("3");
        default2.add("4");
        default3 = new MyArrayList<>();
        default3.add("These");
        default3.add("Are");
        default3.add("Words");
        default5 = new MyArrayList<>();
        default5.add(1);
        default5.add(2);
        default5.add(3);

    }
    
    /**
     * no
     */
    @After
    public void tearDown()
    {
        default2 = null; 
        default3 = null;
    }
    
    /**
     * no
     */
    @Test
    public void testSize() 
    {
        MyArrayList<String> t = new MyArrayList<>(); 
        assertEquals( 0, t.size() );
        t.add("word");
        assertEquals( 1, t.size() );
    }
    
    /**
     * no
     */
    @Test
    public void testEmptyTrue()
    {
        MyArrayList<String> t = new MyArrayList<>();
        assertEquals( true, t.isEmpty() );
    }
    
    /**
     * no
     */
    @Test
    public void testEmptyFalse()
    {
        MyArrayList<String> t = new MyArrayList<>();
        t.add("word");
        assertEquals( false, t.isEmpty() );
    }
    
    /**
     * no
     */
    @Test
    public void testRemove()
    {
        default2.remove(0);
        assertEquals( "2", default2.get(0) );
    }
    
    /**
     * no
     */
    @Test
    public void testIndexOf() 
    {
        assertEquals( 0, default2.indexOf("1") );
    }
    
    /**
     * no
     */
    @Test
    public void testLastIndexOf()
    {
        assertEquals( 3, default2.lastIndexOf("4") );
    }
    
    /**
     * no
     */
    @Test
    public void testRemoveIndex()
    {
        assertEquals("These", default3.remove(0));
    }
    
    /**
     * no
     */
    @Test
    public void testRemoveObject()
    {
        assertTrue( default3.remove( "These" ) );
    }
    
    /**
     * no
     */
    @Test
    public void testAddAll() 
    {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        MyArrayList<Integer> test = new MyArrayList<>( nums );
        assertEquals( "[1, 2, 3]", test.toString() );
    }
    
    /**
     * no
     */
    @Test
    public void testClear() 
    {
        default2.clear();
        assertTrue( default2.isEmpty() );
    }
    
    /**
     * no
     */
    @Test
    public void testLastRemove()
    {
        assertEquals("Words", default3.remove(default3.size() - 1) );
    }
    
    /**
     * no
     */
    @Test
    public void testAdd()
    {
        default5.add( 1 );
        assertEquals( 4, default5.size() );
    }
    
    /**
     * no
     */
    @Test
    public void testAddIndex()
    {
        default5.add( 1, 1 );
        assertEquals( "[1, 1, 2, 3]", default5.toString() );
    }
    
    /**
     * no
     */
    @Test
    public void testContains()
    {
        assertTrue( default3.contains("Are") );
        assertFalse( default3.contains("no") );
    }
    
    /**
     * no
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void failGet()
    {
        assertFalse(default3.isEmpty());
        default3.get(10);
    }
    
    /**
     * no
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void failSet() {
        assertFalse(default5.isEmpty());
        default5.set( 12, 20);
    }

    /**
     *yes
     */
    @Test
    public void testSet() {
        default3.set(1, "a");
        assertEquals("a", default3.get(1) );
    }
    
    /**
     * no
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void failRemove() {
        assertEquals(3, default5.size());
        default5.remove(6);
    }
    
    /**
     * no
     */
    @Test
    public void testRemoveRange()
    {
        default5.removeRange( 1, 2 );
        assertEquals( "[1, 3]", default5.toString() );
    }
    
    /**
     * no
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void failRemoveRange()
    {
        assertEquals( "1", default5.get(0).toString() );
        default5.removeRange( -10, 2 );
    }
    
    /**
     * no
     */
    @Test
    public void testToArray()
    {
        Object[] tester = {"These", "Are", "Words" };
        assertArrayEquals( tester, default3.toArray() );
    }
    
    /**
     * no
     */
    @Test
    public void testTrimToSize()
    {
        MyArrayList<Character> test = new MyArrayList<>(14);
        for ( char c : "Thisisacooltest".toCharArray() )
        {
            test.add(c);
        }
        test.trimToSize();
        assertEquals( 15, test.size() );
    }
    
    /**
     * no
     */
    @Test
    public void testEquals() {
        MyArrayList<Integer> clone;
        clone = new MyArrayList<>(Arrays.asList(1, 2, 3));
        assertTrue(default5.equals(clone));
        assertFalse(default5.equals( default3));
    }

    /**
     * no
     */
    @Test
    public void testToStringEmptyArr() {
        MyArrayList<Object> objects = new MyArrayList<>();
        assertEquals("[]",  objects.toString());
    }


}