package server.network;

import shared.network.ClientCallback;
import shared.network.RMIServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

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
}
