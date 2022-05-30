package client.model;

import client.network.Client;
import shared.transferObj.*;

import java.util.List;

/**
 * Class for moving data across the program according to MVVM
 */
public class LibraryModelManager implements LibraryModel
{
  private Client client;

  public LibraryModelManager(Client client)
  {
    this.client = client;
    this.client.startClient();
  }

  /**
   * Returns a User object which is read from the database
   *
   * @param email Client email
   * @return User
   */
  @Override
  public User readUserRegister(String email)
  {
    return client.readUserRegister(email);
  }

  /**
   * Creates a new Customer in the database
   *
   * @param customer Customer
   */
  @Override
  public void newCustomer(Customer customer)
  {
    client.newCustomer(customer);
  }

  /**
   * Returns a User object from the database with the specified Login/password
   *
   * @param email User email
   * @param password User password
   * @return User
   */
  @Override
  public User readUserLogin(String email, String password)
  {
    return client.readUserLogin(email, password);
  }

  /**
   * Returns all the rented products of a customer
   *
   * @param customer_email Customer Email
   * @param product Customer product
   * @return List
   */
  @Override
  public List<Rent> readCustomerRents(String customer_email, String product)
  {
    return client.readCustomerRents(customer_email, product);
  }

  /**
   * Returns all rented products
   *
   * @param product Rented product
   * @return List
   */
  @Override public List<Rent> readRents(String product)
  {
    return client.readRents(product);
  }

  /**
   * Removes a rented product from the specified customer
   *
   * @param rent Rent
   * @param product product
   */
  @Override public void removeRent(Rent rent, String product)
  {
    client.removeRent(rent, product);
  }

  /**
   * Updates the amount in stock of a product
   *
   * @param tableName database table name
   * @param productHash hash of product
   */
  @Override public void updateProductAmount(String tableName, String productHash)
  {
    client.updateProductAmount(tableName, productHash);
  }

  /**
   * Rent a product
   *
   * @param product product
   * @param rent rent
   */
  @Override
  public void rentProduct(String product, Rent rent)
  {
    client.rentProduct(product, rent);
  }

  /**
   * Return a list of Objects from a specified database tableName
   *
   * @param tableName database table name
   * @return List
   */
  @Override public List<Object> read(String tableName)
  {
    return client.read(tableName);
  }

  /**
   * Return a list of type Book from the database
   *
   * @return List
   */
  @Override public List<Book> readBooks()
  {
    return client.readBooks();
  }

  /**
   * Return a list of type Movie from the database
   *
   * @return List
   */
  @Override public List<Movie> readMovies()
  {
    return client.readMovies();
  }

  /**
   * Return a list of type CD from the database
   *
   * @return List
   */
  @Override public List<CD> readCDS()
  {
    return client.readCDS();
  }

  /**
   * Return a list of type Software from the database
   *
   * @return List
   */
  @Override public List<Software> readSoftwares()
  {
    return client.readSoftwares();
  }

  /**
   * Return a list of type Book when searched by title
   *
   * @param searchString title of a book
   * @return List
   */
  @Override public List<Book> readBooksByTitle(String searchString)
  {
    return client.readBooksByTitle(searchString);
  }

  /**
   * Return a list of type Movie when searched by title
   *
   * @param searchString title of movie
   * @return List
   */
  @Override public List<Movie> readMoviesByTitle(String searchString)
  {
    return client.readMoviesByTitle(searchString);
  }

  /**
   * Return a list of type CD when searched by name
   *
   * @param searchString name of CD
   * @return List
   */
  @Override public List<CD> readCDsByName(String searchString)
  {
    return client.readCDsByName(searchString);
  }

  /**
   * Return a list of type Software when searched by name
   *
   * @param searchString name of Software
   * @return List
   */
  @Override public List<Software> readSoftwaresByName(String searchString)
  {
    return client.readSoftwaresByName(searchString);
  }

  /**
   * Return a book Object when searched by title
   *
   * @param searchString title of Book
   * @return Book
   */
  @Override public Book readBookByTitle(String searchString)
  {
    return client.readBookByTitle(searchString);
  }

  /**
   * Return a movie Object when searched by title
   *
   * @param searchString movie title
   * @return Movie
   */
  @Override public Movie readMovieByTitle(String searchString)
  {
    return client.readMovieByTitle(searchString);
  }

  /**
   * Return a CD Object when searched by name
   *
   * @param searchString cd name
   * @return CD
   */
  @Override public CD readCDByName(String searchString)
  {
    return client.readCDByName(searchString);
  }

  /**
   * Return a Software Object when searched by name
   *
   * @param searchString name of Software
   * @return Software
   */
  @Override public Software readSoftwareByName(String searchString)
  {
    return client.readSoftwareByName(searchString);
  }

  /**
   * Update a product by specified whereClause
   *
   * @param tableName name of table
   * @param whereClause title/hash
   * @param obj Object to update
   */
  @Override public void update(String tableName, String whereClause, Object obj)
  {
    client.update(tableName, whereClause, obj);
  }

  /**
   * Delete a product by hash
   *
   * @param tableName name of table
   * @param product_hash hash of product
   */
  @Override public void delete(String tableName, String product_hash)
  {
    client.delete(tableName, product_hash);
  }

  /**
   * Insert an object into specified db table
   *
   * @param tableName name of table
   * @param obj Object
   */
  @Override public void insert(String tableName, Object obj)
  {
    client.insert(tableName, obj);
  }

  /**
   * Returns a Customer by email
   *
   * @param email email of customer
   * @return Customer
   */
  @Override public Customer readCustomerInfo(String email)
  {
    return client.readCustomerInfo(email);
  }

  /**
   * Edit Customer Information
   *
   * @param email Customer email
   * @param f_name Customer first name
   * @param l_name Customer last name
   * @param phone Customer phone
   */
  @Override public void changeCustomerInfo(String email,String f_name, String l_name, String phone)
  {
    client.changeCustomerInfo(email, f_name, l_name, phone);
  }

  /**
   * Bind review to product
   *
   * @param product Product
   * @param review Review
   */
  @Override public void addReview(String product, Review review)
  {
    client.addReview(product, review);
  }

  /**
   * Return a list of all reviews for a product
   *
   * @param product product
   * @return List
   */
  @Override public List<Review> readReview(String product)
  {
    return client.readReview(product);
  }

  /**
   * Return a list of Reviews of specified product
   *
   * @param searchString Product name
   * @param product Product
   * @return List
   */
  @Override public List<Review> readReviewsByProductName(String searchString,
      String product)
  {
    return client.readReviewsByProductName(searchString, product);
  }

  /**
   * Remove a review from a product
   *
   * @param review Review
   * @param product Product
   */
  @Override public void removeReview(Review review, String product)
  {
    client.removeReview(review, product);
  }

  /**
   * Return a product by hash
   *
   * @param table DB table name
   * @param productHash Product Hash
   * @return Object
   */
  @Override public Object readProductByHash(String table, String productHash)
  {
    return client.readProductByHash(table, productHash);
  }

  /**
   * Getter for client email
   *
   * @return String
   */
  @Override
  public String getEmail()
  {
    return client.getEmail();
  }
}
