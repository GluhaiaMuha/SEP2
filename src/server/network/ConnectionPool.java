package server.network;

import shared.network.ClientCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Connection Pool class for the RMI Server
 */
public class ConnectionPool
{
  private List<ClientCallback> connections;

  public ConnectionPool()
  {
    connections = new ArrayList<>();
  }

  /**
   * Add Client to ConPool
   *
   * @param client Client
   */
  public synchronized void addClient(ClientCallback client)
  {
    connections.add(client);
  }

  /**
   * Remove Client from ConPool
   *
   * @param client Client
   */
  public synchronized void removeClient(ClientCallback client)
  {
    connections.remove(client);
  }
}
