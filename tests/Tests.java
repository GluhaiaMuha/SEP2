import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.database.DatabaseFront;
import server.database.General.ProductInfo.ProductInfoDAOImpl;
import server.database.Librarian.ManageProducts.ManageProductsDAOImpl;
import server.network.RMIServerImpl;
import shared.transferObj.Book;
import shared.transferObj.Customer;
import shared.transferObj.Movie;
import shared.transferObj.Review;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class Tests{

    static final String firstName = "firstName";
    static final String lastName = "lastName";
    static final String email = "email@test.com";
    static final String phoneNr = "52798664";
    static final String pass = "password";
    java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());


    Customer customer;
    Review review;
    Book book;

    @BeforeEach
    public void setUp() {
        customer = new Customer(email, firstName, lastName, phoneNr, pass,
                "customer");
        book = new Book("1", "bookTest", "authorTest", 123, "genreTest", 2022, 10);
        review = new Review(customer.getE_mail(), book.getHash(), book.getTitle(), currentDate, "Test Review");
    }

    @Test
    public void getEmail() {
        assertEquals("email@test.com", customer.getE_mail());
    }

    @Test
    public void checkBlankEmail() {
        customer = new Customer("", firstName, lastName, phoneNr, pass,
                "customer");

        assertEquals("", customer.getE_mail());
    }

    @Test()
    public void checkEmailNull() {
        assertThrows(IllegalArgumentException.class,()->new Customer(null,firstName,lastName,phoneNr,pass, "username") );
    }

    @Test
    public void getFirstName() {
        assertEquals("firstName", customer.getF_name());
    }

    @Test
    public void checkNullFirstName() {
        customer = new Customer(email, null, lastName, phoneNr, pass, "customer");

        assertEquals(null, customer.getF_name());
    }

    @Test()
    public void checkFirstNameBlank() {
        Customer c = new Customer(email, "", lastName, phoneNr, pass, "customer");

        assertEquals("", c.getF_name());
    }

    @Test
    public void getLastName() {
        assertEquals("lastName", customer.getL_name());
    }

    @Test
    public void checkNullLastName() {
        customer = new Customer(email, firstName, null, phoneNr, pass, "customer");

        assertEquals(null, customer.getL_name());
    }

    @Test()
    public void checkLastNameBlank() {
        Customer c = new Customer(email, firstName, "", phoneNr, pass, "customer");

        assertEquals("", c.getL_name());
    }

    @Test
    public void getPhoneNumber() {
        assertEquals("52798664", customer.getPhone());
    }

    @Test
    public void checkNullPhoneNumber() {
        customer = new Customer(email, firstName, lastName, null, pass, "customer");

        assertEquals(null, customer.getPhone());
    }

    @Test()
    public void checkPhoneNumberBlank() {
        Customer c = new Customer(email, firstName, lastName, "", pass, "customer");

        assertEquals("", c.getPhone());
    }

    @Test
    public void getPassword() {
        assertEquals("password", customer.getPassword());
    }

    @Test
    public void checkNullPassword() {
        assertThrows(IllegalArgumentException.class,()->new Customer(email, firstName, lastName, phoneNr, null, "customer"));
    }

    @Test()
    public void checkPasswordBlank() {
        Customer c = new Customer(email, firstName, lastName, phoneNr, "", "customer");

        assertEquals("", c.getPassword());
    }

    @Test
    public void getCustomerEmailReview() {
        assertEquals("email@test.com", review.getCustomer_email());
    }

    @Test
    public void checkSetNewReview() {
        review.setReview("TestNewReview");
        assertEquals("TestNewReview", review.getReview());
    }

    @Test
    public void isDBDriverRegistered() {
        assertNotNull(DatabaseFront.getInstance());
    }

    @Test
    public void doesDatabaseGiveAConnection() throws SQLException {
        assertNotNull(DatabaseFront.getInstance().getConnection());
    }

    @Test
    public void addAMovieToDatabase() throws SQLException {
        Connection connection = DatabaseFront.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO movie" +
                "(hash, title, director, release_year, length, amountInStock) VALUES ('2115','Liberator','Steven Spielberg','1991','98','4');");
        assertFalse(statement.execute());
        PreparedStatement statement2 = connection.prepareStatement("DELETE FROM movie WHERE hash='2115';");
        assertFalse(statement2.execute());
    }

    @Test
    public void getStuffFromDatabase(){
        ManageProductsDAOImpl impl = new ManageProductsDAOImpl();
        impl.insert("movie", new Movie("2115","Liberator","Steven Spielberg",1991,98,4));
        ProductInfoDAOImpl getMovie = new ProductInfoDAOImpl();
        Movie movie = getMovie.readMovieByTitle("Liberator");
        assertNotNull(movie);
        impl.delete("movie","2115");
    }

    @Test
    public void serverInstantiation() throws RemoteException {
        RMIServerImpl server = new RMIServerImpl();
        assertNotNull(server);
    }

}
