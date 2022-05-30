import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shared.transferObj.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests
{

    static final String firstName = "firstName";
    static final String lastName = "lastName";
    static final String email = "email@test.com";
    static final String phoneNr = "52798664";
    static final String pass = "password";
    java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());


    Customer customer;
    Review review;
    Book book;

    @BeforeEach public void setUp()
    {
        customer = new Customer(email, firstName, lastName, phoneNr, pass,
            "customer");
        book = new Book("1","bookTest", "authorTest", 123, "genreTest", 2022, 10);
        review = new Review(customer.getE_mail(), book.getHash(), book.getTitle(), currentDate, "Test Review");
    }

    // -----------------------
    //    User methods
    // -----------------------

    @Test public void getEmail()
    {
        assertEquals("email@test.com", customer.getE_mail());
    }

    @Test public void checkNullEmail()
    {
        customer = new Customer(null, firstName, lastName, phoneNr, pass,
            "customer");

        assertEquals(null, customer.getE_mail());
    }

    @Test() public void checkEmailBlank()
    {
        Customer c = new Customer("", firstName, lastName, phoneNr, pass,
            "customer");

        assertEquals("", c.getE_mail());
    }

    @Test public void getFirstName()
    {
        assertEquals("firstName", customer.getF_name());
    }

    @Test public void checkNullFirstName()
    {
        customer = new Customer(email, null, lastName, phoneNr, pass, "customer");

        assertEquals(null, customer.getF_name());
    }

    @Test() public void checkFirstNameBlank()
    {
        Customer c = new Customer(email, "", lastName, phoneNr, pass, "customer");

        assertEquals("", c.getF_name());
    }

    @Test public void getLasName()
    {
        assertEquals("lastName", customer.getL_name());
    }

    @Test public void checkNullLastName()
    {
        customer = new Customer(email, firstName, null, phoneNr, pass, "customer");

        assertEquals(null, customer.getL_name());
    }

    @Test() public void checkLastNameBlank()
    {
        Customer c = new Customer(email, firstName, "", phoneNr, pass, "customer");

        assertEquals("", c.getL_name());
    }

    @Test public void getPhoneNumber()
    {
        assertEquals("52798664", customer.getPhone());
    }

    @Test public void checkNullPhoneNumber()
    {
        customer = new Customer(email, firstName, lastName, null, pass, "customer");

        assertEquals(null, customer.getPhone());
    }

    @Test() public void checkPhoneNumberBlank()
    {
        Customer c = new Customer(email, firstName, lastName, "", pass, "customer");

        assertEquals("", c.getPhone());
    }

    @Test public void getPassword()
    {
        assertEquals("password", customer.getPassword());
    }

    @Test public void checkNullPassword()
    {
        customer = new Customer(email, firstName, lastName, phoneNr, null, "customer");

        assertEquals(null, customer.getPassword());
    }

    @Test() public void checkPasswordBlank()
    {
        Customer c = new Customer(email, firstName, lastName, phoneNr, "", "customer");

        assertEquals("", c.getPassword());
    }


    // -----------------------
    //   Review
    // -----------------------


    @Test public void getCustomerEmailReview(){
        assertEquals("email@test.com", review.getCustomer_email());
    }

    @Test public void checkSetNewReview(){
        review.setReview("TestNewReview");
        assertEquals("TestNewReview", review.getReview());
    }





}
