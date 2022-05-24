package client.network;

import shared.transferObj.Customer;
import shared.transferObj.Rent;
import shared.transferObj.User;

import java.sql.Date;
import java.util.List;

public interface Client
{
  void startClient();

  void unRegisterClient();

  User readUserRegister(String email);

  void newCustomer(Customer customer);

  User readUserLogin(String email, String password);

  List<Rent> readCustomerRents(String customer_email, String product);

  void rentProduct(String product, Rent rent);

  String getEmail();
}
