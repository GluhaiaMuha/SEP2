package server.network;

import shared.network.ClientCallback;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool
{
  private List<ClientCallback> connections;

  public ConnectionPool()
  {
    connections = new ArrayList<>();
  }

  public synchronized void addClient(ClientCallback client)
  {
    connections.add(client);
  }

  public synchronized void removeClient(ClientCallback client)
  {
    connections.remove(client);
  }
}
