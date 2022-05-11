package client.model;

import client.network.Client;

public class LibraryModelManager implements LibraryModel
{
  private Client client;

  public LibraryModelManager(Client client)
  {
    this.client = client;
    this.client.startClient();
  }

  @Override public boolean login(String username, String password)
  {
    if(username.equals("aaaaa") && password.equals("aaaaa")){
      return true;
    }
    return false;
  }
}
