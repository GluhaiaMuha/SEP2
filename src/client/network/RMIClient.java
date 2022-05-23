package client.network;

import shared.network.ClientCallback;
import shared.network.RMIServer;

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
}
