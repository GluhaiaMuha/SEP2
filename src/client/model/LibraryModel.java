package client.model;

import shared.transferObj.User;

import java.rmi.RemoteException;
import java.sql.SQLException;

public interface LibraryModel
{
  void registerCustomer(String email,String f_name, String l_name, String phone, String password, String type)
      throws SQLException, RemoteException;

  User getInfo(String email) throws SQLException, RemoteException;
}
