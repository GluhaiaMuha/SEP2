package shared.network;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIServer extends Remote
{
  void registerClient(ClientCallback clientCallback) throws RemoteException;

  void unRegisterClient(ClientCallback clientCallback) throws  RemoteException;
}
