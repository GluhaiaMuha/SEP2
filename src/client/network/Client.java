package client.network;

import shared.transferObj.Customer;
import shared.transferObj.User;

public interface Client
{
  void startClient();

  void unRegisterClient();

  User readUserRegister(String email);

  void newCustomer(Customer customer);

  User readUserLogin(String email, String password);

  String getEmail();
}
