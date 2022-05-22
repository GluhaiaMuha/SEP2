package client.model;

import client.network.Client;
import shared.transferObj.User;

import java.rmi.RemoteException;
import java.sql.SQLException;

public class LibraryModelManager implements LibraryModel
{
  private Client client;

  public LibraryModelManager(Client client)
  {
    this.client = client;
    this.client.startClient();
  }

  public void registerCustomer(String email,String f_name, String l_name, String phone, String password, String type)
      throws SQLException, RemoteException
  {
    client.registerCustomer(email, f_name, l_name, phone, password, type);
  }

  public User getInfo(String email) throws SQLException, RemoteException
  {
    return client.getInfo(email);
  }
}
