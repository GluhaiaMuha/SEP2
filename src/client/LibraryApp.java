package client;


import client.core.ClientFactory;
import client.core.ModelFactory;
import client.core.ViewHandler;
import client.core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class LibraryApp extends Application
{
  private ClientFactory cf;

  @Override
  public void start(Stage stage) throws Exception
  {
    ViewHandler.getInstance().start();
  }

  @Override
  public void stop() throws Exception {
    super.stop();
    System.out.println("Exit");
    ClientFactory.getInstance().getClient().unRegisterClient();
  }
}
