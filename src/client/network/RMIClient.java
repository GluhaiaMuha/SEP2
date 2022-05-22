package client.network;

import shared.network.ClientCallback;
import shared.network.RMIServer;
import shared.transferObj.User;

import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

public class RMIClient implements Client, ClientCallback
{
  private PropertyChangeSupport support;
  private RMIServer server;

  public RMIClient()
  {
    support = new PropertyChangeSupport(this);
  }

  @Override public void startClient()
  {
    try {
      UnicastRemoteObject.exportObject(this, 0);
      Registry registry = LocateRegistry.getRegistry("localhost", 1099);
      server = (RMIServer) registry.lookup("Server");
      server.registerClient(this);
    } catch (RemoteException | NotBoundException e) {
      e.printStackTrace();
    }
  }

  @Override public void unRegisterClient()
  {
    try {
      server.unRegisterClient(this);
    } catch (RemoteException e) {
      e.printStackTrace();
    }
  }

  public void registerCustomer(String email,String f_name, String l_name, String phone, String password, String type) throws RemoteException, SQLException
  {
    server.registerCustomer(email, f_name, l_name, phone, password, type);
  }

  public User getInfo(String email) throws SQLException, RemoteException
  {
    return server.getInfo(email);
  }
}
