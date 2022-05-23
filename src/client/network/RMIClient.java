package client.network;

import shared.network.ClientCallback;
import shared.network.RMIServer;
import shared.transferObj.Customer;
import shared.transferObj.User;

import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIClient implements Client, ClientCallback
{
  private PropertyChangeSupport support;
  private RMIServer server;

  private String email;

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

  @Override
  public User readUserRegister(String email)
  {
    User user = null;
    try
    {
      user = server.readUserRegister(email);
      if (user==null)
      {
        this.email = email;
      }
    } catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return user;
  }

  @Override
  public void newCustomer(Customer customer)
  {
    try
    {
      server.newCustomer(customer);
    }catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override
  public User readUserLogin(String email, String password)
  {
    User user = null;
    try
    {
      user = server.readUserLogin(email, password);
      if (user!=null)
      {
        this.email = email;
      }
    } catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return user;
  }

  @Override
  public String getEmail()
  {
    return email;
  }
}
