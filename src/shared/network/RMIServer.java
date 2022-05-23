package shared.network;

import shared.transferObj.Customer;
import shared.transferObj.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

public interface RMIServer extends Remote
{
  void registerClient(ClientCallback clientCallback) throws RemoteException;

  void unRegisterClient(ClientCallback clientCallback) throws  RemoteException;

  User readUserRegister(String email) throws RemoteException;

  void newCustomer(Customer customer) throws RemoteException;

  User readUserLogin(String email, String password) throws RemoteException;
}
