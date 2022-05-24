package server.network;

import server.database.General.Register.RegisterDAOImpl;
import server.model.Customer.Loans.LoansModelImpl;
import server.model.Customer.RentProduct.RentProductModelImpl;
import server.model.General.Login.LoginModelImpl;
import server.model.General.Register.RegisterModelImpl;
import shared.network.ClientCallback;
import shared.network.RMIServer;
import shared.transferObj.Customer;
import shared.transferObj.Rent;
import shared.transferObj.User;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
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

  @Override
  public void rentProduct(String product, Rent rent)
  {
    RentProductModelImpl.getInstance().rentProduct(product, rent);
  }
}
