package shared.network;

import shared.transferObj.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RMIServer extends Remote
{
  void registerClient(ClientCallback clientCallback) throws RemoteException;

  void unRegisterClient(ClientCallback clientCallback) throws  RemoteException;

  User readUserRegister(String email) throws RemoteException;

  void newCustomer(Customer customer) throws RemoteException;

  User readUserLogin(String email, String password) throws RemoteException;

  List<Rent> readCustomerRents(String customer_email, String product) throws RemoteException;

  void removeRent(Rent rent, String product) throws RemoteException;

  void updateProductAmount(String tableName, String productHash) throws RemoteException;

  void rentProduct(String product, Rent rent) throws RemoteException;

  List<Object> read(String tableName) throws RemoteException;

  List<Book> readBooks() throws RemoteException;

  List<Movie> readMovies() throws RemoteException;

  List<CD> readCDS() throws RemoteException;

  List<Software> readSoftwares() throws RemoteException;

  List<Book> readBooksByTitle(String searchString) throws RemoteException;

  List<Movie> readMoviesByTitle(String searchString) throws RemoteException;

  List<CD> readCDsByName(String searchString) throws RemoteException;

  List<Software> readSoftwaresByName(String searchString) throws RemoteException;

  Book readBookByTitle(String searchString) throws RemoteException;

  Movie readMovieByTitle(String searchString) throws RemoteException;

  CD readCDByName(String searchString) throws RemoteException;

  Software readSoftwareByName(String searchString) throws RemoteException;

  void update(String tableName, String whereClause, Object obj) throws RemoteException;

  void delete(String tableName, String whereClause) throws RemoteException;

  void insert(String tableName, Object obj) throws RemoteException;

  Customer readCustomerInfo(String email) throws RemoteException;

  void changeCustomerInfo(String email,String f_name, String l_name, String phone) throws RemoteException;

  void addReview(String product, Review review) throws RemoteException;

  List<Review> readReview(String product) throws RemoteException;

  List<Review> readReviewsByProductName(String searchString, String product) throws RemoteException;

  void removeReview(Review review, String product) throws RemoteException;
}
