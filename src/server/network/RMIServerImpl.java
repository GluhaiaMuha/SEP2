package server.network;

import server.model.Customer.CustomerInfo.CustomerInfoImpl;
import server.model.Customer.Loans.LoansModelImpl;
import server.model.Customer.RentProduct.RentProductModelImpl;
import server.model.General.Login.LoginModelImpl;
import server.model.General.ProductInfo.ProductInfoModelImpl;
import server.model.General.Register.RegisterModelImpl;
import server.model.Librarian.ManageProducts.ManageProductsImpl;
import shared.network.ClientCallback;
import shared.network.RMIServer;
import shared.transferObj.*;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RMIServerImpl implements RMIServer
{
  private ConnectionPool connectionPool;

  public RMIServerImpl() throws RemoteException
  {
    UnicastRemoteObject.exportObject(this,0);
    connectionPool = new ConnectionPool();
  }

  public void startServer() throws RemoteException, AlreadyBoundException
  {
    Registry registry = LocateRegistry.createRegistry(1099);
    registry.bind("Server", this);
  }

  @Override
  public void registerClient(ClientCallback clientCallback)
  {
    connectionPool.addClient(clientCallback);
  }

  @Override
  public void unRegisterClient(ClientCallback clientCallback)
  {
    connectionPool.removeClient(clientCallback);
  }

  @Override
  public User readUserRegister(String email)
  {
    return RegisterModelImpl.getInstance().readUserRegister(email);
  }

  @Override
  public void newCustomer(Customer customer)
  {
    RegisterModelImpl.getInstance().newCustomer(customer);
  }

  @Override
  public User readUserLogin(String email, String password)
  {
    return LoginModelImpl.getInstance().readUserLogin(email, password);
  }

  @Override
  public List<Rent> readCustomerRents(String customer_email, String product)
  {
    return LoansModelImpl.getInstance().readCustomerRents(customer_email, product);
  }

  @Override public void removeRent(Rent rent, String product)
  {
    LoansModelImpl.getInstance().removeRent(rent, product);
  }

  @Override
  public void rentProduct(String product, Rent rent)
  {
    RentProductModelImpl.getInstance().rentProduct(product, rent);
  }

  @Override public List<Object> read(String tableName)
  {
    return ProductInfoModelImpl.getInstance().read(tableName);
  }

  @Override public List<Book> readBooks()
  {
    return ProductInfoModelImpl.getInstance().readBooks();
  }

  @Override public List<Movie> readMovies()
  {
    return ProductInfoModelImpl.getInstance().readMovies();
  }

  @Override public List<CD> readCDS()
  {
    return ProductInfoModelImpl.getInstance().readCDS();
  }

  @Override public List<Software> readSoftwares()
  {
    return ProductInfoModelImpl.getInstance().readSoftwares();
  }

  @Override public List<Book> readBooksByTitle(String searchString)
  {
    return ProductInfoModelImpl.getInstance().readBooksByTitle(searchString);
  }

  @Override public List<Movie> readMoviesByTitle(String searchString)
  {
    return ProductInfoModelImpl.getInstance().readMoviesByTitle(searchString);
  }

  @Override public List<CD> readCDsByName(String searchString)
  {
    return ProductInfoModelImpl.getInstance().readCDsByName(searchString);
  }

  @Override public List<Software> readSoftwaresByName(String searchString)
  {
    return ProductInfoModelImpl.getInstance().readSoftwaresByName(searchString);
  }

  @Override public Book readBookByTitle(String searchString)
  {
    return ProductInfoModelImpl.getInstance().readBookByTitle(searchString);
  }

  @Override public Movie readMovieByTitle(String searchString)
  {
    return ProductInfoModelImpl.getInstance().readMovieByTitle(searchString);
  }

  @Override public CD readCDByName(String searchString)
  {
    return ProductInfoModelImpl.getInstance().readCDByName(searchString);
  }

  @Override public Software readSoftwareByName(String searchString)
  {
    return ProductInfoModelImpl.getInstance().readSoftwareByName(searchString);
  }

  @Override public void update(String tableName, String whereClause, Object obj)
  {
    ManageProductsImpl.getInstance().update(tableName, whereClause, obj);
  }

  @Override public void delete(String tableName, String whereClause)
  {
    ManageProductsImpl.getInstance().delete(tableName, whereClause);
  }

  @Override public void insert(String tableName, Object obj)
  {
    ManageProductsImpl.getInstance().insert(tableName, obj);
  }

  @Override public Customer readCustomerInfo(String email)
  {
    return CustomerInfoImpl.getInstance().readCustomerInfo(email);
  }
}
