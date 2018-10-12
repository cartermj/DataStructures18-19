import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** 
 * A test class for StringUtilities
 * @author Michael C
 * @version 9/14/18
 */
public class StringUtilitiesTest {
    
    private StringUtilities default1;
    private StringUtilities default2;
    private StringUtilities default3;
    private StringUtilities default4;
    private StringUtilities default5;
    private StringUtilities default6;
    private StringUtilities default7;
    
    /** 
     * Sets up the test class
     */
    @Before
    public void setUp()
    {
        default1 = new StringUtilities();
        default2 = new StringUtilities("Hello, World!");
        default3 = new StringUtilities("HELLO, WORLD!");
        default4 = new StringUtilities("hello, world!");
        default5 = new StringUtilities("12345");
        default6 = new StringUtilities("test");
        default7 = new StringUtilities("425.245.542");
    }
    
    /** 
     * Resets the class for further use
     */
    @After
    public void tearDown()
    {
        default1 = null;
        default2 = null;        
    }
    
    /** 
     * Tests the reverse method with giving a null
     */
    @Test(expected = NullPointerException.class)
    public void testReverseWithNull()
    {
        assertNull(default1.toString());
        default1.reverse();
    }
    
    /** 
     * Tests reverse method with giving a single char
     */
    @Test
    public void testReverseWithSingleChar()
    {
        StringUtilities s = new StringUtilities( "z" );
        assertEquals( "z", s.reverse() );
        
    }
    
    /** 
     * Tests reverse method with giving two of the same char
     */
    @Test
    public void testReverseWithDoubleSameChar()
    {
        StringUtilities s = new StringUtilities( "zz" );
        assertEquals( "zz", s.reverse() );
        
    }
    
    /** 
     * Tests reverse method with giving two different chars
     */
    @Test
    public void testReverseWithDoubleDifferentChar()
    {
        StringUtilities s = new StringUtilities( "az" );
        assertEquals( "za", s.reverse() );
        
    }
    
    /** 
     * Tests reverse method with random stuff
     */
    @Test
    public void testReverseWithRandomStuff()
    {
        StringUtilities s = new StringUtilities( "yeah ok" );
        assertEquals( "ko haey", s.reverse() );
        
    }
    
    /** 
     * fish
     */
    @Test
    public void testReverseFrom()
    {
        StringUtilities s = new StringUtilities( "yeah ok" );
        assertEquals( "haey", s.reverse(0, 4) );
        
    }
    
    /** 
     * fish
     */
    @Test
    public void testToString()
    {
        StringUtilities s = new StringUtilities( "z" );
        assertEquals( "z", s.toString() );
        
    }
    
    /** 
     * fish
     */
    @Test
    public void testIsAllUpperTrue()
    {
        assertEquals( true , default3.isAllUpper() );
        
    }
    
    /** 
     * fish
     */
    @Test
    public void testIsAllUpperFalse()
    {
        assertEquals( false , default2.isAllUpper() );
        
    }
    
    /** 
     * fish
     */
    @Test
    public void testIsAllLowerTrue()
    {
        assertEquals( true , default4.isAllLower() );
        
    }
    
    /** 
     * fish
     */
    @Test
    public void testIsAllLowerFalse()
    {
        assertEquals( false , default3.isAllLower() );
        
    }
    
    /** 
     * fish
     */
    @Test
    public void testContNumTrue()
    {
        assertEquals( true, default5.containsNumbers() );

    }
    
    /** 
     * fish
     */
    @Test
    public void testContNumFalse()
    {
        assertEquals( false, default2.containsNumbers() );

    }
    
    /** 
     * fish
     */
    @Test
    public void testConsecNum()
    {
        assertEquals( 1, default2.numConsecutiveDuplicates() );
    }
    
    /** 
     * fish
     */
    @Test
    public void testNumMatchesChar()
    {
        assertEquals( 3 , default2.numMatches( 'l' ) );
    }
    
    /** 
     * fish
     */
    @Test
    public void testNumMatchesString()
    {
        assertEquals( 1, default2.numMatches("ll") );
    }
    
    /** 
     * fish
     */
    @Test
    public void testSetString()
    {
        default3.setString(default2.toString());
        assertEquals( default2.toString(), default3.toString()  );
    }
    
    /** 
     * fish
     */
    @Test
    public void testIsNumTrue()
    {
        assertEquals( true, default5.isNumber() );
    }
    
    /** 
     * fish
     */
    @Test
    public void testIsNumFalse()
    {
        assertEquals( false, default3.isNumber() );
    }
    
    /** 
     * fish
     */
    @Test
    public void testIsNumFalsePds()
    {
        assertEquals( false, default7.isNumber() );
    }
    
    /** 
     * fish
     */
    @Test
    public void testAsArray()
    {
        char[] arr = { 't', 'e', 's', 't'};
        assertArrayEquals(arr, default6.asArray());
    }
}