package client.model;

import shared.transferObj.Customer;
import shared.transferObj.User;

public interface LibraryModel
{
  User readUserRegister(String email);

  void newCustomer(Customer customer);

  User readUserLogin(String email, String password);
}
