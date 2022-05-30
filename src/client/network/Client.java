package client.network;

import shared.transferObj.*;

import java.util.List;

public interface Client
{
  void startClient();

  void unRegisterClient();

  User readUserRegister(String email);

  void newCustomer(Customer customer);

  User readUserLogin(String email, String password);

  List<Rent> readCustomerRents(String customer_email, String product);

  List<Rent> readRents(String product);

  void removeRent(Rent rent, String product);

  void updateProductAmount(String tableName, String productHash);

  void rentProduct(String product, Rent rent);

  List<Object> read(String tableName);

  List<Book> readBooks();

  List<Movie> readMovies();

  List<CD> readCDS();

  List<Software> readSoftwares();

  List<Book> readBooksByTitle(String searchString);

  List<Movie> readMoviesByTitle(String searchString);

  List<CD> readCDsByName(String searchString);

  List<Software> readSoftwaresByName(String searchString) ;

  Book readBookByTitle(String searchString);

  Movie readMovieByTitle(String searchString);

  CD readCDByName(String searchString);

  Software readSoftwareByName(String searchString);

  void update(String tableName, String whereClause, Object obj);

  void delete(String tableName, String product_hash);

  void insert(String tableName, Object obj);

  Customer readCustomerInfo(String email);

  void changeCustomerInfo(String email,String f_name, String l_name, String phone);

  void addReview(String product, Review review);

  List<Review> readReview(String product);

  List<Review> readReviewsByProductName(String searchString, String product);

  void removeReview(Review review, String product);

  Object readProductByHash(String table, String productHash);

  String getEmail();
}
