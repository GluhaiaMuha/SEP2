package client.model;

import client.network.Client;
import shared.transferObj.Customer;
import shared.transferObj.User;

public class LibraryModelManager implements LibraryModel
{
  private Client client;

  public LibraryModelManager(Client client)
  {
    this.client = client;
    this.client.startClient();
  }

  @Override
  public User readUserRegister(String email)
  {
    return client.readUserRegister(email);
  }

  @Override
  public void newCustomer(Customer customer)
  {
    client.newCustomer(customer);
  }

  @Override
  public User readUserLogin(String email, String password)
  {
    return client.readUserLogin(email, password);
  }
}
