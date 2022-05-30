package client.core;

import client.network.Client;
import client.network.RMIClient;

/**
 * Factory for creating Client Objects without exposing the creation logic to the client
 */
public class ClientFactory
{
  private static ClientFactory instance;

  static {
    instance = new ClientFactory();
  }
  public static ClientFactory getInstance(){
    return instance;
  }

  private Client client;

  private ClientFactory() {
  }

  public Client getClient()
  {
    if(client ==null){
      client = new RMIClient();
    }
    return client;
  }
}
