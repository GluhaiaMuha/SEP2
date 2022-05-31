import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.database.Customer.CustomerInfo.CustomerInfoDAOImpl;
import server.database.DatabaseFront;
import server.database.General.Login.LoginDAOImpl;
import server.database.General.ProductInfo.ProductInfoDAOImpl;
import server.database.General.Register.RegisterDAO;
import server.database.General.Register.RegisterDAOImpl;
import server.database.Librarian.ManageProducts.ManageProductsDAOImpl;
import server.network.RMIServerImpl;
import shared.transferObj.*;

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

    User user;
    Customer customer;
    Review review;
    Book book;

    @BeforeEach
    public void setUp() {
        user = new User("test@test.test", "test", "customer");
        customer = new Customer(email, firstName, lastName, phoneNr, pass, "customer");
        book = new Book("1", "bookTest", "authorTest", 123, "genreTest", 2022, 10);
        review = new Review(customer.getE_mail(), book.getHash(), book.getTitle(), currentDate, "Test Review");
    }

    @Test
    public void getEmail() {
        assertEquals("email@test.com", customer.getE_mail());
    }

    @Test
    public void checkBlankEmail() {
        assertThrows(IllegalArgumentException.class,
            ()->new Customer("",firstName,lastName,phoneNr,pass, "username") );
    }

    @Test()
    public void checkEmailNull() {
        assertThrows(IllegalArgumentException.class,
            ()->new Customer(null,firstName,lastName,phoneNr,pass, "username") );
    }

    @Test
    public void getFirstName() {
        assertEquals("firstName", customer.getF_name());
    }

    @Test
    public void checkNullFirstName() {
        assertThrows(IllegalArgumentException.class,
            ()->new Customer(email,null,lastName,phoneNr,pass, "username") );
    }

    @Test()
    public void checkFirstNameBlank() {
        assertThrows(IllegalArgumentException.class,
            ()->new Customer(email,"",lastName,phoneNr,pass, "username") );
    }

    @Test
    public void getLastName() {
        assertEquals("lastName", customer.getL_name());
    }

    @Test
    public void checkNullLastName() {
        assertThrows(IllegalArgumentException.class,
            ()->new Customer(email,firstName,null,phoneNr,pass, "username"));
    }

    @Test()
    public void checkLastNameBlank() {
        assertThrows(IllegalArgumentException.class,
            ()->new Customer(email,firstName,"",phoneNr,pass, "username"));
    }

    @Test
    public void getPhoneNumber() {
        assertEquals("52798664", customer.getPhone());
    }

    @Test
    public void checkNullPhoneNumber() {
        assertThrows(IllegalArgumentException.class,
            ()->new Customer(email,firstName,lastName,null,pass, "username"));
    }

    @Test()
    public void checkPhoneNumberBlank() {
        assertThrows(IllegalArgumentException.class,
            ()->new Customer(email,firstName,lastName,"",pass, "username"));
    }

    @Test
    public void getPassword() {
        assertEquals("password", customer.getPassword());
    }

    @Test
    public void checkNullPassword() {
        assertThrows(IllegalArgumentException.class,
            ()->new Customer(email, firstName, lastName, phoneNr, null, "customer"));
    }

    @Test()
    public void checkPasswordBlank() {
        assertThrows(IllegalArgumentException.class,
            ()->new Customer(email,firstName,lastName,phoneNr,"", "username"));
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
    public void registerCustomer() throws SQLException{
        RegisterDAOImpl impl = new RegisterDAOImpl();
        LoginDAOImpl logInDao  = new LoginDAOImpl();
        impl.insertUserRegister(customer);

        //Get the user
        User u1 = logInDao.readUserLogin(customer.getE_mail(), customer.getPassword());

        assertTrue(u1.getPassword().equals(customer.getPassword()) &&
            u1.getE_mail().equals(customer.getE_mail()));

        //Delete for no errors later
        Connection connection = DatabaseFront.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM customer WHERE email='email@test.com' ");
        PreparedStatement statement2 = connection.prepareStatement("DELETE FROM users WHERE email='email@test.com' ");
        statement.execute();
        statement2.execute();

    }

    @Test
    public void changeCustomerInfoDAO() throws SQLException{
        RegisterDAOImpl impl = new RegisterDAOImpl();
        CustomerInfoDAOImpl impl2 = new CustomerInfoDAOImpl();
        impl.insertUserRegister(customer);
        impl2.changeCustomerInfo(customer.getE_mail(), "newTestName", "newLastName", "999999999");

        //Get the user
        Customer c1 = impl2.readCustomerInfo(customer.getE_mail());

        assertTrue(c1.getF_name().equals("newTestName"));

        //Delete for no errors later
        Connection connection = DatabaseFront.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM customer WHERE email='email@test.com' ");
        PreparedStatement statement2 = connection.prepareStatement("DELETE FROM users WHERE email='email@test.com' ");
        statement.execute();
        statement2.execute();
    }

    @Test
    public void getMovieFromDatabase(){
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
