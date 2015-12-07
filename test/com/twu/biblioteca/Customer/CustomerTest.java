package com.twu.biblioteca.Customer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for the Customer class.
 *
 * @author Desiree Kelly
 * @version 2.0
 * @see Customer
 */
public class CustomerTest {

    public static final Customer CUSTOMER_1 = new Customer("Joe Bloggs", "joebloggs@joebloggs.com", "0400 000 000", "123-4567", "f8kf93jd");
    public static final Customer CUSTOMER_2 = new Customer("Jane Smith", "janesmith@janesmith.com", "0400 123 888", "123-4568", "5jgfdkl5");

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testGetName() throws Exception {
        assertEquals(CUSTOMER_1.getName(), "Joe Bloggs");
    }

    @Test
    public void testGetEmailAddress() throws Exception {
        assertEquals(CUSTOMER_1.getEmailAddress(), "joebloggs@joebloggs.com");
    }

    @Test
    public void testGetPhoneNumber() throws Exception {
        assertEquals(CUSTOMER_1.getPhoneNumber(), "0400 000 000");
    }

    @Test
    public void testGetLibraryNumber() throws Exception {
        assertEquals(CUSTOMER_1.getLibraryNumber(), "123-4567");
    }

    @Test
    public void testGetPassword() throws Exception {
        assertEquals(CUSTOMER_1.getPassword(), "f8kf93jd");
    }

    @Test
    public void testToString() throws Exception {
        assertEquals(CUSTOMER_1.toString(), "Joe Bloggs, joebloggs@joebloggs.com, 0400 000 000, 123-4567, f8kf93jd");
    }

    @Test
    public void testIfTwoMoviesAreTheSame() throws Exception {
        assertFalse(CUSTOMER_1.equals("Joe Bloggs, joebloggs@joebloggs.com, 0400 000 000, 123-4567, f8kf93jd"));
        assertTrue(CUSTOMER_1.equals(CUSTOMER_1));
        assertFalse(CUSTOMER_1.equals(CUSTOMER_2));
    }
}