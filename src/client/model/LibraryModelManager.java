package client.model;

import client.network.Client;
import shared.transferObj.*;

import java.util.List;

public class LibraryModelManager implements LibraryModel
{
  private Client client;

  public LibraryModelManager(Client client)
  {
    this.client = client;
    this.client.startClient();
  }

  @Override
  public User readUserRegister(String email)
  {
    return client.readUserRegister(email);
  }

  @Override
  public void newCustomer(Customer customer)
  {
    client.newCustomer(customer);
  }

  @Override
  public User readUserLogin(String email, String password)
  {
    return client.readUserLogin(email, password);
  }

  @Override
  public List<Rent> readCustomerRents(String customer_email, String product)
  {
    return client.readCustomerRents(customer_email, product);
  }

  @Override public void removeRent(Rent rent, String product)
  {
    client.removeRent(rent, product);
  }

  @Override public void updateProductAmount(String tableName, String productHash)
  {
    client.updateProductAmount(tableName, productHash);
  }

  @Override
  public void rentProduct(String product, Rent rent)
  {
    client.rentProduct(product, rent);
  }

  @Override public List<Object> read(String tableName)
  {
    return client.read(tableName);
  }

  @Override public List<Book> readBooks()
  {
    return client.readBooks();
  }

  @Override public List<Movie> readMovies()
  {
    return client.readMovies();
  }

  @Override public List<CD> readCDS()
  {
    return client.readCDS();
  }

  @Override public List<Software> readSoftwares()
  {
    return client.readSoftwares();
  }

  @Override public List<Book> readBooksByTitle(String searchString)
  {
    return client.readBooksByTitle(searchString);
  }

  @Override public List<Movie> readMoviesByTitle(String searchString)
  {
    return client.readMoviesByTitle(searchString);
  }

  @Override public List<CD> readCDsByName(String searchString)
  {
    return client.readCDsByName(searchString);
  }

  @Override public List<Software> readSoftwaresByName(String searchString)
  {
    return client.readSoftwaresByName(searchString);
  }

  @Override public Book readBookByTitle(String searchString)
  {
    return client.readBookByTitle(searchString);
  }

  @Override public Movie readMovieByTitle(String searchString)
  {
    return client.readMovieByTitle(searchString);
  }

  @Override public CD readCDByName(String searchString)
  {
    return client.readCDByName(searchString);
  }

  @Override public Software readSoftwareByName(String searchString)
  {
    return client.readSoftwareByName(searchString);
  }

  @Override public void update(String tableName, String whereClause, Object obj)
  {
    client.update(tableName, whereClause, obj);
  }

  @Override public void delete(String tableName, String product_hash)
  {
    client.delete(tableName, product_hash);
  }

  @Override public void insert(String tableName, Object obj)
  {
    client.insert(tableName, obj);
  }

  @Override public Customer readCustomerInfo(String email)
  {
    return client.readCustomerInfo(email);
  }

  @Override public void changeCustomerInfo(String email,String f_name, String l_name, String phone)
  {
    client.changeCustomerInfo(email, f_name, l_name, phone);
  }

  @Override public void addReview(String product, Review review)
  {
    client.addReview(product, review);
  }

  @Override public List<Review> readReview(String product)
  {
    return client.readReview(product);
  }

  @Override public List<Review> readReviewsByProductName(String searchString,
      String product)
  {
    return client.readReviewsByProductName(searchString, product);
  }

  @Override public void removeReview(Review review, String product)
  {
    client.removeReview(review, product);
  }

  @Override
  public String getEmail()
  {
    return client.getEmail();
  }
}
