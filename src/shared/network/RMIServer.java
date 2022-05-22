package shared.network;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

public interface RMIServer extends Remote
{
  void registerClient(ClientCallback clientCallback) throws RemoteException;

  void unRegisterClient(ClientCallback clientCallback) throws  RemoteException;

  void registerCustomer(String email,String f_name, String l_name, String phone, String password, String type) throws RemoteException, SQLException;
}
