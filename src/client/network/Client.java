package client.network;

import java.rmi.RemoteException;
import java.sql.SQLException;

public interface Client
{
  void startClient();

  void unRegisterClient();

  void registerCustomer(String email,String f_name, String l_name, String phone, String password, String type) throws
      RemoteException, SQLException;
}
